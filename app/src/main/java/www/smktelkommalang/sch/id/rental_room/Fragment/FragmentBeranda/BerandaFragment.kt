package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentBeranda

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import www.smktelkommalang.sch.id.rental_room.Adapter.RecyclerViewRuanganAdapter
import www.smktelkommalang.sch.id.rental_room.Adapter.ViewPagerAdapter
import www.smktelkommalang.sch.id.rental_room.Database.RuanganDatabase
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.OpeningPage1Fragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.OpeningPage2Fragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.OpeningPage3Fragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan.DetailRuangan.PemesananDetail
import www.smktelkommalang.sch.id.rental_room.Model.Ruangan.RuanganData
import www.smktelkommalang.sch.id.rental_room.R
import www.smktelkommalang.sch.id.rental_room.ViewModel.Authenticate.Register.RegisterActivity

class BerandaFragment : Fragment() {
    private lateinit var ruanganDatabase: RuanganDatabase
    private lateinit var recyclerView: RecyclerView
    private lateinit var ruanganDataList: ArrayList<RuanganData>
    private lateinit var recyclerViewRuanganAdapter: RecyclerViewRuanganAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var dotsIndicator: DotsIndicator
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        viewPager = rootView.findViewById(R.id.viewPager)
        dotsIndicator = rootView.findViewById(R.id.dotsIndicator)
        recyclerView = rootView.findViewById(R.id.recycler_view)
        
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        
        ruanganDataList = ArrayList()
        ruanganDatabase = RuanganDatabase()
        recyclerViewRuanganAdapter = RecyclerViewRuanganAdapter(ruanganDataList)
        recyclerView.adapter = recyclerViewRuanganAdapter

        rootView.findViewById<CardView>(R.id.information_card1).setOnClickListener {
            val intent = Intent(requireContext(), KetentuanActivity::class.java)
            startActivity(intent)
        }

        rootView.findViewById<CardView>(R.id.alur_card).setOnClickListener {
            val intent = Intent(requireContext(), AlurActivity::class.java)
            startActivity(intent)
        }
        readDataFromFirebase()
        setupTab()
        return rootView

    }
    
    private fun readDataFromFirebase() {
        ruanganDatabase.getRuanganData { dataList ->
            ruanganDataList.clear()
            ruanganDataList.addAll(dataList)
            recyclerViewRuanganAdapter.notifyDataSetChanged()
        }
    }
    
    private fun setupTab() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        
        adapter.addFragment(OpeningPage1Fragment(), "1st")
        adapter.addFragment(OpeningPage2Fragment(), "2nd")
        adapter.addFragment(OpeningPage3Fragment(), "3rd")
        
        viewPager.adapter = adapter
        dotsIndicator.setViewPager(viewPager)
    }



}

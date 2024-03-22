package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import www.smktelkommalang.sch.id.rental_room.Adapter.RecyclerViewRuanganAdapter
import www.smktelkommalang.sch.id.rental_room.Database.RuanganDatabase
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan.DetailRuangan.DetailRuanganActivity
import www.smktelkommalang.sch.id.rental_room.Model.Ruangan.RuanganData
import www.smktelkommalang.sch.id.rental_room.R

class RuanganFragment : Fragment() {
    
    private lateinit var ruanganDatabase: RuanganDatabase
    private var recyclerView: RecyclerView? = null
    private lateinit var movieList: ArrayList<RuanganData>
    private lateinit var adapter: RecyclerViewRuanganAdapter // Declare the adapter as lateinit
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the fragment's layout
        return inflater.inflate(R.layout.fragment_ruangan, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        movieList = ArrayList()
        ruanganDatabase = RuanganDatabase()
        recyclerView = view.findViewById(R.id.ruangan)
        adapter = RecyclerViewRuanganAdapter(movieList)
        adapter.setOnItemClickListener { ruanganData ->
            val intent = Intent(requireContext(), DetailRuanganActivity::class.java)
            val modifiedTitle = ruanganData.title.replace(".", " ")
            intent.putExtra("title", modifiedTitle)
            intent.putExtra("image", ruanganData.image)
            intent.putExtra("kapasitas", ruanganData.kapasitas)
            intent.putExtra("ukuran", ruanganData.ukuran)
            startActivity(intent)
        }
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = adapter
        
        readDataFromFirebase()
    }
    
    
    private fun readDataFromFirebase() {
        ruanganDatabase.getRuanganData { dataList ->
            movieList.clear()
            movieList.addAll(dataList)
            adapter.notifyDataSetChanged()
        }
    }
}

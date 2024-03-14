package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import www.smktelkommalang.sch.id.rental_room.Adapter.ViewPagerAdapter
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaction.FragmentTransaksiDalamProses.TransaksiDalamProsesFragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaction.FragmentTransaksiSelesai.TransaksiSelesaiFragment
import www.smktelkommalang.sch.id.rental_room.databinding.FragmentTransaksiBinding

class TransaksiFragment : Fragment() {
    
    private lateinit var binding : FragmentTransaksiBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTransaksiBinding.inflate(inflater, container, false)
        setupTab()
        return binding.root
    }
    
    private fun setupTab() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(TransaksiDalamProsesFragment(),"Dalam Proses")
        adapter.addFragment(TransaksiSelesaiFragment(),"Selesai")
        
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}
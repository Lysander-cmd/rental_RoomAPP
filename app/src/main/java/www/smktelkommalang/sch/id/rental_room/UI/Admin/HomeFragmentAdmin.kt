package www.smktelkommalang.sch.id.rental_room.UI.Admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import www.smktelkommalang.sch.id.rental_room.Adapter.ViewPagerAdapter
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan.RuanganFragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaction.Admin.TransaksiAccFragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaction.Admin.TransaksiDoneFragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaction.FragmentTransaksiDalamProses.TransaksiDalamProsesFragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaction.FragmentTransaksiSelesai.TransaksiSelesaiFragment
import www.smktelkommalang.sch.id.rental_room.R
import www.smktelkommalang.sch.id.rental_room.databinding.FragmentHomeAdminBinding
import www.smktelkommalang.sch.id.rental_room.databinding.FragmentHomeBinding
import www.smktelkommalang.sch.id.rental_room.databinding.FragmentRuanganBinding
import www.smktelkommalang.sch.id.rental_room.databinding.FragmentTransaksiAdmindoneBinding
import www.smktelkommalang.sch.id.rental_room.databinding.FragmentTransaksiBinding


class HomeFragmentAdmin : Fragment() {

    private lateinit var binding : FragmentHomeAdminBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeAdminBinding.inflate(inflater, container, false)
        setupTab()
        return binding.root
    }

    private fun setupTab() {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(TransaksiAccFragment(),"Dalam Proses")
        adapter.addFragment(TransaksiDoneFragment(),"Selesai")

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}
package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import www.smktelkommalang.sch.id.rental_room.Adapter.ViewPagerAdapter
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.FragmentOpeningPage.OpeningPage1Fragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.FragmentOpeningPage.OpeningPage2Fragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.FragmentOpeningPage.OpeningPage3Fragment
import www.smktelkommalang.sch.id.rental_room.databinding.FragmentOpeningBinding

class OpeningFragment : Fragment() {
    
    private lateinit var binding: FragmentOpeningBinding
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOpeningBinding.inflate(layoutInflater)
        setupTab()
        return binding.root
    }
    
    private fun setupTab() {
        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.viewPager
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(OpeningPage1Fragment(),"Dalam Proses")
        adapter.addFragment(OpeningPage2Fragment(),"Dalam Proses")
        adapter.addFragment(OpeningPage3Fragment(),"Dalam Proses")
        
        viewPager.adapter = adapter
        dotsIndicator.setViewPager(viewPager)
    }
}
package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import www.smktelkommalang.sch.id.rental_room.Adapter.ViewPagerAdapter
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.FragmentOpeningPage.OpeningPage1Fragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.FragmentOpeningPage.OpeningPage2Fragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.FragmentOpeningPage.OpeningPage3Fragment

class OpeningActivity : AppCompatActivity() {
    lateinit var binding: OpeningActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = OpeningActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTab()
    }
    
    private fun setupTab() {
        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.viewPager
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(OpeningPage1Fragment(),"Dalam Proses")
        adapter.addFragment(OpeningPage2Fragment(),"Dalam Proses")
        adapter.addFragment(OpeningPage3Fragment(),"Dalam Proses")
        
        viewPager.adapter = adapter
        dotsIndicator.setViewPager(viewPager)
    }
    }
    
}
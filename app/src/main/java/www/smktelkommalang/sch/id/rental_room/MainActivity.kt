package www.smktelkommalang.sch.id.rental_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import www.smktelkommalang.sch.id.rental_room.Adapter.ViewPagerAdapter
import www.smktelkommalang.sch.id.rental_room.Fragment.Fragment.HomeFragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentProfile.ProfileFragment
//import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentProfile.ProfileFragment
import www.smktelkommalang.sch.id.rental_room.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTab()
    }

    private fun setupTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(),"Home")
        adapter.addFragment(ProfileFragment(),"Profile")

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        binding.tabs.getTabAt(0)!!.setIcon(R.drawable.ic_home)
        binding.tabs.getTabAt(1)!!.setIcon(R.drawable.ic_user)
    }
}
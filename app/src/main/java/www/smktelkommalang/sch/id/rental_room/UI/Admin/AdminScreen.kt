package www.smktelkommalang.sch.id.rental_room.UI.Admin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import www.smktelkommalang.sch.id.rental_room.Adapter.ViewPagerAdapter
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentProfile.ProfileFragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaction.TransaksiFragment
import www.smktelkommalang.sch.id.rental_room.databinding.ActivityMainBinding

class AdminScreen : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTab()
    }

    private fun setupTab() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment((HomeFragmentAdmin()),"Beranda")

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        binding.tabs.getTabAt(0)!!
        binding.tabs.getTabAt(1)!!
        binding.tabs.getTabAt(2)!!
        binding.tabs.getTabAt(3)!!
//            .setIcon(R.drawable.ic_user)

    }
}
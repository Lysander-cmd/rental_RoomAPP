package www.smktelkommalang.sch.id.rental_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import www.smktelkommalang.sch.id.rental_room.Adapter.ViewPagerAdapter
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentBeranda.BerandaFragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentProfile.ProfileFragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan.RuanganFragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaksi.TransaksiFragment
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
        adapter.addFragment(BerandaFragment(),"Beranda")
        adapter.addFragment(RuanganFragment(),"Ruangan")
        adapter.addFragment(TransaksiFragment(),"Transaksi")
        adapter.addFragment(ProfileFragment(),"Profile")

        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        binding.tabs.getTabAt(0)!!
        binding.tabs.getTabAt(1)!!
        binding.tabs.getTabAt(2)!!
        binding.tabs.getTabAt(3)!!
//            .setIcon(R.drawable.ic_user)
        
    }
}
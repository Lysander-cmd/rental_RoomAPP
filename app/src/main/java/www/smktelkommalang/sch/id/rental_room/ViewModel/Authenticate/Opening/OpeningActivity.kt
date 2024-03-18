package www.smktelkommalang.sch.id.rental_room.ViewModel.Authenticate.Opening

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import www.smktelkommalang.sch.id.rental_room.Adapter.ViewPagerAdapter
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.OpeningPage1Fragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.OpeningPage2Fragment
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentOpening.OpeningPage3Fragment
import www.smktelkommalang.sch.id.rental_room.MainActivity
import www.smktelkommalang.sch.id.rental_room.ViewModel.Authenticate.Login.LoginActivity
import www.smktelkommalang.sch.id.rental_room.databinding.ActivityLoginBinding
import www.smktelkommalang.sch.id.rental_room.databinding.ActivityMainBinding
import www.smktelkommalang.sch.id.rental_room.databinding.ActivityOpeningBinding

class OpeningActivity : AppCompatActivity() {
    
    lateinit var binding: ActivityOpeningBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpeningBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupTab()
    }
    
    private fun setupTab() {
        var currentPage = 0
        val btnSkip = binding.btnSkip
        val btnNext = binding.btnNext
        val viewPager = binding.viewPager
        val dotsIndicator = binding.dotsIndicator
        val adapter = ViewPagerAdapter(supportFragmentManager)
        
        adapter.addFragment(OpeningPage1Fragment(), "1st")
        adapter.addFragment(OpeningPage2Fragment(), "2nd")
        adapter.addFragment(OpeningPage3Fragment(), "3rd")
        
        viewPager.adapter = adapter
        dotsIndicator.setViewPager(viewPager)
        
        btnNext.setOnClickListener {
            if (currentPage == 2) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                currentPage++
                viewPager.currentItem = currentPage
                if (currentPage == 2) {
                    btnNext.text = "Masuk"
                    btnSkip.visibility = View.INVISIBLE
                } else {
                    btnNext.text = "Selanjutnya"
                }
            }
        }
        
        btnSkip.setOnClickListener {
            currentPage = 2
            viewPager.currentItem = 2
            btnSkip.visibility = View.INVISIBLE
            btnNext.text = "Masuk"
        }
    }
}


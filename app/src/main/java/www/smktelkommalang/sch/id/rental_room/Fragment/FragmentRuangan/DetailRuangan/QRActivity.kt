package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan.DetailRuangan

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import www.smktelkommalang.sch.id.rental_room.Fragment.FragmentBeranda.BerandaFragment
import www.smktelkommalang.sch.id.rental_room.MainActivity


import www.smktelkommalang.sch.id.rental_room.R

class QRActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qractivity)



    }
    fun onButtonKembaliClicked(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
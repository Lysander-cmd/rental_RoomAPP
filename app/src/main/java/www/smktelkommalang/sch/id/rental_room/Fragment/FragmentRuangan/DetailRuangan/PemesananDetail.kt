package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan.DetailRuangan

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import www.smktelkommalang.sch.id.rental_room.R

class PemesananDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemesanan_detail)

    }
    fun onButtonSyaratClicked(view: View) {
        // Buat Intent untuk memulai aktivitas baru (activity_pemesanan_detail.xml)
        val intent = Intent(this, SyaratActivity::class.java)
        startActivity(intent)
    }
}
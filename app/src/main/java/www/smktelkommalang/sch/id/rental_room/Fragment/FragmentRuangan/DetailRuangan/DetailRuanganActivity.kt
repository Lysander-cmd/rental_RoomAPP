package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan.DetailRuangan

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import www.smktelkommalang.sch.id.rental_room.Database.RuanganDatabase
import www.smktelkommalang.sch.id.rental_room.R

class DetailRuanganActivity : AppCompatActivity() {
    
    private lateinit var ruanganDB: RuanganDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_ruangan)
        
        val title = findViewById<TextView>(R.id.titleroom)
        val image = findViewById<ImageView>(R.id.gambarRuangan)
        val deskripsi = findViewById<TextView>(R.id.descriptionroom)
        val harga = findViewById<TextView>(R.id.harga)
        
        val ruanganTitle = intent.getStringExtra("title") ?: ""
        ruanganDB = RuanganDatabase()
        ruanganDB.getRuanganDetailData(ruanganTitle) { ruanganDataList ->
            if (ruanganDataList.isNotEmpty()) {
                val ruanganDetailData = ruanganDataList[0]
                title.text = ruanganDetailData.title
                deskripsi.text = ruanganDetailData.deskripsi
                harga.text = ruanganDetailData.harga
                
                // Load image using Glide
                Glide.with(this)
                    .load(ruanganDetailData.image)
                    .placeholder(R.drawable.logo)
                    .into(image)
            }
        }
    }

    fun onButtonAjukanClicked(view: View) {
        val intent = Intent(this, PemesananDetail::class.java)
        startActivity(intent)
    }
}
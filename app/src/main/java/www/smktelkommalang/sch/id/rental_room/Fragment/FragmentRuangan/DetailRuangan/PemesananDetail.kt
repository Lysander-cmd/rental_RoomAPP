package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan.DetailRuangan

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import com.google.firebase.auth.FirebaseAuth
import www.smktelkommalang.sch.id.rental_room.Database.RuanganDatabase
import www.smktelkommalang.sch.id.rental_room.Database.TransaksiDatabase
import www.smktelkommalang.sch.id.rental_room.R

class PemesananDetail : AppCompatActivity() {
    private lateinit var transaksiDB: TransaksiDatabase
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemesanan_detail)
        val btnAjukan = findViewById<MaterialCardView>(R.id.btn_ajukanNext)
        val image = findViewById<ImageView>(R.id.gambarRuangan)
        val time = findViewById<EditText>(R.id.waktuPeminjaman)
        val tanggal = findViewById<EditText>(R.id.tanggalPeminjaman)
        val keperluan = findViewById<EditText>(R.id.keperluanPeminjaman)
        val peminjam = findViewById<EditText>(R.id.namaPeminjam)
        
        val imageLink = intent.getStringExtra("image") ?: ""
        val kapasitas = intent.getStringExtra("kapasitas") ?: ""
        val ukuran = intent.getStringExtra("ukuran") ?: ""
        
        findViewById<TextView>(R.id.kapasitasRuangan).text = kapasitas
        findViewById<TextView>(R.id.ukuranRuangan).text = ukuran
        
        Glide.with(this)
            .load(imageLink)
            .placeholder(R.drawable.logo)
            .into(image)
        
        transaksiDB = TransaksiDatabase()
        btnAjukan.setOnClickListener {
            val peminjamText = peminjam.text.toString()
            val keperluanText = keperluan.text.toString()
            val tanggalText = tanggal.text.toString()
            val timeText = time.text.toString()
            
            //Validasi email
            if (peminjamText.isEmpty()) {
                peminjam.error = "Peminjam harus diisi"
                peminjam.requestFocus()
                return@setOnClickListener
            }
            
            //Validasi email tidak sesuai
            if (keperluanText.isEmpty()) {
                keperluan.error = "Keperluan harus diisi"
                keperluan.requestFocus()
                return@setOnClickListener
            }
            
            //Validasi password
            if (tanggalText.isEmpty()) {
                tanggal.error = "Tanggal harus diisi"
                tanggal.requestFocus()
                return@setOnClickListener
            }
            
            if (timeText.isEmpty()) {
                time.error = "Waktu harus diisi"
                time.requestFocus()
                return@setOnClickListener
            }
            
            val title = intent.getStringExtra("title") ?: ""
            val image = intent.getStringExtra("image") ?: ""
            
            transaksiDB.createTransaksi(
                image = image,
                title = title,
                date = tanggal.text.toString(),
                time = time.text.toString(),
                status = "Dalam Proses",
                keperluan = keperluan.text.toString(),
                peminjam = peminjam.text.toString()
            )
            
            val intent = Intent(this, SyaratActivity::class.java)
            startActivity(intent)
        }
    }
}
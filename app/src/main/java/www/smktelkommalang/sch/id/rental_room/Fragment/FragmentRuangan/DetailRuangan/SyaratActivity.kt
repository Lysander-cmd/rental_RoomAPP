package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan.DetailRuangan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.card.MaterialCardView
import www.smktelkommalang.sch.id.rental_room.R

class SyaratActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_syarat)
        val checkBox = findViewById<CheckBox>(R.id.my_checkbox)
        val button = findViewById<MaterialCardView>(R.id.btn_ajukanNext)

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            button.isEnabled = isChecked
        }

        button.setOnClickListener {
            // Periksa apakah checkbox telah dicentang sebelum berpindah ke layout baru
            if (checkBox.isChecked) {
                // Pindah ke layout baru jika checkbox telah dicentang
                val intent = Intent(this, LoadingQRActivity::class.java)
                startActivity(intent)
        }
    }
}
}
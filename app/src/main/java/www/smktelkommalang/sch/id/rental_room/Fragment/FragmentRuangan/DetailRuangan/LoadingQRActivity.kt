package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan.DetailRuangan

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import www.smktelkommalang.sch.id.rental_room.R
import www.smktelkommalang.sch.id.rental_room.ViewModel.Authenticate.Opening.OpeningActivity

class LoadingQRActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_qractivity)
        val ivNote = findViewById<ImageView>(R.id.imgldngQR)
        ivNote.alpha = 0f
        ivNote.animate().setDuration(1500).alpha(1f).withEndAction {
            val intent = Intent(this, QRActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}
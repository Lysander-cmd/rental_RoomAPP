package www.smktelkommalang.sch.id.rental_room.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import www.smktelkommalang.sch.id.rental_room.Model.Login.LoginActivity
import www.smktelkommalang.sch.id.rental_room.R
import www.smktelkommalang.sch.id.rental_room.databinding.FragmentOpeningBinding

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 1500 // 1.5 seconds
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        
        val ivNote = findViewById<ImageView>(R.id.iv_note)
        ivNote.alpha = 0f
        ivNote.animate().setDuration(1500).alpha(1f).withEndAction {
            val intent = Intent(this, FragmentOpeningBinding::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}
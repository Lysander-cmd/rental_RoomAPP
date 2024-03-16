package www.smktelkommalang.sch.id.rental_room.ViewModel.Authenticate.Login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import www.smktelkommalang.sch.id.rental_room.MainActivity
import www.smktelkommalang.sch.id.rental_room.ViewModel.Authenticate.Register.RegisterActivity
import www.smktelkommalang.sch.id.rental_room.ViewModel.Authenticate.ResetPassword.ResetPasswordActivity
import www.smktelkommalang.sch.id.rental_room.UI.Admin.ActivityAdminScreen

import www.smktelkommalang.sch.id.rental_room.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth
    
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        
        auth = FirebaseAuth.getInstance()
        
        binding.forgotPassword.setOnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }
        
        binding.tvToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        
        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmailLogin.text.toString()
            val password = binding.edtPasswordLogin.text.toString()
            
            //Validasi email
            if (email.isEmpty()) {
                binding.edtEmailLogin.error = "Email Harus Diisi"
                binding.edtEmailLogin.requestFocus()
                return@setOnClickListener
            }
            
            //Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtPasswordLogin.error = "Email Tidak Valid"
                binding.edtPasswordLogin.requestFocus()
                return@setOnClickListener
            }
            
            //Validasi password
            if (password.isEmpty()) {
                binding.edtPasswordLogin.error = "Password Harus Diisi"
                binding.edtPasswordLogin.requestFocus()
                return@setOnClickListener
            }
            
            LoginFirebase(email, password)
        }
    }
    
    private fun LoginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    if (email == "admin@gmail.com") {
                        Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, ActivityAdminScreen::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
                
            }
    }
}
package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentProfile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import www.smktelkommalang.sch.id.rental_room.Database.UserDatabase
import www.smktelkommalang.sch.id.rental_room.ViewModel.Authenticate.Login.LoginActivity
import www.smktelkommalang.sch.id.rental_room.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    lateinit var auth: FirebaseAuth
    private val userDatabase = UserDatabase()
    private val binding get() = _binding!!
    
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        
        if (auth.currentUser != null) {
            userDatabase.readUsername(auth.currentUser?.uid.toString(), binding.edtName)
            binding.edtEmail.text = auth.currentUser?.email
        }
        binding.btnLogout.setOnClickListener() {
            btnLogout()
        }
    }
    
    private fun btnLogout() {
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        val intent = Intent(context, LoginActivity::class.java)
        startActivity(intent)
        activity?.finish()
    }
    
}
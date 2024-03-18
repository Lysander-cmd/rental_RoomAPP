package www.smktelkommalang.sch.id.rental_room.Database

import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UserDatabase {
    private var auth = FirebaseAuth.getInstance()
    private var db: DatabaseReference = FirebaseDatabase.getInstance().reference
    
    fun createUsername(username: String) {
        db.child("users").child(auth.currentUser?.uid.toString()).child("username")
            .setValue(username)
    }
    
    fun readUsername(userId: String, textView: TextView) {
        db = db.child("users")
        db.child(userId).get().addOnSuccessListener {
            if (it.exists()) {
                val username = it.child("username").value
                textView.text = username.toString()
            } else {
                textView.text = "NULL"
            }
        }.addOnFailureListener {
            textView.text = "went wrong"
        }
    }
}
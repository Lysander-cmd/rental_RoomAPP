package www.smktelkommalang.sch.id.rental_room.Database

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Database {
    private var auth = FirebaseAuth.getInstance()
    private lateinit var db: DatabaseReference
    
    fun addUsername(username: String) {
        db = FirebaseDatabase.getInstance().reference.child("users")
            .child(auth.currentUser.toString())
        
    }
}
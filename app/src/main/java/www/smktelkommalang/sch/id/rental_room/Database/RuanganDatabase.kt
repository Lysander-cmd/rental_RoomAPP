package www.smktelkommalang.sch.id.rental_room.Database

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import www.smktelkommalang.sch.id.rental_room.Model.Ruangan.RuanganData
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiData

class RuanganDatabase {
    private lateinit var db: DatabaseReference
    
    fun getRuanganData(
        resp: (ArrayList<RuanganData>) -> Unit,
    ) {
        db = FirebaseDatabase.getInstance().reference
        val ruanganRef = db.child("ruangan")
        ruanganRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val ruanganDataList = ArrayList<RuanganData>()
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val title: String =
                            dataSnapshot.child("title").getValue(String::class.java).toString()
                        val ukuran: String =
                            dataSnapshot.child("ukuran").getValue(String::class.java).toString()
                        val kapasitas: String =
                            dataSnapshot.child("kapasitas").getValue(String::class.java).toString()
                        val image: String =
                            dataSnapshot.child("image").getValue(String::class.java).toString()
                        val ruanganData =
                            RuanganData(
                                image = image,
                                ukuran = ukuran,
                                kapasitas = kapasitas,
                                title = title
                            )
                        ruanganDataList.add(ruanganData)
                    }
                }
                resp(ruanganDataList)
            }
            
            override fun onCancelled(error: DatabaseError) {
                println("Error: ${error.message}")
            }
        })
    }
    
    fun getRuanganDetailData(
        resp: (ArrayList<RuanganData>) -> Unit,
    ) {
        db = FirebaseDatabase.getInstance().reference
        val ruanganRef = db.child("ruangan")
        ruanganRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val ruanganDataList = ArrayList<RuanganData>()
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val title: String =
                            dataSnapshot.child("title").getValue(String::class.java).toString()
                        val ukuran: String =
                            dataSnapshot.child("ukuran").getValue(String::class.java).toString()
                        val kapasitas: String =
                            dataSnapshot.child("kapasitas").getValue(String::class.java).toString()
                        val image: String =
                            dataSnapshot.child("image").getValue(String::class.java).toString()
                        val ruanganData =
                            RuanganData(
                                image = image,
                                ukuran = ukuran,
                                kapasitas = kapasitas,
                                title = title
                            )
                        ruanganDataList.add(ruanganData)
                    }
                }
                resp(ruanganDataList)
            }
            
            override fun onCancelled(error: DatabaseError) {
                println("Error: ${error.message}")
            }
        })
    }
}
package www.smktelkommalang.sch.id.rental_room.Database

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiData

class AdminDatabase {
    private lateinit var db: DatabaseReference
    
    fun updateStatus(status: String, index: Int) {
        db = FirebaseDatabase.getInstance().reference
        val transaksiRef = db.child("transaksi")
        
        transaksiRef.orderByKey().limitToFirst(index)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    var count = 0
                    for (childSnapshot in dataSnapshot.children) {
                        for (childSnapshot2 in childSnapshot.children) {
                            if (++count == index) {
                                // Buat map untuk meng-update status saja
                                val updates = HashMap<String, Any>()
                                updates["status"] = status.trim()
                                
                                // Update child node yang sesuai dengan map yang sudah dibuat
                                transaksiRef.child(childSnapshot2.key.toString())
                                    .updateChildren(updates)
                                break
                            }
                        }
                        if (count == index) break
                    }
                }
                
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        
    }
    
    fun getTransaksiData(
        state: Array<String>,
        resp: (ArrayList<TransaksiData>) -> Unit,
    ) {
        db = FirebaseDatabase.getInstance().reference
        val transaksiRef = db.child("transaksi")
        transaksiRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val transaksiDataList = ArrayList<TransaksiData>()
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        for (dataSnapshot2 in dataSnapshot.children) {
                            val status: String =
                                dataSnapshot2.child("status").getValue(String::class.java).toString()
                            if (status in state) {
                                val title: String =
                                    dataSnapshot2.child("title").getValue(String::class.java)
                                        .toString()
                                val date: String =
                                    dataSnapshot2.child("date").getValue(String::class.java)
                                        .toString()
                                val time: String =
                                    dataSnapshot2.child("time").getValue(String::class.java)
                                        .toString()
                                val image: String =
                                    dataSnapshot2.child("image").getValue(String::class.java)
                                        .toString()
                                val transaksiData =
                                    TransaksiData(title, date, time, status, image)
                                transaksiDataList.add(transaksiData)
                            }
                        }
                    }
                    resp(transaksiDataList)
                }
            }
            
            override fun onCancelled(error: DatabaseError) {
                println("Error: ${error.message}")
            }
        })
    }
}
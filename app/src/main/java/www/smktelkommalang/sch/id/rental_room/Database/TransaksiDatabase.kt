package www.smktelkommalang.sch.id.rental_room.Database

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiData

class TransaksiDatabase {
    private var auth = FirebaseAuth.getInstance()
    private lateinit var db: DatabaseReference
    
    /*
    ini filenya yg terlibat ad 5
    TransaksiDatabase.kt, TransaksiSelesaiFragment.kt, TransaksiDalamProsesFragment.kt, TransaksiData.kt, RecyclerViewTransaksiAdapter.kt
    
    alurnya:
    TransaksiData.kt dipake di semua
    TransaksiSelesaiFragment.kt & TransaksiDalamProsesFragment.kt -> TransaksiDatabase.kt
    TransaksiSelesaiFragment.kt & TransaksiDalamProsesFragment.kt <- TransaksiDatabase.kt
    TransaksiSelesaiFragment.kt & TransaksiDalamProsesFragment.kt -> RecyclerViewTransaksiAdapter.kt
    
    db = FirebaseDatabase.getInstance().reference
    itu buat bisa make firebase realtime nya
    untuk akses ke setiap folder di database realtime
    pake child() yg di dalam kurung diisi sesuai dengan nama folder ampe ke key nya (user: "ReservU")
    
    nah klo mau ambil data (key: value), .getValue buat ngambil data, .getKey buat ambil keynya.
    kalo mau create, pake .setValue(), update, .update(), delete, remove()
    oh ya, utk ambil referee foldernya bs pake .get()
    
    contoh:
    db.child("user").getValue() (di firebase berarti langsung dr //https:... ke user: "ReservU",
    trus ngambil value dari user itu (valuenya berarti "ReservU")
    
    kalau mau ngambil data dgn jumlah banyak, kita pake array aj, nah itu butuh data class.
    buat contoh bs buka TransaksiData.kt
     */
    
    fun createTransaksi(image: String, title: String, date: String, time: String, status: String) {
        db = FirebaseDatabase.getInstance().reference
        val transaksiRef = db.child("transaksi").child(auth.currentUser?.uid.toString()).push()
        transaksiRef.child("title").setValue(title.trim())
        transaksiRef.child("date").setValue(date.trim())
        transaksiRef.child("time").setValue(time.trim())
        transaksiRef.child("status").setValue(status.trim())
        transaksiRef.child("image").setValue(image.trim())
    }
    
    fun getTransaksiData(
        userId: String,
        state: Array<String>,
        resp: (ArrayList<TransaksiData>) -> Unit,
    ) {
        db = FirebaseDatabase.getInstance().reference
        val transaksiRef = db.child("transaksi").child(userId)
        transaksiRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val transaksiDataList = ArrayList<TransaksiData>()
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val status: String =
                            dataSnapshot.child("status").getValue(String::class.java).toString()
                        if (status in state) {
                            val title: String =
                                dataSnapshot.child("title").getValue(String::class.java).toString()
                            val date: String =
                                dataSnapshot.child("date").getValue(String::class.java).toString()
                            val time: String =
                                dataSnapshot.child("time").getValue(String::class.java).toString()
                            val image: String =
                                dataSnapshot.child("image").getValue(String::class.java).toString()
                            
                            val transaksiData =
                                TransaksiData(title, date, time, status, image)
                            transaksiDataList.add(transaksiData)
                        }
                    }
                }
                resp(transaksiDataList)
            }
            
            override fun onCancelled(error: DatabaseError) {
                println("Error: ${error.message}")
            }
        })
    }
}

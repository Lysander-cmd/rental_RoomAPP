package www.smktelkommalang.sch.id.rental_room.Database

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiData

class TransaksiDatabase {
    private var auth = FirebaseAuth.getInstance()
    private var db: DatabaseReference = FirebaseDatabase.getInstance().reference
    
    fun createTransaksi(image: Int, title: String, date: String, time: String, status: String) {
        val transaksiRef = db.child("transaksi").child(auth.currentUser?.uid.toString())
        transaksiRef.child("title").setValue(title)
        transaksiRef.child("date").setValue(date)
        transaksiRef.child("time").setValue(time)
        transaksiRef.child("status").setValue(status)
        transaksiRef.child("image").setValue(image)
    }
    
    fun getTransaksiData(userId: String, transaksiDataList : ArrayList<TransaksiData>) {
        val transaksiRef = db.child("transaksi")
        transaksiRef.child(userId).addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (dataSnapshot in snapshot.children) {
                        val title = dataSnapshot.getValue(TransaksiData::class.java)
                        if (title != null && !transaksiDataList.contains(title)) {
                            transaksiDataList.add(title)
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    
    //fun getTransaksiData(userId: String, transaksiDataList: MutableLiveData<ArrayList<TransaksiData>>) {
//    val transaksiDbRef = db.child("transaksi").child(userId)
//    transaksiDbRef.addValueEventListener(object : ValueEventListener {
//        override fun onDataChange(snapshot: DataSnapshot) {
//            val tempList = ArrayList<TransaksiData>()
//            snapshot.children.forEach { dataSnapshot ->
//                dataSnapshot.getValue(TransaksiData::class.java)?.let { tempList.add(it) }
//            }
//            transaksiDataList.postValue(tempList)
//        }
//
//        override fun onCancelled(error: DatabaseError) {
//            // Implement error handling here
//            }
//        })
//}
}

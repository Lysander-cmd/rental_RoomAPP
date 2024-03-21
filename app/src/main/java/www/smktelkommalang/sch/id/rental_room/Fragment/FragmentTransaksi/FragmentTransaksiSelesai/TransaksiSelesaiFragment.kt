package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaksi.FragmentTransaksiSelesai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import www.smktelkommalang.sch.id.rental_room.Adapter.RecyclerViewTransaksiAdapter
import www.smktelkommalang.sch.id.rental_room.Database.TransaksiDatabase
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiData
import www.smktelkommalang.sch.id.rental_room.R

class TransaksiSelesaiFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var transaksiDataList: ArrayList<TransaksiData>
    private lateinit var recyclerViewTransaksiAdapter: RecyclerViewTransaksiAdapter
    private lateinit var transaksiDatabase: TransaksiDatabase
    private lateinit var auth: FirebaseAuth
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_transaksi_dalam_proses, container, false)
        recyclerView = rootView.findViewById(R.id.transaksiDalamProses)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        
        auth = FirebaseAuth.getInstance()
        transaksiDatabase = TransaksiDatabase()
        transaksiDataList = ArrayList()
        
        recyclerViewTransaksiAdapter = RecyclerViewTransaksiAdapter(transaksiDataList)
        recyclerView.adapter = recyclerViewTransaksiAdapter
        
        readDataFromFirebase()
        return rootView
    }
    
    private fun readDataFromFirebase() {
        val userId = auth.currentUser?.uid.toString()
        /*
        clear ini sama aj kek hapus semua variabel yg kesimpen di array, tujuannya biar ga ke duplicate
        
        addAll ini awalnya dataList yg udh ad isinya trus mo dikasih ke transaksiDataList
        biar bs ditampilin datanya, nah trus jgn lupa .notifyDataSetChanged() ke adapternya
        
        klo arrayOf ini aku pengen ngecek 2 status sekaligus di firebase, jdnya pake array
         */
        transaksiDatabase.getTransaksiData(userId, arrayOf( "Disetujui", "Tidak Disetujui" )) { dataList ->
            transaksiDataList.clear()
            transaksiDataList.addAll(dataList)
            recyclerViewTransaksiAdapter.notifyDataSetChanged()
        }
    }
}
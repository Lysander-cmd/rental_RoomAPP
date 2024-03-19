package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaksi.FragmentTransaksiProses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import www.smktelkommalang.sch.id.rental_room.Adapter.RecyclerViewTransaksiAdapter
import www.smktelkommalang.sch.id.rental_room.Database.TransaksiDatabase
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiData
import www.smktelkommalang.sch.id.rental_room.R

class TransaksiDalamProsesFragment() : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var transaksiDataList: ArrayList<TransaksiData>
    private lateinit var recyclerViewTransaksiAdapter: RecyclerViewTransaksiAdapter
    private lateinit var transaksiDatabase: TransaksiDatabase
    lateinit var auth: FirebaseAuth
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_transaksi_dalam_proses, container, false)
        recyclerView = rootView.findViewById(R.id.transaksiDalamProses)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        
        transaksiDatabase = TransaksiDatabase()
        auth = FirebaseAuth.getInstance()
        transaksiDatabase.getTransaksiData(userId = auth.currentUser?.uid.toString(), transaksiDataList)
        
        recyclerViewTransaksiAdapter = RecyclerViewTransaksiAdapter(transaksiDataList)
        recyclerView.adapter = recyclerViewTransaksiAdapter
        
        return rootView
        
    }
    
}

//class TransaksiDalamProsesFragment : Fragment() {
//    private lateinit var recyclerView: RecyclerView
//    private var transaksiDataList = MutableLiveData<ArrayList<TransaksiData>>()
//    private lateinit var recyclerViewTransaksiAdapter: RecyclerViewTransaksiAdapter
//    private lateinit var transaksiDatabase: TransaksiDatabase
//    private lateinit var auth: FirebaseAuth
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val rootView = inflater.inflate(R.layout.fragment_transaksi_dalam_proses, container, false)
//
//        auth = FirebaseAuth.getInstance()
//        transaksiDatabase = TransaksiDatabase()
//
//        recyclerView = rootView.findViewById(R.id.transaksiDalamProses)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(context)
//
//        transaksiDataList.observe(viewLifecycleOwner) { dataList ->
//            recyclerViewTransaksiAdapter = RecyclerViewTransaksiAdapter(dataList)
//            recyclerView.adapter = recyclerViewTransaksiAdapter
//        }
//
//        auth.currentUser?.uid?.let {
//            transaksiDatabase.getTransaksiData(it, transaksiDataList)
//        }
//
//        return rootView
//        }
//}
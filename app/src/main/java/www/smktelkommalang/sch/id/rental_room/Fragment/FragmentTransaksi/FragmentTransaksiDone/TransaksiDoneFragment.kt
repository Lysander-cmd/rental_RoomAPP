package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaksi.FragmentTransaksiDone

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import www.smktelkommalang.sch.id.rental_room.Adapter.RecyclerViewTransaksiAdminDone
import www.smktelkommalang.sch.id.rental_room.Database.AdminDatabase
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiData
import www.smktelkommalang.sch.id.rental_room.R

class TransaksiDoneFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var transaksiDataList: ArrayList<TransaksiData>
    private lateinit var recyclerViewTransaksiAdminAdapter: RecyclerViewTransaksiAdminDone
    private lateinit var adminDB: AdminDatabase
    private val handler = Handler(Looper.getMainLooper())
    private val refreshInterval = 5000L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_transaksi_admindone, container, false)
        recyclerView = rootView.findViewById(R.id.transaksiAdminDone)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        transaksiDataList = ArrayList()
        
        adminDB = AdminDatabase()
        fetchData()

        recyclerViewTransaksiAdminAdapter = RecyclerViewTransaksiAdminDone(transaksiDataList)
        recyclerView.adapter = recyclerViewTransaksiAdminAdapter
        return rootView
    }
    
    override fun onDestroyView() {
        handler.removeCallbacksAndMessages(null) // Remove any pending callbacks
        super.onDestroyView()
    }
    
    private fun fetchData() {
        adminDB.getTransaksiData(arrayOf("Disetujui", "Tidak Disetujui")) { transaksiList ->
            transaksiDataList.clear()
            transaksiDataList.addAll(transaksiList)
            recyclerViewTransaksiAdminAdapter.notifyDataSetChanged()
            handler.postDelayed({ fetchData() }, refreshInterval)
        }
    }
}
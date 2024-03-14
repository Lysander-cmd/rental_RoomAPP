package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.recyclerview.widget.LinearLayoutManager
import www.smktelkommalang.sch.id.rental_room.Adapter.RecyclerViewTransaksiAdapter
import www.smktelkommalang.sch.id.rental_room.Model.TrackTransaksi.TransaksiActivity
import www.smktelkommalang.sch.id.rental_room.R

class RuanganFragment : Fragment() {
    
    private lateinit var gridView : GridView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        
        val rootView = inflater.inflate(R.layout.fragment_ruangan, container, false)
        gridView = rootView.findViewById(R.id.month_grid)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        transaksiActivityList = ArrayList()
//
//        transaksiActivityList.add(TransaksiActivity(R.drawable.dummy_ruangan_3, "Peminjaman Gedung Kreativitas Mahasiswa 4.1", "20 Oktober 2000", "16.00 - 20.00", "Disetujui"))
//        transaksiActivityList.add(TransaksiActivity(R.drawable.dummy_ruangan_2, "Peminjaman Gedung Auditorium G2", "20 Oktober 2000", "16.00 - 20.00", "Tidak Disetujui"))
//
//        recyclerViewTransaksiAdapter = RecyclerViewTransaksiAdapter(transaksiActivityList)
//
//        recyclerView.adapter = recyclerViewTransaksiAdapter
        return rootView
    }
}
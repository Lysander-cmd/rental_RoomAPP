package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaksi.Admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import www.smktelkommalang.sch.id.rental_room.Adapter.RecyclerViewTransaksiAdmin
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiActivity
import www.smktelkommalang.sch.id.rental_room.R


class TransaksiAccFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var transaksiActivityList: ArrayList<TransaksiActivity>
    private lateinit var recyclerViewTransaksiAdminAdapter: RecyclerViewTransaksiAdmin

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_transaksi_dalam_proses, container, false)
        recyclerView = rootView.findViewById(R.id.transaksiDalamProses)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        transaksiActivityList = ArrayList()

        transaksiActivityList.add(
            TransaksiActivity(
                R.drawable.dummy_ruangan_1,
                "Peminjaman Gedung Kreativitas Mahasiswa 4.2",
                "20 Oktober 2000",
                "16.00 - 20.00",
                "Dalam Proses"
            )
        )
        transaksiActivityList.add(
            TransaksiActivity(
                R.drawable.dummy_ruangan_2,
                "Peminjaman Gedung Auditorium G2",
                "20 Oktober 2000",
                "16.00 - 20.00",
                "Dalam Proses"
            )
        )
        transaksiActivityList.add(
            TransaksiActivity(
                R.drawable.dummy_ruangan_3,
                "Peminjaman Gedung Kreativitas Mahasiswa 4.1",
                "20 Oktober 2000",
                "16.00 - 20.00",
                "Dalam Proses"
            )
        )

        recyclerViewTransaksiAdminAdapter = RecyclerViewTransaksiAdmin(transaksiActivityList)
        recyclerView.adapter = recyclerViewTransaksiAdminAdapter
        return rootView
    }

}
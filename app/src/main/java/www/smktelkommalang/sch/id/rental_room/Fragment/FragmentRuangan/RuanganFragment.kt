package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import www.smktelkommalang.sch.id.rental_room.Adapter.RecyclerViewRuanganAdapter
import www.smktelkommalang.sch.id.rental_room.Model.Ruangan.RuanganData
import www.smktelkommalang.sch.id.rental_room.R

class RuanganFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var RuanganActivityList: ArrayList<RuanganData>
    private lateinit var recyclerViewRuanganAdapter: RecyclerViewRuanganAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_ruangan, container, false)
        recyclerView = rootView.findViewById(R.id.ruangan)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        RuanganActivityList = ArrayList()

        RuanganActivityList.add(RuanganData(R.drawable.dummy_ruangan_1,"20 Orang","10x10","Peminjaman Gedung Auditorium G2","20 Oktober 2000","16.00 - 20.00","Dalam Proses" ))
//        RuanganActivityList.add(RuanganData(R.drawable.dummy_ruangan_1,"20 Orang","10x10","Peminjaman Gedung Auditorium G2","20 Oktober 2000","16.00 - 20.00","Dalam Proses" )
//        RuanganActivityList.add(TransaksiActivity(R.drawable.dummy_ruangan_3, "Peminjaman Gedung Kreativitas Mahasiswa 4.1", "20 Oktober 2000", "16.00 - 20.00", "Dalam Proses"))
//        recyclerViewRuanganAdapter = RecyclerViewRuanganAdapter(RuanganActivityList)

        recyclerView.adapter = recyclerViewRuanganAdapter
        return rootView
    }
}
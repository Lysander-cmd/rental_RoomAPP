package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaction.FragmentTransaksiSelesai

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import www.smktelkommalang.sch.id.rental_room.R

class TransaksiSelesaiFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaksi_selesai, container, false)
    }
}
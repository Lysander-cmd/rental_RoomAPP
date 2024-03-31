package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentTransaksi.FragmentTransaksiDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import www.smktelkommalang.sch.id.rental_room.R

class TransaksiDetailFragment : Fragment() {
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        var rootView = inflater.inflate(R.layout.fragment_transaksi_detail, container, false)
        return rootView
    }
}
package www.smktelkommalang.sch.id.rental_room.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiData
import www.smktelkommalang.sch.id.rental_room.R

class RecyclerViewTransaksiAdmin(private val transaksiAdminActivityList: ArrayList<TransaksiData>) :
    RecyclerView.Adapter<RecyclerViewTransaksiAdmin.TransaksiViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiViewHolder {
        /*
        xml yang menjadi holder / container yg dibuat
         */
        
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_transaksi_card_admin, parent, false)
        return TransaksiViewHolder(view)
    }
    
    class TransaksiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        
        val imageView: ImageView = itemView.findViewById(R.id.gambarRuangan)
        val titleTextView: TextView = itemView.findViewById(R.id.namaRuangan)
        val dateTextView: TextView = itemView.findViewById(R.id.tanggalPesanRuangan)
        val timeTextView: TextView = itemView.findViewById(R.id.jamPesanRuangan)
    }
    
    override fun onBindViewHolder(holder: TransaksiViewHolder, position: Int) {
        val transaksi = transaksiAdminActivityList[position]
        holder.imageView.setImageResource(transaksi.image)
        holder.titleTextView.text = transaksi.title
        holder.dateTextView.text = transaksi.date
        holder.timeTextView.text = transaksi.time
    }
    
    override fun getItemCount(): Int {
        return transaksiAdminActivityList.size
    }
}
package www.smktelkommalang.sch.id.rental_room.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import www.smktelkommalang.sch.id.rental_room.Database.AdminDatabase
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiData
import www.smktelkommalang.sch.id.rental_room.R

class RecyclerViewTransaksiAdmin(private val transaksiAdminActivityList: ArrayList<TransaksiData>) :
    RecyclerView.Adapter<RecyclerViewTransaksiAdmin.TransaksiViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_transaksi_card_admin, parent, false)
        return TransaksiViewHolder(view)
    }
    
    class TransaksiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.gambarRuangan)
        val titleTextView: TextView = itemView.findViewById(R.id.namaRuangan)
        val dateTextView: TextView = itemView.findViewById(R.id.tanggalPesanRuangan)
        val timeTextView: TextView = itemView.findViewById(R.id.jamPesanRuangan)
        val btnAccept: Button = itemView.findViewById(R.id.buttonAccept)
        val btnDecline: Button = itemView.findViewById(R.id.buttonDecline)
    }
    
    override fun onBindViewHolder(holder: TransaksiViewHolder, position: Int) {
        val transaksi = transaksiAdminActivityList[position]
        
        Glide.with(holder.imageView.context).load(transaksi.image).error(R.drawable.logo)
            .into(holder.imageView)
        holder.titleTextView.text = transaksi.title
        holder.dateTextView.text = transaksi.date
        holder.timeTextView.text = transaksi.time
        
        val adminDB: AdminDatabase  = AdminDatabase()
        
        holder.btnAccept.setOnClickListener{
            adminDB.updateStatus("Disetujui", index = position + 1)
        }
        
        holder.btnDecline.setOnClickListener{
            adminDB.updateStatus("Tidak Disetujui", index = position + 1)
        }
    }
    
    override fun getItemCount(): Int {
        return transaksiAdminActivityList.size
    }
}
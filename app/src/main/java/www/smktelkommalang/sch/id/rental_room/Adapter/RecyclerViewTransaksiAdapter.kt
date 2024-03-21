package www.smktelkommalang.sch.id.rental_room.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import www.smktelkommalang.sch.id.rental_room.Model.Transaksi.TransaksiData
import www.smktelkommalang.sch.id.rental_room.R

class RecyclerViewTransaksiAdapter(private val transaksiDataList: ArrayList<TransaksiData>) : RecyclerView.Adapter<RecyclerViewTransaksiAdapter.RuanganViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuanganViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_transaksi_card, parent, false)
        return RuanganViewHolder(view)
    }
    
    class RuanganViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.gambarRuangan)
        val titleTextView: TextView = itemView.findViewById(R.id.namaRuangan)
        val dateTextView: TextView = itemView.findViewById(R.id.tanggalPesanRuangan)
        val timeTextView: TextView = itemView.findViewById(R.id.jamPesanRuangan)
        val statusTextView: TextView = itemView.findViewById(R.id.statusPesanan)
        val textColor: TextView = itemView.findViewById(R.id.statusPesanan)
        val cardColor: MaterialCardView = itemView.findViewById(R.id.cardViewStatusPesanan)
        val transaksiCard: CardView = itemView.findViewById(R.id.transaksi_card)
    }
    
    override fun getItemCount(): Int {
        return transaksiDataList.size
    }
    
    override fun onBindViewHolder(holder: RuanganViewHolder, position: Int) {
        val transaksi = transaksiDataList[position]
        
        holder.dateTextView.text = transaksi.date
        Glide.with(holder.itemView.context.applicationContext)
            .load(transaksi.image)
            .placeholder(R.drawable.logo)
            .into(holder.imageView)
        holder.statusTextView.text = transaksi.status
        holder.timeTextView.text = transaksi.time
        holder.titleTextView.text = transaksi.title
        
        when (holder.statusTextView.text) {
            "Disetujui" -> {
                holder.cardColor.strokeColor = Color.parseColor("#0ECC00")
                holder.textColor.setTextColor(Color.parseColor("#0ECC00"))
            }
            "Tidak Disetujui" -> {
                holder.cardColor.strokeColor = Color.parseColor("#CC000E")
                holder.textColor.setTextColor(Color.parseColor("#CC000E"))
            }
            else -> {
                holder.cardColor.strokeColor = Color.parseColor("#3643FF")
                holder.textColor.setTextColor(Color.parseColor("#3643FF"))
            }
        }
        
        val cont = holder.transaksiCard.context
        holder.transaksiCard.setOnClickListener{
            Toast.makeText(cont, "The item ${transaksi.title} is clicked", Toast.LENGTH_SHORT).show()
        }
    }
}

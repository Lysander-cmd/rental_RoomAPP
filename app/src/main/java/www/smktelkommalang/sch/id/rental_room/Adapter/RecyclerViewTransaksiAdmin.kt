package www.smktelkommalang.sch.id.rental_room.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import www.smktelkommalang.sch.id.rental_room.Model.TrackTransaksi.TransaksiActivity
import www.smktelkommalang.sch.id.rental_room.R
import www.smktelkommalang.sch.id.rental_room.UI.Admin.ActivityAdminScreen

class RecyclerViewTransaksiAdmin (private val transaksiAdminActivityList: ArrayList<TransaksiActivity>) :
    RecyclerView.Adapter<RecyclerViewTransaksiAdmin.RuanganViewHolder>() {
    class RuanganViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.gambarRuangan)
        val titleTextView: TextView = itemView.findViewById(R.id.namaRuangan)
        val dateTextView: TextView = itemView.findViewById(R.id.tanggalPesanRuangan)
        val timeTextView: TextView = itemView.findViewById(R.id.jamPesanRuangan)
        val statusTextView: TextView = itemView.findViewById(R.id.statusPesanan)
        val cardColor: CardView = itemView.findViewById(R.id.cardViewStatusPesanan)
        val textColor: TextView = itemView.findViewById(R.id.statusPesanan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuanganViewHolder {
        /*
        xml yang menjadi holder / container yg dibuat
         */

        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_transaksi_card_admin, parent, false)

        return RuanganViewHolder(view)

    }

    override fun getItemCount(): Int {
        return transaksiAdminActivityList.size
    }

    override fun onBindViewHolder(holder: RuanganViewHolder, position: Int) {
        /*
        bisa buka file TransaksiActivity utk lebih detailnya
         */
        val transaksi = transaksiAdminActivityList[position]
        holder.imageView.setImageResource(transaksi.image)
        holder.titleTextView.text = transaksi.title
        holder.dateTextView.text = transaksi.date
        holder.timeTextView.text = transaksi.time
        holder.statusTextView.text = transaksi.status
        if (holder.statusTextView.text == "Disetujui") {
            holder.cardColor.setCardBackgroundColor(Color.parseColor("#0ECC00"));
            holder.textColor.setTextColor(Color.parseColor("#0ECC00"));
        } else if (holder.statusTextView.text == "Tidak Disetujui") {
            holder.cardColor.setCardBackgroundColor(Color.parseColor("#CC000E"));
            holder.textColor.setTextColor(Color.parseColor("#CC000E"));
        } else {
            holder.cardColor.setCardBackgroundColor(Color.parseColor("#3643FF"));
            holder.textColor.setTextColor(Color.parseColor("#3643FF"));
        }
    }
}
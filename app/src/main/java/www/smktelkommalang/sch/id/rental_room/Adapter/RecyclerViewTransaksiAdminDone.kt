package www.smktelkommalang.sch.id.rental_room.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import www.smktelkommalang.sch.id.rental_room.Model.TrackTransaksi.TransaksiActivity
import www.smktelkommalang.sch.id.rental_room.R

class RecyclerViewTransaksiAdminDone (private val transaksiAdminDoneActivityList: ArrayList<TransaksiActivity>) :
    RecyclerView.Adapter<RecyclerViewTransaksiAdminDone.TransaksiViewHolder>() {
        class TransaksiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val imageView: ImageView = itemView.findViewById(R.id.gambarRuangan)
            val titleTextView: TextView = itemView.findViewById(R.id.namaRuangan)
            val dateTextView: TextView = itemView.findViewById(R.id.tanggalPesanRuangan)
            val timeTextView: TextView = itemView.findViewById(R.id.jamPesanRuangan)
            val btnAccept: Button = itemView.findViewById(R.id.buttonAccept)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiViewHolder {
            /*
            xml yang menjadi holder / container yg dibuat
             */

            val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_transaksi_card_admin_done, parent, false)
            return TransaksiViewHolder(view)
        }

        override fun getItemCount(): Int {
            return transaksiAdminDoneActivityList.size
        }

        override fun onBindViewHolder(holder: TransaksiViewHolder, position: Int) {

            val transaksi = transaksiAdminDoneActivityList[position]
            holder.imageView.setImageResource(transaksi.image)
            holder.titleTextView.text = transaksi.title
            holder.dateTextView.text = transaksi.date
            holder.timeTextView.text = transaksi.time
            holder.btnAccept.text = transaksi.status

        }
}
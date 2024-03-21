package www.smktelkommalang.sch.id.rental_room.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import www.smktelkommalang.sch.id.rental_room.Model.Ruangan.RuanganData



class RecyclerViewRuanganAdapter(
    private val getActivity: Context,
    private val RuanganList: List<RuanganData>) :
RecyclerView.Adapter<RecyclerViewRuanganAdapter.RuanganViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuanganViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(www.smktelkommalang.sch.id.rental_room.R.layout.fragment_ruangan, parent, false)
        return RuanganViewHolder(view)
    }

    override fun onBindViewHolder(holder: RuanganViewHolder, position: Int) {
        val ruangan = RuanganList[position]
        holder.imageView.setImageResource(ruangan.image)
        holder.titleTextView.text = ruangan.title
        holder.kapasitasTextView.text = ruangan.kapasitas
        holder.ukuranTextView.text = ruangan.ukuran

//        holder.cardView.setOnClickListener {
//            Toast.makeText(getActivity, RuanganList[position].title, Toast.LENGTH_LONG).show()
//        }
    }

    override fun getItemCount(): Int {
        return RuanganList.size
    }

    class RuanganViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(www.smktelkommalang.sch.id.rental_room.R.id.gambarRuangan)
        val titleTextView: TextView = itemView.findViewById(www.smktelkommalang.sch.id.rental_room.R.id.titleRuangan)
        val kapasitasTextView: TextView = itemView.findViewById(www.smktelkommalang.sch.id.rental_room.R.id.kapasitasRuangan)
        val ukuranTextView: TextView = itemView.findViewById(www.smktelkommalang.sch.id.rental_room.R.id.ukuranRuangan)
    }
}
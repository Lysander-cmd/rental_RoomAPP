package www.smktelkommalang.sch.id.rental_room.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import www.smktelkommalang.sch.id.rental_room.Model.Ruangan.RuanganData
import www.smktelkommalang.sch.id.rental_room.R


class RecyclerViewRuanganAdapter(
    private val RuanganList: List<RuanganData>,
    private var onItemClickListener: ((RuanganData) -> Unit)? = null
) :

    RecyclerView.Adapter<RecyclerViewRuanganAdapter.RuanganViewHolder>() {

    fun setOnItemClickListener(listener: (RuanganData) -> Unit) {
        onItemClickListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RuanganViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_ruangan_card, parent, false)
        return RuanganViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: RuanganViewHolder, position: Int) {
        val ruangan = RuanganList[position]
        Glide.with(holder.itemView.context.applicationContext)
            .load(ruangan.image)
            .placeholder(R.drawable.logo)
            .into(holder.imageView)
        holder.titleTextView.text = ruangan.title
        holder.kapasitasTextView.text = ruangan.kapasitas
        holder.ukuranTextView.text = ruangan.ukuran

        holder.cardView.setOnClickListener {
            onItemClickListener?.invoke(ruangan)
        }
    }
    
    override fun getItemCount(): Int {
        return RuanganList.size
    }
    
    class RuanganViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView =
            itemView.findViewById(R.id.gambarRuangan)
        val titleTextView: TextView =
            itemView.findViewById(R.id.titleRuangan)
        val kapasitasTextView: TextView =
            itemView.findViewById(R.id.kapasitasRuangan)
        val ukuranTextView: TextView =
            itemView.findViewById(R.id.ukuranRuangan)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }
}
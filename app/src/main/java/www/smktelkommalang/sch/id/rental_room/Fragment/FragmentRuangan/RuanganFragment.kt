package www.smktelkommalang.sch.id.rental_room.Fragment.FragmentRuangan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import www.smktelkommalang.sch.id.rental_room.Adapter.RecyclerViewRuanganAdapter
import www.smktelkommalang.sch.id.rental_room.Model.Ruangan.RuanganData
import www.smktelkommalang.sch.id.rental_room.R

class RuanganFragment : Fragment() {

    private var recyclerView: RecyclerView? = null

    // Use MutableLiveData for efficient lifecycle-aware data handling
    private val movieList = MutableLiveData<List<RuanganData>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the fragment's layout
        return inflater.inflate(R.layout.fragment_ruangan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.ruangan) as RecyclerView
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView!!.layoutManager = layoutManager

        // Observe movieList and set adapter when data is available
        movieList.observe(viewLifecycleOwner) { movies ->
            val adapter = RecyclerViewRuanganAdapter(requireContext(), movies)
            recyclerView!!.adapter = adapter
        }

        prepareMovieListData()
    }

    private fun prepareMovieListData() {
        // Use a background thread for data preparation
        viewLifecycleOwner.lifecycleScope.launch {
            val movieData = listOf(
                RuanganData(R.drawable.dummy_ruangan_1, "20 Orang", "10x10", "Peminjaman Gedung Auditorium G2",   "Dalam Proses"),
                RuanganData(R.drawable.dummy_ruangan_2, "20 Orang", "10x10", "Peminjaman Gedung Auditorium G2",   "Dalam Proses"),
                RuanganData(R.drawable.dummy_ruangan_3, "20 Orang", "10x10", "Peminjaman Gedung Auditorium G2",   "Dalam Proses")

            )
            movieList.postValue(movieData)
        }
    }
}
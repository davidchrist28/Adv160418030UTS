package id.ac.ubaya.informatika.adv160418030uts.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.adv160418030uts.Model.Barang
import id.ac.ubaya.informatika.adv160418030uts.R
import kotlinx.android.synthetic.main.list_barang.view.*

class AdapterBarang(val listBarang: ArrayList<Barang>):RecyclerView.Adapter<AdapterBarang.BarangViewHolder>() {
    class BarangViewHolder(var view: View):RecyclerView.ViewHolder(view)

    fun updateListBarang(listBaru:List<Barang>) {
        listBarang.clear()
        listBarang.addAll(listBaru)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarangViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val vw = inflater.inflate(R.layout.list_barang, parent, false)
        return BarangViewHolder(vw)
    }

    override fun onBindViewHolder(holder: BarangViewHolder, position: Int) {
        with(holder.view) {
            txtNamaBarang.setText(listBarang[position].namaBarang)
            txtHargaBarang.setText(listBarang[position].hargaBarang)
            txtStok.setText(listBarang[position].jumlah.toString())
            cardViewItem.setOnClickListener {
                val aksi = FragmentListBarangDirections.actionFragmentDetilBarang(listBarang[position].id)
                Navigation.findNavController(it).navigate(aksi)
            }
        }
    }

    override fun getItemCount(): Int {
        return listBarang.size
    }
}
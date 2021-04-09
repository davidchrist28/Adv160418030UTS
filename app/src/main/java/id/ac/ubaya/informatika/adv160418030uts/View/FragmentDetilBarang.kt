package id.ac.ubaya.informatika.adv160418030uts.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.adv160418030uts.Model.Barang
import id.ac.ubaya.informatika.adv160418030uts.R
import id.ac.ubaya.informatika.adv160418030uts.Viewmodel.DetilBarangViewModel
import id.ac.ubaya.informatika.adv160418030uts.Viewmodel.ListBarangViewModel
import kotlinx.android.synthetic.main.fragment_detil_barang.*

class FragmentDetilBarang : Fragment() {
    private lateinit var viewModel: DetilBarangViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detil_barang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var id = FragmentDetilBarangArgs.fromBundle(requireArguments()).id
        var nama = FragmentDetilBarangArgs.fromBundle(requireArguments()).nama
        var harga = FragmentDetilBarangArgs.fromBundle(requireArguments()).harga
        var stok = FragmentDetilBarangArgs.fromBundle(requireArguments()).jumlah
        var desk = FragmentDetilBarangArgs.fromBundle(requireArguments()).deskripsi

        viewModel = ViewModelProvider(this).get(DetilBarangViewModel::class.java)
        viewModel.Muat(id, nama, harga, stok, desk)
        viewModel.barangDLD.observe(viewLifecycleOwner, {
            txtNamaBrg.setText(it.namaBarang)
            txtHargaBrg.setText(it.hargaBarang.toString())
            txtJumlah.setText(it.jumlah.toString())
            txtDeskripsi.setText(it.keterangan)
        })
    }
}
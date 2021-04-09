package id.ac.ubaya.informatika.adv160418030uts.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.adv160418030uts.Model.Barang

class DetilBarangViewModel: ViewModel() {
    val barangDLD = MutableLiveData<Barang>()

    fun Muat(id: String, nama: String, harga: Int, jumlah: Int, deskripsi: String) {
        val BarangDt = Barang(id, nama, harga, jumlah, deskripsi)
        barangDLD.value = BarangDt
    }
}
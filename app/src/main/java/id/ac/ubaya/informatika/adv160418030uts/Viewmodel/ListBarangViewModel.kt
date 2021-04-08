package id.ac.ubaya.informatika.adv160418030uts.Viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.adv160418030uts.Model.Barang

class ListBarangViewModel: ViewModel() {
    val barangLD = MutableLiveData<List<Barang>>()
    val errorLD = MutableLiveData<Boolean>()

    fun reload() {
        var barang1 = Barang("1", "Kontaktor 3TF39-11 0XP0", "170000", 20, "Kontaktor 3TF39 1 NO 1 NC 220 VAC")
        var barang2 = Barang("2", "Kontaktor 3TX42-22 0YP0", "220000", 15, "Kontaktor 3TX42 2 NO 2 NC 160 VAC")
        var barang3 = Barang("3", "MCB 2 Pole 6 kA C25 5SL6225-7CC", "150000", 35, "MCB 2 Pole 25 A breaking capacity 6 kA")
        var barang4 = Barang("4", "MCB 3 Pole 10 kA C8 5SJ43", "185000", 20, "MCB 3 Pole 8 A breaking capacity 10 kA")
        var barang5 = Barang("5", "Soft Starter PST175-200", "43000000", 5, "Soft Starter untuk mesin-mesin pabrik dan industri. Input 220 VAC, output 100-150 kW")
        val listBarang:ArrayList<Barang> = arrayListOf<Barang>(barang1, barang2, barang3, barang4, barang5)
        barangLD.value = listBarang
        errorLD.value = false
    }
}
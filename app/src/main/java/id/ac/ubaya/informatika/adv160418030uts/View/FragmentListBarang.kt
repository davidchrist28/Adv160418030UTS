package id.ac.ubaya.informatika.adv160418030uts.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.adv160418030uts.R
import id.ac.ubaya.informatika.adv160418030uts.Viewmodel.ListBarangViewModel

class FragmentListBarang : Fragment() {
    private lateinit var viewModel: ListBarangViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_barang, container, false)
    }
}
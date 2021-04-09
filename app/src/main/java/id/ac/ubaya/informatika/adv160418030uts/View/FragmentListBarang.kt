package id.ac.ubaya.informatika.adv160418030uts.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.adv160418030uts.R
import id.ac.ubaya.informatika.adv160418030uts.Viewmodel.ListBarangViewModel
import kotlinx.android.synthetic.main.fragment_list_barang.*

class FragmentListBarang : Fragment() {
    private lateinit var viewModel: ListBarangViewModel
    private val adapterBarang = AdapterBarang(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_barang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListBarangViewModel::class.java)
        viewModel.reload()

        recycleView.layoutManager = LinearLayoutManager(context)
        recycleView.adapter = adapterBarang
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.barangLD.observe(viewLifecycleOwner, Observer {
            adapterBarang.updateListBarang(it)
        })

        viewModel.errorLD.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                txtError.visibility = View.VISIBLE
                recycleView.visibility = View.GONE
            } else {
                txtError.visibility = View.GONE
                recycleView.visibility = View.VISIBLE
            }
        })
    }
}
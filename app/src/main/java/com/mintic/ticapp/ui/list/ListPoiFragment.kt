package com.mintic.ticapp.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.mintic.ticapp.Modelos.Pois
import com.mintic.ticapp.Modelos.PoisItem
import com.mintic.ticapp.R
import com.mintic.ticapp.databinding.FragmentListPoiBinding
import com.mintic.ticapp.ui.detail.Poi_info_completa

class ListPoiFragment : Fragment() {

    private lateinit var listPoiBinding: FragmentListPoiBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var listPoisAdapter: ListPoisAdapter
    private var listPois: ArrayList<PoisItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listPoiBinding = FragmentListPoiBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        return listPoiBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listViewModel.loadPoisFromServer()

        listViewModel.onPoisLoaded.observe(viewLifecycleOwner, { result ->
            onPoisLoadedSubscribe(result)
        })

        listPoisAdapter = ListPoisAdapter(listPois, onItemClicked= {onPoiClicked(it)})
        listPoiBinding.poiRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = listPoisAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPoisLoadedSubscribe(result: ArrayList<PoisItem>){
        result?.let { listPois ->
            listPoisAdapter.appendItems(listPois)
        }
    }

    private fun onPoiClicked(pois: PoisItem){

        val transaction = parentFragmentManager.beginTransaction()
        val newFragment = Poi_info_completa(pois)
        transaction.replace(R.id.main_container, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

    private fun loadMockPoisFromJson(): ArrayList<PoisItem> {
        val poisString: String = context?.assets?.open("Lugares_Cancun.json")?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        val data = gson.fromJson(poisString, Pois::class.java)
        return data
    }
}
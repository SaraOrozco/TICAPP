package com.mintic.ticapp

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson


class Poi_fragment() : Fragment() {
    private lateinit  var listpois: ArrayList<PoisItem>
    private lateinit var poisAdapter: PoisAdapter
    private lateinit var poisRecyclerView: RecyclerView
    private lateinit var frag: FragmentManager

    constructor(parcel: Parcel) : this() {

    }

    constructor(listpois: ArrayList<PoisItem>, contexto: FragmentManager) : this() {
        this.listpois = listpois
        this.frag = contexto
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.activity_list_poiactivity, container, false)

        poisRecyclerView = view.findViewById(R.id.poi_recyclerview)
        // listpois = createMockPois()
        poisAdapter = PoisAdapter(listpois, frag)
        //poisRecyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        poisRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poisAdapter
            setHasFixedSize(false)
        }
        //poisRecyclerView.adapter = poisAdapter
        return view
    }

}
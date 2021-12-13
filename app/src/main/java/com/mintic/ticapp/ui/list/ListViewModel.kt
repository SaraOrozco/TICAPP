package com.mintic.ticapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mintic.ticapp.Modelos.PoisItem
import com.mintic.ticapp.data.PoisRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListViewModel: ViewModel() {

    private var poisLoad: MutableLiveData<ArrayList<PoisItem>>  = MutableLiveData()
    val onPoisLoaded: LiveData<ArrayList<PoisItem>>  = poisLoad;

    private val repository = PoisRepository()

    fun loadPoisFromServer() {
        GlobalScope.launch(Dispatchers.IO) {
            poisLoad.postValue(repository.getPois())
        }
    }
}
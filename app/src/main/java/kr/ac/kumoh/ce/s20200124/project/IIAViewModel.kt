package kr.ac.kumoh.ce.s20200124.project

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IIAViewModel:ViewModel() {
    private val iiaApi : IIAApi
    private val _iiaList=MutableLiveData<List<IIA>>()
    val iiaList: LiveData<List<IIA>>
        get()=_iiaList
    init {
        val retrofit=Retrofit.Builder()
            .baseUrl(IIAApiConfig.SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        iiaApi=retrofit.create(IIAApi::class.java)
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch {
            try {
                val response=iiaApi.getIIA()
                _iiaList.value=response
            } catch (e:Exception){
                Log.e("fetchData()", e.toString())
            }
        }
    }
}
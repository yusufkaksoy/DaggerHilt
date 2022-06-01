package com.example.jsonapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jsonapp.retrofit.RetrofitRepository
import com.example.jsonapp.data.Post
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RetrofitRepository) : ViewModel() {

    var dataList: MutableLiveData<List<Post>>

    init {
        dataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Post>> {
        return dataList
    }

    fun loadData() {
        repository.getPosts(dataList)
    }

}
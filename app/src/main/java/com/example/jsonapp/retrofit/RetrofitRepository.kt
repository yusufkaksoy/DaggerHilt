package com.example.jsonapp.retrofit

import androidx.lifecycle.MutableLiveData
import com.example.jsonapp.data.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private val retrofitServiceInstance: RetrofitServiceInstance) {
    //
    fun getPosts(dataList: MutableLiveData<List<Post>>){
        val call : Call<List<Post>> = retrofitServiceInstance.getPosts()
        call.enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if(response.isSuccessful){
                    dataList.postValue(response.body())
                }
                else
                {dataList.postValue(null)}

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                dataList.postValue(null)
            }

        })


    }
}
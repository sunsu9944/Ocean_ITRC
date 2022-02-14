package com.twogudak.ocean_itoc_kotiln.httpData.RespositoryManager

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.twogudak.ocean_itoc_kotiln.httpData.DTOManager.GalleryDTO
import com.twogudak.ocean_itoc_kotiln.httpData.loadRetrofit
import retrofit2.Call

class GalleryRespository {

    val message = MutableLiveData<String>()

    fun getgallery(token: String?): MutableLiveData<GalleryDTO> {

        val result = MutableLiveData<GalleryDTO>()
        val call = loadRetrofit.OPEN_SERVICE

        call.getgallery(token).enqueue(object : retrofit2.Callback<GalleryDTO> {
            override fun onResponse(call: Call<GalleryDTO>, response: retrofit2.Response<GalleryDTO>){
                result.value = response.body()
            }

            override fun onFailure(call: Call<GalleryDTO>, t: Throwable){
                Log.e("test",t.message.toString())
                message.value = "서버와의 통신이 원활하지 않습니다."
            }
        })

        return result
    }
}
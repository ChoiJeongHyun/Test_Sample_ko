package kr.co.example.codingtest_kakaocme.api


import io.reactivex.rxjava3.core.Single
import kr.co.example.codingtest_kakaocme.vo.Body
import retrofit2.Call
import retrofit2.http.*

interface ImageAPI {


    @GET("/v2/search/image")
    fun getImgRx(@Query("query") query: String , @Query("sort") sort:String = "accuracy" , @Query("page") page:Int , @Query("size") size:Int ): Single<Body>

    @GET("/v2/search/image")
    fun getImg(@Query("query") query: String , @Query("sort") sort:String = "accuracy" , @Query("page") page:Int , @Query("size") size:Int ): Call<Body>


    //base Url ex) https://api.coinonetransfer.com
    @POST("/transfer")
    fun transfer(@retrofit2.http.Body transferEx1: TransferEx1) : Call<Body>


}
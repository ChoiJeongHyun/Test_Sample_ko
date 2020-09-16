package kr.co.example.codingtest_kakaocme.repository


import kr.co.example.codingtest_kakaocme.api.ApiManager
import kr.co.example.codingtest_kakaocme.api.ImageAPI
import kr.co.example.codingtest_kakaocme.api.TransferEx1
import kr.co.example.codingtest_kakaocme.api.TransferEx2
import kr.co.example.codingtest_kakaocme.vo.SearchCondition
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppRepository @Inject constructor(private val apiManager: ApiManager) {

    fun apiGetImg(s: SearchCondition) = apiManager.getRetrofitService(ImageAPI::class.java).getImg(query = s.query, sort = s.sort , page = s.page , size = s.size)

    fun apiTransfer(t: TransferEx1) = apiManager.getRetrofitService(ImageAPI::class.java).transfer(t)
}
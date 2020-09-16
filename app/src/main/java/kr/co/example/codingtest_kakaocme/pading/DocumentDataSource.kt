package kr.co.example.codingtest_kakaocme.pading

import androidx.paging.PositionalDataSource
import kr.co.example.codingtest_kakaocme.repository.AppRepository
import kr.co.example.codingtest_kakaocme.utils.PLog
import kr.co.example.codingtest_kakaocme.vo.Body
import kr.co.example.codingtest_kakaocme.vo.Document
import kr.co.example.codingtest_kakaocme.vo.SearchCondition
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DocumentDataSource(private val appRepository: AppRepository, private val s: SearchCondition) :
    PositionalDataSource<Document>() {

    private var pageCount: Int = 1

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Document>) {
        s.page = 1
        appRepository.apiGetImg(s).enqueue(object : Callback<Body> {
            override fun onFailure(call: Call<Body>, t: Throwable) {

            }

            override fun onResponse(call: Call<Body>, response: Response<Body>) {
                if (response.body() == null) return
                if (response.body()!!.documents.isEmpty()) return
                callback.onResult(filterList(response.body()!!.documents), 0)

            }




        })

    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Document>) {
        s.page = ++s.page

        appRepository.apiGetImg(s).enqueue(object : Callback<Body> {
            override fun onFailure(call: Call<Body>, t: Throwable) {

            }

            override fun onResponse(call: Call<Body>, response: Response<Body>) {
                if (response.body() == null) return
                if (response.body()!!.documents.isEmpty()) return

                callback.onResult(filterList(response.body()!!.documents))

            }

        })

    }

    override fun invalidate() {
        super.invalidate()
        pageCount = 1
    }

    private fun filterList(list: List<Document>): List<Document> {

        return   when (s.filter) {
            "all" -> list
            "blog" -> list.filter { it.collection == "blog" || it.collection == "cafe" }
            "news" -> list.filter { it.collection == "news" }
            "etc" -> list.filter { it.collection == "etc" }
            else -> list
        }
    }


}
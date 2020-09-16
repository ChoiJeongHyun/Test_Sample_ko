package kr.co.example.codingtest_kakaocme.pading

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import kr.co.example.codingtest_kakaocme.repository.AppRepository
import kr.co.example.codingtest_kakaocme.utils.PLog
import kr.co.example.codingtest_kakaocme.vo.Document
import kr.co.example.codingtest_kakaocme.vo.SearchCondition

class DocumentDataSourceFactory(private val appRepository: AppRepository , var s : SearchCondition ) : DataSource.Factory<Int, Document>() {

    lateinit var documentDataSource: DocumentDataSource

    override fun create(): DataSource<Int, Document> {
        documentDataSource = DocumentDataSource(appRepository , s)
        return documentDataSource
    }

    fun refresh(){
        documentDataSource.invalidate()
    }


}
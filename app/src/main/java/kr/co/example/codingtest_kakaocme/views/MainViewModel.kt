package kr.co.example.codingtest_kakaocme.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.*
import kr.co.example.codingtest_kakaocme.api.*
import kr.co.example.codingtest_kakaocme.base.BaseViewModel
import kr.co.example.codingtest_kakaocme.pading.DocumentDataSourceFactory
import kr.co.example.codingtest_kakaocme.repository.AppRepository
import kr.co.example.codingtest_kakaocme.vo.Body
import kr.co.example.codingtest_kakaocme.vo.Document
import kr.co.example.codingtest_kakaocme.vo.SearchCondition
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback

class MainViewModel @Inject constructor(private val appRepository: AppRepository) :
    BaseViewModel() {

    private val _searchInput: MutableLiveData<String> = MutableLiveData("")
    val searchInput
        get() = _searchInput

    private val _sortType: MutableLiveData<String> = MutableLiveData("정확도순")
    val sortType: MutableLiveData<String>
        get() = _sortType

    private val _searchType: MutableLiveData<String> = MutableLiveData("전체")
    val searchType
        get() = _searchType

    private val _hideKeyBoardFlag: MutableLiveData<Boolean> = MutableLiveData(false)
    val hideKeyBoardFlag
        get() = _hideKeyBoardFlag

    private var docFactory: DocumentDataSourceFactory =
        DocumentDataSourceFactory(appRepository, SearchCondition())
    private val pageBuilder: PagedList.Config = PagedList.Config.Builder()
        .setPageSize(80)
        .setInitialLoadSizeHint(30)
        .setPrefetchDistance(40)
        .setEnablePlaceholders(false)
        .build()

    var imgItems: LiveData<PagedList<Document>> =
        LivePagedListBuilder(docFactory, pageBuilder).build()

    fun typeClick(s: String) {
        when (s) {
            "정확도순", "최신순" -> {
                _sortType.value = s
                if (s == "정확도순") docFactory.s.sort = "accuracy" else docFactory.s.sort = "recency"
            }
            "전체", "블로그/카페", "뉴스", "기타" -> {
                _searchType.value = s
                when (s) {
                    "전체" -> docFactory.s.filter = "all"
                    "블로그/카페" -> docFactory.s.filter = "blog"
                    "뉴스" -> docFactory.s.filter = "news"
                    "기타" -> docFactory.s.filter = "etc"
                }
            }
        }
        search(docFactory.s.query)

    }

    fun search(s: String) {
        docFactory.refresh()
        docFactory.s.query = s
        _hideKeyBoardFlag.value = true

    }





}
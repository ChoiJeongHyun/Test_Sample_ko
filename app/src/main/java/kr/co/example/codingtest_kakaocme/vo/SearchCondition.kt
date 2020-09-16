package kr.co.example.codingtest_kakaocme.vo

data class SearchCondition(
    var query: String = "",
    var sort: String = "accuracy",
    var page: Int = 1,
    var size: Int = 80,
    var filter: String = "all"
)
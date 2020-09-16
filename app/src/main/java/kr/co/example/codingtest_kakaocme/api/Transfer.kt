package kr.co.example.codingtest_kakaocme.api

enum class SendCountry {
    Japan, Thailand, USA, China
}

enum class SendType {
    Bank, CashPickUP
}

data class TransferEx2(
    //공통필드
    var sendToCountry: SendCountry = SendCountry.Japan,
    var sendToType: SendType = SendType.Bank,
    var payeeAmount: Int = 0,
    var payeeName: String = "",
    var country: Any? = null
)

//각 나라별 data class
data class Japan(
    var bankID: String = "",
    var bankBranchID: String = "",
    var payeeAccountNumber: String = ""
)

data class Thailand(
    var bankID: String = "",
    var payeeAccountNumber: String = "",
    var payeePhoneNumber: String = "",
    var payeeAddress: String = ""
)

data class USA(
    var bankID: String = "",
    var payeeAccountNumber: String = "",
    var payeePassportNumber: String = ""
)

data class China(
    var bankID: String = "",
    var payeeAccountNumber: String = "",
    var senderName: String = "",
    var senderCountry: String = ""
)




data class TransferEx1(
    //공통필드
    var sendToCountry: SendCountry = SendCountry.Japan,
    var sendToType: SendType = SendType.Bank,
    var payeeAmount: Int = 0,
    var payeeName: String = "",
    var payeeAccountNumber: String = "",

    //나라별 optional
    var bankID: String = "",
    var bankBranchID: String = "",
    var payeeAddress: String = "",
    var payeePhoneNumber: String = "",
    var payeePassportNumber: String = "",
    var senderName: String = "",
    var senderCountry: String = ""
)



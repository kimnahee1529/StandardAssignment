package com.nhkim.ui1

object ItemManager {
    val aptList = mutableListOf<APT>()

    init {
        aptList.add(APT(R.drawable.room1, "월세 4000/40",  "원룸", "2층, 관리비 10만 깔끔한 신축급"))
        aptList.add(APT(R.drawable.room2, "월세 300/530",  "아파트", "15층, 관리비 25만"))
        aptList.add(APT(R.drawable.room3, "월세 200/115",  "오피스텔", "전입OK, 보안설비 잘되어있는 집입니다."))
        aptList.add(APT(R.drawable.room4, "월세 4000/40",  "원룸", "2층, 관리비 10만 깔끔한 신축급"))
    }
}
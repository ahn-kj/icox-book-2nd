package com.akj.kotlinsample

class MovieKotlin {
    // 주연
    var leadingActors: List<ActorKotlin?>? = null

    // 조연
    var supportingActors: List<ActorKotlin?>? = null

    // 제목
    var title: String? = null

    // 상영연도
    var showingAge: Int = 0

    // 장르 - "공포, 코미디, 멜로, 액션"
    var genre: String? = null

    // 배우 클래스
    class ActorKotlin {
        // 본명
        var realName: String? = null
        // 예명
        var stageName: String? = null
        // 나이
        var age: Int = 0

        // 성별 - 남자 "M", 여자 "W"
        var gender: String? = null

        // 출연작
        var actedMovies: List<Movie?>? = null
    }

    // 배우 캐스팅 후보를 반환하는 함수
    // 전달받은 영화 목록중 제목에 "도시" 문자열이 있는 영화만 조사
    // 주연배우 목록에서 여성 20대, 작품수 5개 이상이면 추천
    // 조연배우 목록에서 남자이고 30대, 출연작품중 공포 장르가 3개 이상인 경우 추천
    fun casting(movies: List<MovieKotlin?>?): MutableList<ActorKotlin> {
        var recommendActors = mutableListOf<ActorKotlin>()
        // 전달받은 movies 가 null 이 아닌 경우 각 원소마다 람다가 실행됨
        movies?.forEach { movie ->
            // 영화의 제목에 "도시" 가 포함된 경우에 실행
            if (movie?.title?.contains("도시") == true) {
                // 주연 배우중 여성, 20대, 작품수 5 이상인 배우이면 추천
                movie.leadingActors?.filter {
                    it?.gender == "W" && it.age >= 20 && it.age < 30 && (it.actedMovies?.size ?: 0) > 5
                }?.forEach { it?.let { recommendActors.add(it) } }

                // 조연 배우중 남성, 30대, 출연작품중 공포 장르 3개 이상
                movie.supportingActors?.filter {
                    it?.gender == "M" && it.age  >= 30 && it.age < 40 && it.actedMovies?.filter { it?.genre == "공포" }?.size ?: 0 > 3
                }?.forEach { it?.let { recommendActors.add(it) } }
            }
        }

        return recommendActors
    }
}
package com.akj.kotlinsample;

import java.util.ArrayList;
import java.util.List;

// 영화 클래스
public class Movie {
    // 주연
    public List<Actor> leadingActors;

    // 조연
    public List<Actor> supportingActors;

    // 제목
    public String title;

    // 상영연도
    public int showingAge;

    // 장르 - "공포, 코미디, 멜로, 액션"
    public String genre;

    // 배우 클래스
    public static class Actor {
        // 본명
        public String realName;
        // 예명
        public String stageName;
        // 나이
        public int age;

        // 성별 - 남자 "M", 여자 "W"
        public String gender;

        // 출연작
        public List<Movie> actedMovies;
    }

    // 배우 캐스팅 후보를 반환하는 함수
    // 전달받은 영화 목록중 제목에 "도시" 문자열이 있는 영화만 조사
    // 주연배우 목록에서 여성 20대, 작품수 5개 이상이면 추천
    // 조연배우 목록에서 남자이고 30대, 출연작품중 공포 장르가 3개 이상인 경우 추천
    public static List<Actor> casting(List<Movie> movies) {
        List<Actor> recommemdActors = new ArrayList<>();

        // 전달받은 movies 널체크
        if(movies != null){
            // 전달 받은 Movie 목록을 순회
            for (Movie movie : movies) {
                // 각 원소 널체크
                if(movie != null){
                    // 영화의 제목이 널인지 체크
                    if(movie.title != null){
                        if (movie.title.contains("도시")) {
                            // 주연배우 리스트가 널인지 체크
                            if(movie.leadingActors != null){
                                // 주연배우 목록에서 여성 20대, 작품수 5개 이상이면 추천
                                for (Actor actor : movie.leadingActors) {
                                    // 각 원소와 성별, 출연작 리스트 널체크
                                    if(actor != null
                                            && actor.gender != null
                                            && actor.actedMovies != null){
                                        if (actor.gender.equals("W")
                                                && actor.actedMovies.size() >= 5
                                                && actor.age >= 20
                                                && actor.age < 30) {
                                            recommemdActors.add(actor);
                                        }
                                    }
                                }
                            }
                            // 조연배우 리스트가 널인지 체크
                            if(movie.supportingActors != null){
                                // 조연배우 목록에서 남자이고 30대, 출연작품중 공포 장르가 3개 이상인 경우 추천
                                for (Actor actor : movie.supportingActors) {
                                    // 각 원소 널체크
                                    if(actor != null){
                                        if (actor.gender.equals("M")
                                                && actor.age >= 30
                                                && actor.age < 40
                                                ) {
                                            // 배우의 출연작 리스트 널체크
                                            if(actor.actedMovies != null){
                                                // 배우의 출연작품을 순회
                                                for (Movie actedMovie : actor.actedMovies) {
                                                    // 출연작의 장르 널체크
                                                    if(actedMovie.genre != null){
                                                        if (actedMovie.genre.equals("공포")) {
                                                            recommemdActors.add(actor);
                                                        }
                                                    }

                                                }
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return recommemdActors;
    }
}

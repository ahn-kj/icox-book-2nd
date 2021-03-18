package com.akj.anonymoussns

class Post {
    /**
     * 글의 ID
     */
    var postId = ""
    /**
     * 글 작성자의 ID
     */
    var writerId = ""
    /**
     * 글의 메세지
     */
    var message = ""
    /**
     * 글이 쓰여진 시간
     */
    var writeTime: Any = Any()
    /**
     * 글의 배경이미지
     */
    var bgUri = ""
    /**
     * 댓글의 개수
     */
    var commentCount = 0
}
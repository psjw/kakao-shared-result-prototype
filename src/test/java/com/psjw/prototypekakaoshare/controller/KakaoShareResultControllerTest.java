package com.psjw.prototypekakaoshare.controller;

import com.psjw.prototypekakaoshare.code.sns.KakaoChatType;
import com.psjw.prototypekakaoshare.common.ApiCommonTest;
import com.psjw.prototypekakaoshare.sns.kakao.dto.GenerateKakaoSharedResultRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class KakaoShareResultControllerTest extends ApiCommonTest {
    public static final String KAKAO_RESULT_SHARED_URL = "/kakao/result/{path}";
    @Test
    @DisplayName("카카오 공유하기 결과 Get방식 요청 성공")
    public void 카카오공유하기_GET방식_성공_테스트(){
        String chatType = KakaoChatType.DirectChat.getChatType();
        String userAgent = "KakaoOpenAPI/1.0";
        ExtractableResponse<Response> response = RestAssured.given()
                .log().all()
                .pathParam("path","shared")
                .queryParams(GenerateKakaoSharedResultRequest.카카오공유하기_쿼리파라미터_생성(chatType))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .headers(GenerateKakaoSharedResultRequest.카카오공유하기_결과_요청헤더_생성(userAgent))
                .body(GenerateKakaoSharedResultRequest
                        .채팅타입에따른_카카오공유하기_결과_요청값_생성(chatType))
                .when()
                .get(KAKAO_RESULT_SHARED_URL)
                .then()
                .log().all()
                .extract();
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
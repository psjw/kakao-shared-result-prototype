package com.psjw.prototypekakaoshare.sns.controller;

import com.psjw.prototypekakaoshare.code.sns.KakaoChatType;
import com.psjw.prototypekakaoshare.common.ApiCommonTest;
import com.psjw.prototypekakaoshare.sns.application.service.dto.GenerateKakaoSharedResultRequest;
import com.psjw.prototypekakaoshare.sns.application.service.dto.KakaoSharedSaveResponseDto;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class KakaoShareControllerTest extends ApiCommonTest {
    public static final String KAKAO_RESULT_SHARED_URL = "/kakao/shared/{path}";


    @Test
    @DisplayName("카카오 공유하기 공유전 데이터 저장요청 성공")
    public void 카카오공유하기_공유전_데이터저장_성공_테스트(){
        String chatType = KakaoChatType.DirectChat.getChatType();
        String userAgent = "KakaoOpenAPI/1.0";
        KakaoSharedSaveResponseDto 카카오공유하기_공유저장_요청값_생성 = GenerateKakaoSharedResultRequest
                .카카오공유하기_공유저장_요청값_생성();
        ExtractableResponse<Response> response = RestAssured.given()
                .log().all()
                .pathParam("path","saved")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(GenerateKakaoSharedResultRequest
                        .카카오공유하기_공유저장_요청값_생성())
                .when()
                .post(KAKAO_RESULT_SHARED_URL)
                .then()
                .log().all()
                .extract();
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        System.out.println( );
        Assertions.assertThat(response.jsonPath().get("depositProductName").toString())
                .contains(카카오공유하기_공유저장_요청값_생성.getDepositProductName());
    }

    @Test
    @DisplayName("카카오 공유하기 결과 Get방식 요청 성공")
    public void 카카오공유하기_GET방식_성공_테스트(){

        카카오공유하기_공유전_데이터저장_성공_테스트();

        String chatType = KakaoChatType.DirectChat.getChatType();
        String userAgent = "KakaoOpenAPI/1.0";
        ExtractableResponse<Response> response = RestAssured.given()
                .log().all()
                .pathParam("path","result")
                .queryParams(GenerateKakaoSharedResultRequest.카카오공유하기_공유결과_쿼리파라미터_생성(chatType))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .headers(GenerateKakaoSharedResultRequest.카카오공유하기_공유결과_요청헤더_생성(userAgent))
                .body(GenerateKakaoSharedResultRequest
                        .공유타입에따른_카카오공유하기_공유결과_요청값_생성(chatType))
                .when()
                .get(KAKAO_RESULT_SHARED_URL)
                .then()
                .log().all()
                .extract();
        Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
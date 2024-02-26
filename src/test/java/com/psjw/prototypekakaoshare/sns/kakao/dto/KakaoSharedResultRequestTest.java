package com.psjw.prototypekakaoshare.sns.kakao.dto;

import com.psjw.prototypekakaoshare.code.sns.KakaoChatType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KakaoSharedResultRequestTest {
    private KakaoSharedResultRequest successRequest;
    private KakaoSharedResultRequest failRequest;
    private String failChatType = "ABCD";
    private String successChatType = KakaoChatType.MemoChat.getChatType();

    @BeforeEach
    void setUp(){
        successRequest = GenerateKakaoSharedResultRequest
                                .채팅타입에따른_카카오공유하기_결과_요청값_생성(successChatType);
        failRequest = GenerateKakaoSharedResultRequest
                                .채팅타입에따른_카카오공유하기_결과_요청값_생성(failChatType);
    }


    @Test
    @DisplayName("카카오가 요창한 값이 올바를 경우 올바른 카카오 채팅 타입이 반환")
    void 카카오공유결과_올바른_요청값(){
        Assertions.assertThat(successRequest.getKakaoChatType().getChatType())
                .isEqualTo(successChatType);
    }

    @Test
    @DisplayName("카카오가 요창한 값이 올바르지 않을 경우 지정되지 않은 타입의 Exception을 반환")
    void 카카오공유결과_올바르지_않은_요청값(){
        Assertions.assertThatThrownBy(() -> failRequest.getKakaoChatType())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정의 되지 않는 채팅 타입 입니다.");
    }

}
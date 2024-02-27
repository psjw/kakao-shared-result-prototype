package com.psjw.prototypekakaoshare.sns.application.service.dto;

import java.util.Map;

public class GenerateKakaoSharedResultRequest {
    private static String HASH_CHAT_ID = "1234";
    private static String DEPOSIT_PRODUCT_NAME = "통장";
    private static String USER_ID = "AAA1234";
    private static String TEMPLATE_ID = "55555";
    private static String ID = "1";

    public static KakaoSharedResultRequestDto 채팅타입에따른_카카오공유하기_결과_요청값_생성(String chatType) {
        return KakaoSharedResultRequestDto.builder()
                .chatType(chatType)
                .hashChatId(HASH_CHAT_ID)
                .depositProductName(DEPOSIT_PRODUCT_NAME)
                .templateId(TEMPLATE_ID)
                .userId(USER_ID)
                .id(ID)
                .build();
    }

    public static Map<String, String> 카카오공유하기_결과_요청헤더_생성(String userAgent) {
        return Map.of(
                "Authorization", "KakaoAK SERVICE_APP_ADMIN_KEY",
                "X-Kakao-Resource-ID", "Rvy1c2dkzBAZ5hGD3rqYbxvr",
                "User-Agent", userAgent
        );
    }

    public static Map<String, String> 카카오공유하기_쿼리파라미터_생성(String chatType) {
        return Map.of(
                "CHAT_TYPE", chatType,
                "HASH_CHAT_ID", HASH_CHAT_ID,
                "TEMPLATE_ID", TEMPLATE_ID,
                "USER_ID", USER_ID,
                "DEPOSIT_PRODUCT_NAME", DEPOSIT_PRODUCT_NAME,
                "ID", ID
        );
    }
}

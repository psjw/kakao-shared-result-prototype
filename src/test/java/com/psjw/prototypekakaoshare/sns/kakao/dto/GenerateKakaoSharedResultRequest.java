package com.psjw.prototypekakaoshare.sns.kakao.dto;

import java.util.Map;

public class GenerateKakaoSharedResultRequest {
    private static String hashChatId = "1234";
    private static String depositProductName = "통장";
    private static String userId = "AAA1234";
    private static String templateId = "55555";

    public static KakaoSharedResultRequest 채팅타입에따른_카카오공유하기_결과_요청값_생성(String chatType) {
        return KakaoSharedResultRequest.builder()
                .chatType(chatType)
                .hashChatId(hashChatId)
                .depositProductName(depositProductName)
                .templateId(templateId)
                .userId(userId)
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
                "HASH_CHAT_ID", hashChatId,
                "TEMPLATE_ID", templateId,
                "USER_ID", userId,
                "DEPOSIT_PRODUCT_NAME", depositProductName
        );
    }
}

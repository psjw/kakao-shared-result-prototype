package com.psjw.prototypekakaoshare.sns.application.service.dto;


import com.psjw.prototypekakaoshare.code.sns.KakaoChatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class KakaoSharedResultRequest {
    private String id;
    private String chatType;
    private String hashChatId;
    private String templateId;
    private String depositProductName;
    private String userId;

    public KakaoChatType getKakaoChatType(){
        return Arrays.stream(KakaoChatType.values()).filter(x -> x.getChatType().equals(chatType)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("정의 되지 않는 채팅 타입 입니다."));
    }

}

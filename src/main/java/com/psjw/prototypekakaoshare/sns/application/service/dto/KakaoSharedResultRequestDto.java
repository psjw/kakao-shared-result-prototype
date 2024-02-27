package com.psjw.prototypekakaoshare.sns.application.service.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.psjw.prototypekakaoshare.code.sns.ChannelType;
import com.psjw.prototypekakaoshare.code.sns.KakaoChatType;
import com.psjw.prototypekakaoshare.sns.domain.SnsSharedHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class KakaoSharedResultRequestDto {
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

    public SnsSharedHistory toEntity(){
        return SnsSharedHistory.createSnsShareResult(ChannelType.KAKAO.getCode(), this.userId, this.templateId, this.depositProductName);
    }

}

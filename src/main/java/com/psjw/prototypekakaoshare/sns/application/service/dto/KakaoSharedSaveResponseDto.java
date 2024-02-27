package com.psjw.prototypekakaoshare.sns.application.service.dto;


import com.psjw.prototypekakaoshare.sns.domain.SnsSharedHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class KakaoSharedSaveResponseDto {
    private Long id;
    private String channelType;
    private String hashChatId;
    private String templateId;
    private String depositProductName;
    private String userId;

    public KakaoSharedSaveResponseDto toDto(SnsSharedHistory snsSharedResult){
        return KakaoSharedSaveResponseDto.builder()
                .id(snsSharedResult.getId())
                .channelType(snsSharedResult.getChannelTypeCode())
                .hashChatId(snsSharedResult.getSharedId())
                .templateId(snsSharedResult.getTemplateId())
                .depositProductName(snsSharedResult.getDepositProductName())
                .userId(snsSharedResult.getUserId())
                .build();
    }

}

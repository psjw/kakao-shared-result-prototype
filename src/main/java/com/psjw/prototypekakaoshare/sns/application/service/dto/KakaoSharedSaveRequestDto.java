package com.psjw.prototypekakaoshare.sns.application.service.dto;


import com.psjw.prototypekakaoshare.code.sns.ChannelType;
import com.psjw.prototypekakaoshare.sns.domain.SnsSharedHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class KakaoSharedSaveRequestDto {
    private String templateId;
    private String depositProductName;
    private String userId;

    public SnsSharedHistory toEntity(){
        return SnsSharedHistory.createSnsShareResult(ChannelType.KAKAO.getCode(), this.userId, this.templateId, this.depositProductName);
    }

}

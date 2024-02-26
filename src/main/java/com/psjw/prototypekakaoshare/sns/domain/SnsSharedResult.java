package com.psjw.prototypekakaoshare.sns.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Table(name = "SNS_SHARED_RESULT")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SnsSharedResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sharedId;
    private String channelTypeCode;
    private String userId;
    private String templateId;
    private String depositProductName;


    private SnsSharedResult(String sharedId, String channelTypeCode, String userId, String templateId, String depositProductName) {
        Assert.hasText(sharedId, "공유 아이디가 올바르지 않습니다.");
        Assert.hasText(channelTypeCode,"채널 타입 코드가 올바르지 않습니다.");
        Assert.hasText(templateId,"템플릿 아이디가 올바르지 않습니다.");
        Assert.hasText(depositProductName,"상품명이 올바르지 않습니다.");
        this.sharedId = sharedId;
        this.channelTypeCode = channelTypeCode;
        this.userId = userId;
        this.templateId = templateId;
        this.depositProductName = depositProductName;
    }

    public static SnsSharedResult createSnsShareResult(String sharedId, String channelTypeCode, String userId, String templateId, String depositProductName) {
        return new SnsSharedResult(sharedId, channelTypeCode, userId, templateId, depositProductName);
    }
}

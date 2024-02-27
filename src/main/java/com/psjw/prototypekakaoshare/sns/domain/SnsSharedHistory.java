package com.psjw.prototypekakaoshare.sns.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SNS_SHARED_RESULT")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SnsSharedHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sharedId;
    private String channelTypeCode;
    private String chatTypeCode;
    private String userId;
    private String templateId;
    private String depositProductName;

    private String successYn;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime successDate;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime updateDate;

    private SnsSharedHistory(String channelTypeCode, String userId, String templateId, String depositProductName) {
        Assert.hasText(channelTypeCode,"채널 타입 코드가 올바르지 않습니다.");
        Assert.hasText(templateId,"템플릿 아이디가 올바르지 않습니다.");
        Assert.hasText(depositProductName,"상품명이 올바르지 않습니다.");
        this.channelTypeCode = channelTypeCode;
        this.userId = userId;
        this.templateId = templateId;
        this.depositProductName = depositProductName;
    }

    public static SnsSharedHistory createSnsShareResult(String channelTypeCode, String userId, String templateId, String depositProductName) {
        return new SnsSharedHistory( channelTypeCode, userId, templateId, depositProductName);
    }

    public void updateSuccessSnsShareResult(final String chatTypeCode, final String sharedId){
        Assert.hasText(channelTypeCode,"채널 타입 코드가 올바르지 않습니다.");
        this.chatTypeCode = chatTypeCode;
        this.sharedId = sharedId;
        this.successYn = "Y";
        this.successDate = LocalDateTime.now();
    }
}

package com.psjw.prototypekakaoshare.sns.application.service;

import com.psjw.prototypekakaoshare.sns.application.port.SnsSharedResultPort;
import com.psjw.prototypekakaoshare.sns.application.service.dto.KakaoSharedResultRequest;
import com.psjw.prototypekakaoshare.sns.domain.SnsSharedResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KakaoSharedResultService {
    private final SnsSharedResultPort snsSharedResultPort;

    public void update(final KakaoSharedResultRequest request) {
        snsSharedResultPort.getSnsSharedResult(Long.parseLong(request.getId()));
        SnsSharedResult snsShareResult = SnsSharedResult.createSnsShareResult(request.getHashChatId(), request.getKakaoChatType().getChatTypeCode(), request.getUserId(), request.getTemplateId(), request.getDepositProductName());
        snsSharedResultPort.update(snsShareResult);

    }
}

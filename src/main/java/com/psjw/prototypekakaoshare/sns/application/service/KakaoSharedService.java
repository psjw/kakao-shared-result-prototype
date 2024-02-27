package com.psjw.prototypekakaoshare.sns.application.service;

import com.psjw.prototypekakaoshare.sns.application.port.SnsSharedPort;
import com.psjw.prototypekakaoshare.sns.application.service.dto.KakaoSharedResultRequestDto;
import com.psjw.prototypekakaoshare.sns.application.service.dto.KakaoSharedSaveRequestDto;
import com.psjw.prototypekakaoshare.sns.application.service.dto.KakaoSharedSaveResponseDto;
import com.psjw.prototypekakaoshare.sns.domain.SnsSharedHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class KakaoSharedService {
    private final SnsSharedPort snsSharedPort;

    @Transactional
    public void update(final String id, final KakaoSharedResultRequestDto request) {
        final SnsSharedHistory snsShareResult = snsSharedPort.getSnsSharedResult(Long.parseLong(id));
        snsShareResult.updateSuccessSnsShareResult(request.getKakaoChatType().getChatTypeCode(), request.getHashChatId());
        snsSharedPort.save(snsShareResult);
    }

    @Transactional
    public KakaoSharedSaveResponseDto save(final KakaoSharedSaveRequestDto request) {

        SnsSharedHistory savedSnsSharedInfo = request.toEntity();
        SnsSharedHistory savedKakaoSharedInfo = snsSharedPort.save(savedSnsSharedInfo);
        return KakaoSharedSaveResponseDto.builder().build().toDto(savedKakaoSharedInfo);
    }
}

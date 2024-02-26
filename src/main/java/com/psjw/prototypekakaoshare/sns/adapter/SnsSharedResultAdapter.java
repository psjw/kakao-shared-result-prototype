package com.psjw.prototypekakaoshare.sns.adapter;

import com.psjw.prototypekakaoshare.sns.application.port.SnsSharedResultPort;
import com.psjw.prototypekakaoshare.sns.domain.SnsSharedResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Component
public class SnsSharedResultAdapter implements SnsSharedResultPort {
    private final SnsSharedResultRepository snsSharedResultRepository;
    @Override
    public void save(final SnsSharedResult snsSharedResult) {
        snsSharedResultRepository.save(snsSharedResult);
    }

    @Override
    public SnsSharedResult getSnsSharedResult(final Long id)  {
        return snsSharedResultRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("상품이 존재하지 않습니다."));
    }

    @Override
    public SnsSharedResult update(SnsSharedResult snsSharedResult) {
        return null;
    }
}

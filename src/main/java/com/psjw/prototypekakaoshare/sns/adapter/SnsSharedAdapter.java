package com.psjw.prototypekakaoshare.sns.adapter;

import com.psjw.prototypekakaoshare.sns.application.port.SnsSharedPort;
import com.psjw.prototypekakaoshare.sns.domain.SnsSharedHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Component
public class SnsSharedAdapter implements SnsSharedPort {
    private final SnsSharedResultRepository snsSharedResultRepository;
    @Override
    public SnsSharedHistory save(final SnsSharedHistory snsSharedResult) {
        return snsSharedResultRepository.save(snsSharedResult);
    }

    @Override
    public SnsSharedHistory getSnsSharedResult(final Long id)  {
        return snsSharedResultRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("상품이 존재하지 않습니다."));
    }

}

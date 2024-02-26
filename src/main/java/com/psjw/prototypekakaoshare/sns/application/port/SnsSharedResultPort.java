package com.psjw.prototypekakaoshare.sns.application.port;

import com.psjw.prototypekakaoshare.sns.domain.SnsSharedResult;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.Optional;

public interface SnsSharedResultPort {

    void save(final SnsSharedResult snsSharedResult);

    SnsSharedResult getSnsSharedResult(final Long id) ;

    SnsSharedResult update(final SnsSharedResult snsSharedResult);
}

package com.psjw.prototypekakaoshare.sns.application.port;

import com.psjw.prototypekakaoshare.sns.domain.SnsSharedHistory;

public interface SnsSharedPort {

    SnsSharedHistory save(final SnsSharedHistory snsSharedResult);

    SnsSharedHistory getSnsSharedResult(final Long id) ;

}

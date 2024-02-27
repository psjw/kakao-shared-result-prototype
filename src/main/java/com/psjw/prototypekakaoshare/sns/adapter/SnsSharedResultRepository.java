package com.psjw.prototypekakaoshare.sns.adapter;

import com.psjw.prototypekakaoshare.sns.domain.SnsSharedHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnsSharedResultRepository extends JpaRepository<SnsSharedHistory, Long> {
}

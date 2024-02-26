package com.psjw.prototypekakaoshare.controller;

import com.psjw.prototypekakaoshare.code.sns.ChannelType;
import com.psjw.prototypekakaoshare.finder.SnsSharedResultFinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 카카오 공유하기 Callback 결과 수신
 */

@RestController
@RequestMapping("/kakao/result")
@Slf4j
@RequiredArgsConstructor
public class KakaoSharedResultController {
    private final SnsSharedResultFinder snsSharedResultFinder;
    @GetMapping("/shared")
    public ResponseEntity<?> requestShare(HttpServletRequest request, @RequestParam Map<String, String> requestMap) {
        log.info("resultMap : {}",requestMap);
        snsSharedResultFinder.saveSharedResult(ChannelType.KAKAO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

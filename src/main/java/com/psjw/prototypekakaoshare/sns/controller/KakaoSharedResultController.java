package com.psjw.prototypekakaoshare.sns.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.psjw.prototypekakaoshare.sns.application.service.KakaoSharedResultService;
import com.psjw.prototypekakaoshare.sns.application.service.dto.KakaoSharedResultRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.transaction.NotSupportedException;
import java.util.Map;

/**
 * 카카오 공유하기 Callback 결과 수신
 */

@RestController
@RequestMapping("/kakao/result")
@Slf4j
@RequiredArgsConstructor
public class KakaoSharedResultController {
    private final KakaoSharedResultService kakaoSharedResultService;
    private final ObjectMapper objectMapper;
    @GetMapping("/shared")
    public ResponseEntity<?> requestShare(@RequestHeader(value = "Authorization")  String authorization,
                                          @RequestHeader(value = "X-Kakao-Resource-ID")  String resourceId,
                                          @RequestHeader(value = "User-Agent")  String userAgent,
                                          @RequestParam Map<String, String> requestMap) throws JsonProcessingException, NotSupportedException {
        log.info("resultMap : {}",requestMap);
        validRequestHeader(authorization, resourceId, userAgent);
        KakaoSharedResultRequest kakaoSharedResultRequest = (KakaoSharedResultRequest)getMaptoObject(requestMap, KakaoSharedResultRequest.class);
        kakaoSharedResultService.update(kakaoSharedResultRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private void validRequestHeader(String authorization, String resourceId, String userAgent) {
        Assert.hasText(authorization,"Authorization 값이 올바르지 않습니다.");
        Assert.hasText(resourceId,"X-Kakao-Resource-ID 값이 올바르지 않습니다.");
        Assert.hasText(userAgent,"User-Agent 값이 올바르지 않습니다.");
    }

    private Object getMaptoObject(Map<String, String> map, Class<?> clazz) throws JsonProcessingException {
        return objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(objectMapper.writeValueAsString(map), clazz);

    }
}

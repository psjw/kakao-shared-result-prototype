package com.psjw.prototypekakaoshare.sns.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.google.common.base.CaseFormat;
import com.psjw.prototypekakaoshare.sns.application.service.KakaoSharedService;
import com.psjw.prototypekakaoshare.sns.application.service.dto.KakaoSharedResultRequestDto;
import com.psjw.prototypekakaoshare.sns.application.service.dto.KakaoSharedSaveRequestDto;
import com.psjw.prototypekakaoshare.sns.application.service.dto.KakaoSharedSaveResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 카카오 공유하기 Callback 결과 수신
 */

@RestController
@RequestMapping("/kakao/shared")
@Slf4j
@RequiredArgsConstructor
public class KakaoSharedController {
    private final KakaoSharedService kakaoSharedService;
    private final ObjectMapper objectMapper;
    @GetMapping("/result")
    public ResponseEntity<?> requestShare(@RequestHeader(value = "Authorization")  String authorization,
                                          @RequestHeader(value = "X-Kakao-Resource-ID")  String resourceId,
                                          @RequestHeader(value = "User-Agent")  String userAgent,
                                          @RequestParam Map<String, String> requestMap) throws JsonProcessingException {
        log.info("resultMap : {}",requestMap);
        validRequestHeader(authorization, resourceId, userAgent);
        Map<String, String> requestCamelMap = changeKeyUpperSnakeToLowerCamelCaseMap(requestMap);
        KakaoSharedResultRequestDto kakaoSharedResultRequest = (KakaoSharedResultRequestDto)getMaptoObject(requestCamelMap, KakaoSharedResultRequestDto.class);
        kakaoSharedService.update(kakaoSharedResultRequest.getId(), kakaoSharedResultRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @PostMapping("/saved")
    @ResponseStatus(HttpStatus.CREATED)
    public KakaoSharedSaveResponseDto requestShare(@RequestBody KakaoSharedSaveRequestDto request){
        return kakaoSharedService.save(request);
    }

    private Map<String, String> changeKeyUpperSnakeToLowerCamelCaseMap(final Map<String, String> requestMap) {
        Map<String, String> requestCamelMap = new HashMap<>();
        requestMap.entrySet().stream()
                .forEach(x -> requestCamelMap.put(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, x.getKey()), requestMap.get(x.getKey())));
        return requestCamelMap;
    }

    private void validRequestHeader(String authorization, String resourceId, String userAgent) {
        Assert.hasText(authorization,"Authorization 값이 올바르지 않습니다.");
        Assert.hasText(resourceId,"X-Kakao-Resource-ID 값이 올바르지 않습니다.");
        Assert.hasText(userAgent,"User-Agent 값이 올바르지 않습니다.");
    }

    private Object getMaptoObject(Map<String, String> map, Class<?> clazz) throws JsonProcessingException {
        return objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE)
                .readValue(objectMapper.writeValueAsString(map), clazz);

    }


}

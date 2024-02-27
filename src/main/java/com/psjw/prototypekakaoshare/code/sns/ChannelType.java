package com.psjw.prototypekakaoshare.code.sns;

import lombok.Getter;

@Getter
public enum ChannelType {
    KAKAO("KKO1");

    private String code;

    ChannelType(String code) {
        this.code = code;
    }
}

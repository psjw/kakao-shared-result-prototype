package com.psjw.prototypekakaoshare.code.sns;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum KakaoChatType {
    MemoChat("MemoChat","001", "나와의 채팅방"),
    DirectChat("DirectChat","002","다른 사용자와의 1:1 채팅방"),
    MultiChat("MultiChat","003","다른 사용자들과의 그룹 채팅방"),
    OpenDirectChat("OpenDirectChat","004","1:1 오픈채팅방"),
    OpenMultiChat("OpenMultiChat","005","오픈채팅방");
    private String chatType;
    private String chatTypeCode;
    private String chatTypeName;

}

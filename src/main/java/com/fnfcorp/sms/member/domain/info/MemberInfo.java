package com.fnfcorp.sms.member.domain.info;

import com.fnfcorp.sms.member.domain.entity.Member;
import lombok.Builder;
import lombok.Getter;

/**
 * @Author : yun
 * @Summary :
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/28          yun       최초 생성
 * </pre>
 */
@Getter
@Builder
public class MemberInfo {
    private Long id;
    private String userId;
    private String userName;
    private String uuid;

    public static MemberInfo of(Member member){
        return MemberInfo.builder()
                .id(member.getId())
                .userId(member.getUserId())
                .userName(member.getUserName())
                .uuid(member.getUuid())
                .build();
    }

}

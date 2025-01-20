package com.fnfcorp.sms.member.domain.query;

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
@Builder(builderClassName = "Builder")
public class GetMemberQuery {
    private Long id;
    private String uuid;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .uuid(uuid)
                .build();
    }
}

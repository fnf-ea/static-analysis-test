package com.fnfcorp.sms.member.domain;

import com.fnfcorp.sms.member.domain.entity.Member;

/**
 * @Author : yun
 * @Summary : MemberReader
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/28          yun       최초 생성
 * </pre>
 */
public interface MemberReader {
    Member selectOneMember(Member member);
}

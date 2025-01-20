package com.fnfcorp.sms.member.domain;

import com.fnfcorp.sms.member.domain.entity.MemberMileage;

/**
 * @Author : yun
 * @Summary : MemberStore
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/28          yun       최초 생성
 * </pre>
 */
public interface MemberStore {
    MemberMileage updateMemberMileage(MemberMileage memberMileage);
}

package com.fnfcorp.sms.member.infra;

import com.fnfcorp.sms.member.domain.MemberStore;
import com.fnfcorp.sms.member.domain.entity.MemberMileage;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

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
@Component("MemberStoreImpl")
@RequiredArgsConstructor
public class MemberStoreImpl implements MemberStore {
    private final String MAPPER_NAMESPACE = "sms.member.MemberMapper";
    private final SqlSessionTemplate sqlSessionTemplate;
    @Override
    public MemberMileage updateMemberMileage(MemberMileage memberMileage) {
        sqlSessionTemplate.update(MAPPER_NAMESPACE + ".updateMemberMileage", memberMileage);
        return memberMileage;
    }
}

package com.fnfcorp.sms.member.infra;

import com.fnfcorp.sms.member.domain.MemberReader;
import com.fnfcorp.sms.member.domain.entity.Member;
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
@Component("MemberReaderImpl")
@RequiredArgsConstructor
public class MemberReaderImpl implements MemberReader {

    private final String MAPPER_NAMESPACE = "sms.member.MemberMapper";
    private final SqlSessionTemplate sqlSessionTemplate;
    @Override
    public Member selectOneMember(Member member) {
        return sqlSessionTemplate.selectOne(MAPPER_NAMESPACE + ".selectOneMember", member);
    }
}

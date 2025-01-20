package com.fnfcorp.sms.rfid.domain.command;

import com.fnfcorp.sms.rfid.domain.entity.Rfid;
import lombok.Builder;
import lombok.Getter;

import jakarta.validation.constraints.NotEmpty;

/**
 * @Author : yun
 * @Summary : Rfid 판매확정상태 변경 요청 객체
 * <pre>
 * ===========================================================================
 * DATE             AUTHOR          NOTE
 * ---------------------------------------------------------------------------
 * 2022/12/27          yun       최초 생성
 * </pre>
 */

@Getter
@Builder(builderClassName = "Builder")
public class ConfirmRfidStatusForSaleCommand {

    @NotEmpty(message = "rfidId는 필수입니다.")
    private Long rfidId;

    public static Builder Builder(Long rfidId) {
        return builder().rfidId(rfidId);
    }
    public Rfid toEntity() {
        return Rfid.builder()
                .id(rfidId)
                .build();
    }
}

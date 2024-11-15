package com.promptoven.paymentservice.common.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Comment("회원 UUID")
    @Column(nullable = false, length = 50)
    private String memberUuid;

    @Comment("결제수단 ID")
    @Column(nullable = false, length = 50)
    private String methodId;

    @Comment("결제수단")
    @Column(nullable = false, length = 50)
    private PaymentWay paymentWay;

    @Comment("결제금액")
    @Column(nullable = false)
    private Integer amount;

    @Comment("승인번호")
    @Column(nullable = false, length = 50)
    private String approveNumber;

    @Comment("결제시간")
    @Column(nullable = false)
    private LocalDateTime approvedAt;

    @Builder
    public Payment(String memberUuid,
                   String methodId,
                   PaymentWay paymentWay,
                   Integer amount,
                   String approveNumber,
                   LocalDateTime approvedAt) {
        this.memberUuid = memberUuid;
        this.methodId = methodId;
        this.paymentWay = paymentWay;
        this.amount = amount;
        this.approveNumber = approveNumber;
        this.approvedAt = approvedAt;
    }
}

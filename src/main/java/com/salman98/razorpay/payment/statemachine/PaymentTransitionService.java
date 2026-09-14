package com.salman98.razorpay.payment.statemachine;

import com.salman98.razorpay.common.enums.PaymentActor;
import com.salman98.razorpay.common.enums.PaymentEvent;
import com.salman98.razorpay.common.enums.PaymentStatus;
import com.salman98.razorpay.merchant.security.MerchantContext;
import com.salman98.razorpay.payment.entity.Payment;
import com.salman98.razorpay.payment.entity.PaymentTransitionLog;
import com.salman98.razorpay.payment.repository.PaymentTransitionLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentTransitionService {

    private final PaymentTransitionLogRepository paymentTransitionLogRepository;
    private final PaymentStateMachine paymentStateMachine;
    private final MerchantContext merchantContext;

    public PaymentStatus apply(Payment payment, PaymentEvent event) {

        PaymentStatus next = paymentStateMachine.transition(payment.getStatus(), event);

        PaymentTransitionLog log = PaymentTransitionLog.builder()
                .payment(payment)
                .fromStatus(payment.getStatus())
                .event(event)
                .toStatus(next)
                .actor(merchantContext.getMerchantId() != null ? PaymentActor.MERCHANT : PaymentActor.SYSTEM)
                .occurredAt(LocalDateTime.now())
                .build();

        payment.setStatus(next);

        paymentTransitionLogRepository.save(log);

        return next;
    }
}

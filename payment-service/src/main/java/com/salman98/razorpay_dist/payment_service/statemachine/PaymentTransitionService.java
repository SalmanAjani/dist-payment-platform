package com.salman98.razorpay_dist.payment_service.statemachine;

import com.salman98.razorpay_dist.common_lib.context.MerchantContext;
import com.salman98.razorpay_dist.common_lib.enums.PaymentActor;
import com.salman98.razorpay_dist.common_lib.enums.PaymentEvent;
import com.salman98.razorpay_dist.common_lib.enums.PaymentStatus;
import com.salman98.razorpay_dist.payment_service.entity.Payment;
import com.salman98.razorpay_dist.payment_service.entity.PaymentTransitionLog;
import com.salman98.razorpay_dist.payment_service.repository.PaymentTransitionLogRepository;
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

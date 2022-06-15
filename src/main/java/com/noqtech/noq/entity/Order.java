package com.noqtech.noq.entity;

import com.noqtech.noq.constant.OrderConstant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "NOQ_ORDER")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "USER_EMAIL_ID")
    private String userEmailId;
    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;
    @Column(name = "STATUS")
    private String status;

    public void setStatus(String status) {
        if (OrderConstant.IN_PROGRESS.equals(status) ||
                OrderConstant.READY_FOR_PICKUP.equals(status) ||
                OrderConstant.COMPLETED.equals(status) ||
                OrderConstant.CANCELLED.equals(status)) {
            this.status = status;
        } else {
            this.status = OrderConstant.UNKNOWN;
        }
    }
}

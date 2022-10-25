package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="merchants")
@Data
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal comissionRate;
    private Integer payoutDelayCount;

/*    @OneToMany(mappedBy = "merchant")
    private List<Payment> paymentList;*/


    public Merchant(String name, String code, BigDecimal transactionFee,
                    BigDecimal comissionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.comissionRate = comissionRate;
        this.payoutDelayCount = payoutDelayCount;


    }
}

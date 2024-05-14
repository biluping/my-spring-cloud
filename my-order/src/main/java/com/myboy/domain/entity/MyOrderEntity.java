package com.myboy.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.myboy.sql.annotation.Column;
import com.myboy.sql.annotation.Table;
import lombok.Data;

@Data
@TableName("my_order")
@Table(name = "my_order", comment = "订单表")
public class MyOrderEntity {

    @Column(isKey = true, comment = "id")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @Column(comment = "订单号")
    private String orderSn;

}

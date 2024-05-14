package com.myboy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.myboy.domain.entity.MyOrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<MyOrderEntity> {

    @Insert("insert into my_order (order_sn) values (#{orderSn} )")
    void add(String orderSn);
}

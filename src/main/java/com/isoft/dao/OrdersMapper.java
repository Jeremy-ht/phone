package com.isoft.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.pojo.vo.OrderVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}

 */
public interface OrdersMapper extends BaseMapper<Orders> {

    Page<OrderVo> selCateList(@Param("page") Page<OrderVo> page,@Param("id") int id);
}

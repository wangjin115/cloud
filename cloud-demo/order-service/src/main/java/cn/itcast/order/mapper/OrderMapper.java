package cn.itcast.order.mapper;

import cn.itcast.order.pojo.Order;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {

    @Select("select * from cloud_order.tb_order where id = #{id}")
    Order findById(Long id);
}

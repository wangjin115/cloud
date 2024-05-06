package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;

//    @Autowired
//    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId){
        // 1.查询订单
       Order order = orderMapper.findById(orderId);

        User user = userClient.findById(order.getUserId());

        order.setUser(user);

        return order;
    }
//不用feign的时候是这么调用的http请求
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        //2.利用RestTemplate发起http请求，查询用户
//        //2.1url路径
//        String url ="http://userservice/user/" + order.getUserId();
//        //2.2发送http请求，实现远程调用
//        //输入url回车返回一个json类型的数据，RestTemplate将json转换成user对象
//        //这里跟在浏览器中输入是一样的效果，如果是get请求就是get，post请求就是post
//        User user=restTemplate.getForObject(url,User.class);
//        //3.封装user对象到order
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}

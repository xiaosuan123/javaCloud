package cn.itcast.order.service;

import cn.itcast.demo.pojo.User;
import cn.itcast.demo.service.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;


    /**
     * 根据订单ID查询订单详情
     * 此方法不仅查询订单信息，还通过调用用户服务获取用户信息，并将其关联到订单中
     *
     * @param orderId 订单ID，用于标识要查询的订单
     * @return 包含用户信息的订单对象如果订单或用户不存在，则返回null
     */
    public Order queryOrderById(Long orderId) {
        // 通过订单ID查询订单基本信息
        Order order = orderMapper.findById(orderId);
        // 构建查询用户信息的URL，根据订单中的用户ID
        //String url = "http://orderservice/user/" + order.getUserId();

        // 调用用户服务，查询用户信息
       // User user = restTemplate.getForObject(url, User.class);
        User user = userClient.findById(order.getUserId());
        order.setUser(user);

        // 返回包含用户信息的订单对象
        return order;
    }

}

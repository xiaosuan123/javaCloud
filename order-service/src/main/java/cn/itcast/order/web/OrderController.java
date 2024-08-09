package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("{orderId}")
// 根据订单ID查询订单信息
// 通过URL路径中的订单ID和可选的truth参数来查询订单
// 参数:
//   orderId: 订单ID，用于标识特定的订单
//   truth: 可选参数，用于某些特定的查询条件或调试目的
// 返回值:
//   查询到的订单对象
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId, @RequestHeader(value = "Truth", required = false) String truth) {
        // 打印truth参数的值，用于日志或调试目的
        System.out.println("truth:" + truth);
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }

}

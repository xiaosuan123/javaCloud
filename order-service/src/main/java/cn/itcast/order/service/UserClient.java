package cn.itcast.order.service;

import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * 使用FeignClient注解定义一个客户端接口，用于调用用户服务（UserService）
 * "userservice"是服务提供者的名字，FeignClient会通过这个名字来调用服务提供者
 */
@FeignClient("userservice")
public interface UserClient {
    /**
     * 定义一个获取用户信息的方法，通过用户的ID来查找用户
     * 该方法通过发送GET请求到服务提供者的/user/{id}路径来实现
     * 使用PathVariable注解将方法参数id映射到URL路径中的{id}
     *
     * @param id 用户的ID，用于查找特定用户
     * @return 返回查找到的用户对象
     */
    @GetMapping("user/{id}")
    User findById(@PathVariable("id") Long id);
}

package cn.itcast.demo.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Order(-1)
@Component
/**
 * 授权过滤器，用于拦截和校验请求的授权信息
 */
public class AuthorizeFilter implements GlobalFilter {

    /**
     * 对经过网关的请求进行过滤
     *
     * @param exchange 代表一次HTTP请求的交换对象，包含了请求和响应的所有信息
     * @param chain 表示一组过滤器的调用链，用于执行过滤器链中的下一个过滤器
     * @return 返回一个Mono<Void>类型，表示异步处理完成的信号
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 获取请求参数
        MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();

        // 获取authorization
        String authorization = params.getFirst("authorization");

        // 检查authorization参数是否为"admin"，是则放行请求
        if (StringUtils.isNotBlank(authorization) && StringUtils.equals("admin", authorization)) {
            return chain.filter(exchange);
        }

        // 若授权信息不满足条件，则设置响应状态码为403 Forbidden，阻止请求继续
        exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
        return exchange.getResponse().setComplete();
    }
}

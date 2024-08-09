package cn.itcast.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Description:
 * @Date: 2023/2/20 11:19
 */
public class OpenFeignLoggerConfiguration {

    @Bean
    public Logger.Level getLoggerLevel() {
        return Logger.Level.BASIC;
    }
}

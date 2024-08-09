package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 方式二：
 * 配置属性类，用于加载应用程序中定义的属性设置
 */
@Component
@Data
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    /**
     * 日期格式设置
     * 这个属性用于指定日期的格式，以便在应用程序中统一管理日期的显示和处理
     */
    private String dateformat;
}

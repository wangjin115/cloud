package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wj
 * @version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern")    //prefix = "pattern"与方法名拼接
public class PatternProperties {
    private String dateformat;

}

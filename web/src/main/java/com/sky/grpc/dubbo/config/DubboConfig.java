package com.sky.grpc.dubbo.config;

import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019/12/9 8:00 下午
 */
@Configuration
public class DubboConfig {
    /**
     * 配置文件里配置默认的，这里配置其他需要的
     */
//    @Bean("otherRegistry")
//    @ConfigurationProperties(prefix = "registry.other")
//    public RegistryConfig otherRegistry() {
//        return new RegistryConfig();
//    }
}

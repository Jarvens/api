package com.hcon.core.config;

import com.google.common.collect.Lists;
import com.hcon.core.interceptor.login.LoginInterceptor;
import org.n3r.diamond.client.Miner;
import org.n3r.diamond.client.Minerable;
import org.n3r.diamond.sdk.DiamondSDK;
import org.n3r.diamond.sdk.domain.DiamondConf;
import org.n3r.diamond.sdk.domain.DiamondSDKConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by kunlun on 2017/3/28.
 */
@Configuration
public class SpringConfig extends WebMvcConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(SpringConfig.class);

    /**
     * 持久化配置  diamond
     *
     * @return
     */
    @Bean
    public DiamondSDK diamondSDK() {
        Minerable minerable = new Miner().getMiner("hcon.diamond", "diamondConfig");
        DiamondSDK diamondSDK = new DiamondSDK(new DiamondSDKConf(Lists.newArrayList(
                new DiamondConf(minerable.getString("diamondIp"), minerable.getInt("diamondPort"),
                        minerable.getString("diamondUsername"),
                        minerable.getString("diamondPassword")))));

        logger.info("Diamond init success ");
        return diamondSDK;
    }

    /**
     * 消息类型转换
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList(converter.getSupportedMediaTypes());
        mediaTypes.addAll(asList(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.TEXT_XML));
        converter.setSupportedMediaTypes(mediaTypes);
        converters.add(converter);
        super.configureMessageConverters(converters);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
        super.addInterceptors(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
        super.addCorsMappings(registry);
    }
}

package com.sky.grpc.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.sky.generated.HelloRequest;
import com.sky.generated.HelloResponse;
import com.sky.generated.HelloResponseOrBuilder;
import com.sky.grpc.dubbo.api.IHelloService;
import org.springframework.stereotype.Component;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019/12/9 9:55 上午
 */
@Service(interfaceClass = IHelloService.class)
@Component
public class HelloServiceImpl implements IHelloService{

    @Override
    public String hello(String message) {
        System.out.println("receive:" + message);
        return message;
    }

    @Override
    public HelloResponse grpc(HelloRequest helloRequest) {
        System.out.println("grpc receive:" + helloRequest.getName());
        return HelloResponse.newBuilder().setMessage(helloRequest.getName()).build();
    }
}

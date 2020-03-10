package com.sky.grpc.dubbo.api;

import com.sky.generated.HelloRequest;
import com.sky.generated.HelloResponse;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019/12/9 9:55 上午
 */
public interface IHelloService {
    String hello(String message);

    HelloResponse grpc(HelloRequest helloRequest);
}

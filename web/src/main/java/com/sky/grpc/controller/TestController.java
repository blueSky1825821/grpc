package com.sky.grpc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sky.generated.HelloRequest;
import com.sky.generated.HelloResponse;
import com.sky.grpc.dubbo.api.IHelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019/12/7 3:49 下午
 */
@RestController
@Slf4j
public class TestController {

    private ApplicationContext context;
    private static final ExecutorService executor = Executors.newFixedThreadPool(2);

//    @Reference
        @Reference(url = "dubbo://127.0.0.1:20880?serialization=protobuf")
    private IHelloService helloService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get() {
        return "ok";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(@RequestParam(name = "message") String message) {
        System.out.println("send:" + message);
        helloService.hello(message);
        return message;
    }

    @RequestMapping(value = "grpc", method = RequestMethod.GET)
    public String grpc(@RequestParam(name = "message") String message) {
        System.out.println("send:" + message);
        HelloRequest build = HelloRequest.newBuilder().setName(message).build();
        HelloResponse grpc = helloService.grpc(build);
        return grpc.getMessage();
    }

    @RequestMapping(value = "sync", method = RequestMethod.GET)
    public void sync(@RequestParam(name = "message") String message, HttpServletRequest request) {
        System.out.println("sync send:" + request.getParameter("message"));
        executor.submit(() -> System.out.println("sync--" + request.getParameter("message")));
        System.out.println("sync send:" + request.getParameter("message"));
    }

    @RequestMapping(value = "async", method = RequestMethod.GET)
    public void async(@RequestParam(name = "message") String message, HttpServletRequest request) {
        request.getServletContext().getAttribute("executor");
        AsyncContext asyncContext = request.startAsync();
        asyncContext.start(() -> {
            System.out.println("async send:" + asyncContext.getRequest().getParameter("message"));
            executor.submit(() -> System.out.println("async--" + asyncContext.getRequest().getParameter("message")));
            System.out.println("async send:" + asyncContext.getRequest().getParameter("message"));
            asyncContext.complete();
        });

        System.out.println("end async send:" + request.getParameter("message"));

    }
}

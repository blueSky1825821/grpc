package com.sky.grpc.dubbo.serialize;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.sky.generated.HelloRequest;
import com.sky.generated.HelloResponse;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * DESCRIPTION:
 * <P>
 * todo 暂时无效
 * </p>
 * 1
 *
 * @author WangMin
 * @since 2019/12/13 8:35 下午
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

    @Override
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<>();
        classes.add(HelloRequest.class);
        classes.add(HelloResponse.class);
        return classes;
    }
}

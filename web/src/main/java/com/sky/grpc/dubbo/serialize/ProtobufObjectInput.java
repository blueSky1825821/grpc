package com.sky.grpc.dubbo.serialize;

import com.alibaba.dubbo.common.serialize.ObjectInput;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Type;

public class ProtobufObjectInput implements ObjectInput {

    private ObjectInputStream input;

    public ProtobufObjectInput(InputStream inputStream) throws IOException {
        this.input = new ObjectInputStream(inputStream);
    }

    @Override
    public boolean readBool() throws IOException {
        return input.readBoolean();
    }

    @Override
    public byte readByte() throws IOException {
        return input.readByte();
    }

    @Override
    public short readShort() throws IOException {
        return input.readShort();
    }

    @Override
    public int readInt() throws IOException {
        return input.readInt();
    }

    @Override
    public long readLong() throws IOException {
        return input.readLong();
    }

    @Override
    public float readFloat() throws IOException {
        return input.readFloat();
    }

    @Override
    public double readDouble() throws IOException {
        return input.readDouble();
    }

    @Override
    public byte[] readBytes() throws IOException {
        int len = input.readInt();
        if (len < 0) {
            return null;
        } else if (len == 0) {
            return new byte[] {};
        } else {
            byte[] b = new byte[len];
            input.readFully(b);
            return b;
        }
    }

    @Override
    public String readUTF() throws IOException {
        return input.readUTF();
    }

    @Override
    public Object readObject() throws IOException, ClassNotFoundException {
        return input.readObject();
    }

    @Override
    public <T> T readObject(Class<T> clazz) throws IOException {
        try {
            byte[] buffer = (byte[]) input.readObject();
            input.read(buffer);
            return SerializationUtil.deserialize(buffer, clazz);
        } catch (Exception e) {
            throw new IOException(e);
        }

    }

    @Override
    public <T> T readObject(Class<T> clazz, Type type) throws IOException {
        try {
            byte[] buffer = (byte[]) input.readObject();
            input.read(buffer);
            return SerializationUtil.deserialize(buffer, clazz);
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
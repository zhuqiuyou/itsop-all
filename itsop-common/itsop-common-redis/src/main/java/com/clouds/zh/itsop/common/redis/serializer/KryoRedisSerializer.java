package com.clouds.zh.itsop.common.redis.serializer;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
 
import java.io.ByteArrayOutputStream;
 
@Slf4j
public class KryoRedisSerializer<T> implements RedisSerializer<T> {

    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
 
    private static final ThreadLocal<Kryo> kryos = ThreadLocal.withInitial(Kryo::new);
 
    private Class<T> clazz;
 
    public KryoRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }
 
    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return EMPTY_BYTE_ARRAY;
        }
 
        Kryo kryo = kryos.get();
        kryo.setReferences(false);
        kryo.register(clazz);
 
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             Output output = new Output(baos)) {
            kryo.writeClassAndObject(output, t);
            output.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            log.error("#redis序列化发生异常{}", e);
        }
 
        return EMPTY_BYTE_ARRAY;
    }
 
    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
 
        Kryo kryo = kryos.get();
        kryo.setReferences(false);
        kryo.register(clazz);
 
        try (Input input = new Input(bytes)) {
            return (T) kryo.readClassAndObject(input);
        } catch (Exception e) {
            log.error("#redis反序列化发生异常{}", e);
        }
 
        return null;
    }
 
}
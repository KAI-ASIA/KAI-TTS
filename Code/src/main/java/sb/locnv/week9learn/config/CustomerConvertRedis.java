package sb.locnv.week9learn.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

public class CustomerConvertRedis {

    @WritingConverter
    @Component
    public static class TimestampToByte implements Converter<Timestamp, byte[]> {
        @Override
        public byte[] convert(Timestamp source) {
            return source.toString().getBytes();
        }
    }


    @ReadingConverter
    @Component
    public static class ByteToTimeStamp implements Converter<byte[], Timestamp> {
        @Override
        public Timestamp convert(byte[] source) {
            return Timestamp.valueOf(new String(source));
        }
    }

}

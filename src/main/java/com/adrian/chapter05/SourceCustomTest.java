package com.adrian.chapter05;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author junyang.shi
 * @date 2022/12/16 15:32
 **/
public class SourceCustomTest {
    public static void main(String[] args) throws Exception {
        //创建执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(1);

        //获取自定义数据源
        DataStreamSource<Event> customSource = env.addSource(new ClickSource());

        customSource.print();

        env.execute();
    }
}

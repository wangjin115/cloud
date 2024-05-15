package cn.itcast.hotel.config;

import cn.itcast.hotel.constants.MqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wj
 * @version 1.0
 */
@Configuration
public class MqConfig {

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(MqConstants.EXCHANGE_NAME,true,false);

    }
    @Bean
    public Queue insertQueue(){
        return new Queue(MqConstants.INSERT_QUEUE_NAME,true);
    }

    @Bean
    public Queue deleteQueue(){
        return new Queue(MqConstants.DELETE_QUEUE_NAME,true);

    }

    @Bean
    public Binding insertQueueBinding(){
        return BindingBuilder.bind(insertQueue()).to(topicExchange()).with(MqConstants.INSERT_KEY);

    }

    @Bean
    public Binding deleteQueueBinding(){
        return BindingBuilder.bind(deleteQueue()).to(topicExchange()).with(MqConstants.DELETE_KEY);
    }
}

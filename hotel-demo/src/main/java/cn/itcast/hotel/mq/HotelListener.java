package cn.itcast.hotel.mq;

import cn.itcast.hotel.constants.MqConstants;
import cn.itcast.hotel.service.IHotelService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wj
 * @version 1.0
 */
@Component
public class HotelListener {
    @Autowired
    private IHotelService hotelService;
    @RabbitListener(queues = MqConstants.INSERT_QUEUE_NAME)
    public void listenHotelInsertOrUpdate(Long id){
        hotelService.insertById(id);

    }


    @RabbitListener(queues = MqConstants.DELETE_QUEUE_NAME)
    public void listenHotelDelete(Long id){
        hotelService.deleteById(id);

    }
}

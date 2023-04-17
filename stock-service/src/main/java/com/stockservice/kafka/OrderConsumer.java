package com.stockservice.kafka;

import com.basedomains.dto.OrderEvent;
import com.stockservice.Repository.OrderEventRepo;
import com.stockservice.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @Autowired
    private OrderEventRepo repo;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
    @KafkaListener(topics = "${spring.kafka.topic.name}",
                    groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event)
    {

        LOGGER.info(String.format("Order Event recieved => %s",event.toString()));
        //save the order even data into the database
        Order orderEvent = new Order(event.getMessage(),event.getStatus(),event.getOrder().getName(),event.getOrder().getQty(),event.getOrder().getPrice());
        repo.save(orderEvent);
    }


}

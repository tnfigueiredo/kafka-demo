package com.tnfigueiredo.kafkademo.kafka

import com.tnfigueiredo.kafkademo.model.Event
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class EventConsumer {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(EventConsumer::class.java)
    }

    var numberEvents = 0

    @KafkaListener(topics = ["simple-event-topic"], groupId = "simple-kotlin-event-consumer")
    fun consume(event: Event) {
        LOGGER.info("got message: {}", event)
        numberEvents++
    }

}
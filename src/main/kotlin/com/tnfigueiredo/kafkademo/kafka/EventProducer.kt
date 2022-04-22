package com.tnfigueiredo.kafkademo.kafka

import com.tnfigueiredo.kafkademo.model.Event
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class EventProducer(private val kafkaTemplate: KafkaTemplate<String, Any>) {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(EventProducer::class.java)
    }

    var numberEvents = 0

    fun send(event: Event) {
        LOGGER.info("send message: {}", event)
        kafkaTemplate.send("simple-event-topic", event)
        numberEvents++
    }

}
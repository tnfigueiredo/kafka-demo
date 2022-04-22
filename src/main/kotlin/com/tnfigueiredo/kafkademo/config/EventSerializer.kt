package com.tnfigueiredo.kafkademo.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.tnfigueiredo.kafkademo.model.Event
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer
import org.slf4j.LoggerFactory

class EventSerializer : Serializer<Event> {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(EventSerializer::class.java)
    }

    private val objectMapper = ObjectMapper()

    override fun serialize(topic: String?, data: Event?): ByteArray? {
        LOGGER.info("Serializing...")
        return objectMapper.writeValueAsBytes(
            data ?: throw SerializationException("Error when serializing Product to ByteArray[]")
        )
    }

    override fun close() {}

}
package com.tnfigueiredo.kafkademo.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.tnfigueiredo.kafkademo.model.Event
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Deserializer
import org.slf4j.LoggerFactory
import kotlin.text.Charsets.UTF_8

class EventDeserializer: Deserializer<Event> {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(EventDeserializer::class.java)
    }

    private val objectMapper = ObjectMapper()

    override fun deserialize(topic: String?, data: ByteArray?): Event? {
        LOGGER.info("Deserializing...")
        return objectMapper.readValue(
            String(
                data ?: throw SerializationException("Error when deserializing byte[] to Product"), UTF_8
            ), Event::class.java
        )
    }

    override fun close() {}

}
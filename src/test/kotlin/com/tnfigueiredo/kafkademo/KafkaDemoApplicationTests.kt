package com.tnfigueiredo.kafkademo

import com.tnfigueiredo.kafkademo.kafka.EventProducer
import com.tnfigueiredo.kafkademo.model.Event
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.test.context.EmbeddedKafka
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import java.util.UUID

@SpringBootTest
@DirtiesContext
@EmbeddedKafka(partitions = 1, brokerProperties = [ "listeners=PLAINTEXT://localhost:9092", "port=9092" ])
@ActiveProfiles("test")
class KafkaDemoApplicationTests{

	@Autowired
	private lateinit var eventProducer: EventProducer

	@BeforeEach
	fun setUp() {
		eventProducer.numberEvents = 0
	}

	@Test
	internal fun `given embedded kafka create event for producer with success`() {
		val event = Event(UUID.randomUUID(), "My test event")
		eventProducer.send(event)
		assertEquals(1, eventProducer.numberEvents)
	}

}

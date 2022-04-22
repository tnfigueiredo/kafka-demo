package com.tnfigueiredo.kafkademo.resources

import com.tnfigueiredo.kafkademo.kafka.EventProducer
import com.tnfigueiredo.kafkademo.model.Event
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/events")
class EventResource(private val eventProducer: EventProducer) {

    @PostMapping
    fun publish(@RequestBody event: Event) {
        eventProducer.send(event)
    }

}
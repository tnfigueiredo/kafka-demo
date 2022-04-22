package com.tnfigueiredo.kafkademo.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.UUID

data class Event(
  @JsonProperty
  val id: UUID = UUID.randomUUID(),
  @JsonProperty
  val content: String = ""
)
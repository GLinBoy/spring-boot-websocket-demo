package com.glinboy.demo.websocket.producer.controller

import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class WebSocketController {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @MessageMapping("/send-message")
    @SendTo("/topic/messages")
    fun sendMessage(): String {
        while (true) {
            Thread.sleep(500)
            val message = "New message at: ${System.currentTimeMillis()}"
            log.info("Sending message: $message")
            return message
        }
    }
}

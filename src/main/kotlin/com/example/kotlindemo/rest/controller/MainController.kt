package com.example.kotlindemo.rest.controller

import com.example.kotlindemo.rest.service.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class MainController {
    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "User") name: String)
            = Greeting(counter.incrementAndGet(), "Hello, $name !")

}
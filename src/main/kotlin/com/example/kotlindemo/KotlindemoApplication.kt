package com.example.kotlindemo

import com.example.kotlindemo.neural.NeuralMain
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlindemoApplication

fun main() {
//    runApplication<KotlindemoApplication>(*args)

    val nn = NeuralMain()
    nn.startNeuralExample()
}

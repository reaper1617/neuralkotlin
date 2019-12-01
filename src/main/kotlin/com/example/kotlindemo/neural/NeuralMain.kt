package com.example.kotlindemo.neural

import com.example.kotlindemo.neural.matrix.Matrix
import kotlin.math.exp

class NeuralMain {

    fun startNeuralExample() {

        println("Start learning neural networks! Finally!")

        // set up hyperparams
        val inputLayerSize = 2;
        val outputLayerSize = 1;
        val hiddenLayerSize = 3;

//        println("****Test for matrix multiplying***")
//
//        var M1 = Matrix(2,3)
//        M1.init(true)
//        println("Matrix 1:")
//        M1.print()
//
//
//        var M2 = Matrix(3,5)
//        M2.init(true)
//        println("Matrix 2:")
//        M2.print()
//
//
//        val res = M1.multiply(M2)
//        println("Matrix 1 * Matrix2:")
//        res.print()
//
//        println("********************************")




        var inputMatrix = Matrix(3, 2)
        inputMatrix.init(true)
        println("Input matrix :")
        inputMatrix.print()

        // init W1 by random values according dimension
        var W1 = Matrix(inputLayerSize, hiddenLayerSize)
        W1.init(true)
        println("W1 matrix :")
        W1.print()

        // init W2 by random values according dimension
        var W2 = Matrix(hiddenLayerSize, outputLayerSize)
        W2.init(true)
        println("W2 matrix :")
        W2.print()

        // Z2 = X * W1

        var Z2 = inputMatrix.multiply(W1)
        println("Z2 matrix :")
        Z2.print()

        // apply sigmoid activation function: A2 = f(Z2)

        var A2 = Z2.applySigmoidToMatrix();
        println("A2 matrix (Z2 after sigmoid apply) :")
        A2.print()

        // Z3 = A2 * W2
        var Z3 = A2.multiply(W2)
        println("Z3 matrix: ")
        Z3.print()

        // apply activation function
        var YHat = Z3.applySigmoidToMatrix()
        println("YHat matrix: ")
        YHat.print()
    }
}
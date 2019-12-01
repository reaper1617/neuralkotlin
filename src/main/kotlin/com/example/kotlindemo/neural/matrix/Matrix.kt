package com.example.kotlindemo.neural.matrix

import java.lang.IllegalArgumentException
import kotlin.math.exp
import kotlin.random.Random

class Matrix(private val rows: Int, private val columns: Int) {
    private val matrix = mutableListOf<MutableList<Double>>()
    fun init(random: Boolean = false) {
        if (rows < 1 || columns < 1) {
            throw IllegalArgumentException("Rows and columns number should be at least 1!");
        }
        for (i in 1..rows) {
            val tmpList = mutableListOf<Double>()
            for (j in 1..columns) {
                if (!random) {
                    tmpList.add(0.0)
                } else {
                    tmpList.add(Math.random())
                }
            }
            matrix.add(tmpList)
        }
    }

    fun print() {
        for (i in 1..rows) {
            val tmpList = matrix[i - 1]
            for (j in 1..columns) {
                print("${tmpList[j - 1]} ")
            }
            println()
        }
    }

    fun multiply(anotherMatrix: Matrix): Matrix {
        if (this.columns != anotherMatrix.rows) {
            throw IllegalArgumentException("Dimensions of given matrices are wrong!")
        }
        var m = this.rows
        var n = this.columns
        var k: Int = anotherMatrix.columns
        val resMatrix = Matrix(m,k)
        resMatrix.init()
        for (p in 0 until m) {
            for (u: Int in 0 until k) {
                var sum = 0.0
                for (i in 0 until n) {
                    sum += this.matrix[p][i] * anotherMatrix.matrix[i][u];
                }
                resMatrix.matrix[p].add(u,sum)
            }
        }
        return resMatrix
    }
//
//    fun multiply(number: Double) {
//
//    }

    fun applySigmoidToMatrix():Matrix{
        for(row in this.matrix){
            for(i in 0 until row.size){
                row[i] = sigmoid(row[i])
            }
        }
        return this
    }

    fun sigmoid(x: Double):Double{
        return 1/(1 + exp(-x))
    }
}
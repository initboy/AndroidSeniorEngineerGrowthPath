package com.time.se.base

import com.time.se.BaseTest
import org.junit.After
import org.junit.Test

import org.junit.Before

//选中一个类的名字 alt + enter 可以创建单元测试
class Step1GenericTest : BaseTest() {
    var generic: Step1Generic? = null

    @Before
    fun start() {
        generic = Step1Generic()
    }

    @After
    fun tearDown() {
        generic = null
    }

    @Test
    fun testGenericClass() {
        generic?.run {
            val genericIntClass = Generic(3)
            val genericStrClass = Generic("some string")
            val genericBoolClass = Generic(true)
            val genericNullClass = Generic(null)
            i("Generic class key is ${getGenericKey(genericIntClass)}")
            i("Generic class key is ${getGenericKey(genericStrClass)}")
            i("Generic class key is ${getGenericKey(genericBoolClass)}")
            i("Generic class key is ${getGenericKey(genericNullClass)}")
        }
    }

    @Test
    fun testGenericInterface() {
        val animalGenerator = generic?.AnimalGenerator()
        animalGenerator?.run {
            i("Generator animal ${next()}")
            i("Generator animal ${next()}")
            i("Generator animal ${next()}")
        }
    }

    @Test
    fun testGenericMethod() {
        generic?.run {
            i(eq(12, 8))

            val dest = ArrayList<Number>()
            val srcInteger = ArrayList<Int>()
            srcInteger.add(4)
            srcInteger.add(9)
            copy(dest, srcInteger)
            val srcNumber = ArrayList<Number>()
            srcNumber.add(7.8)
            srcNumber.add(100)
            copy(dest, srcNumber)
            val srcFloat = ArrayList<Float>()
            srcFloat.add(8.8F)
            copy(dest, srcFloat)
            i(dest)
        }
    }
}
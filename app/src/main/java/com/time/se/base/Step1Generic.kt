package com.time.se.base

// 深入Java | kotlin 泛型
// 为了确保类型的安全性 编译器承担了全部的类型检查工作
// 有了泛型，我们可以拥有更强大更安全的类型检查、无需手工进行类型转换，并且能够开发更加通用的泛型算法。尤其在集合类中。我们可以发现大量的泛型代码。

// E - Element (在集合中使用，因为集合中存放的是元素)
// T - Type（Java 类）
// K - Key（键）
// V - Value（值）
// N - Number（数值类型）
// ？ - 在 java 中表示不确定的类型 kotlin 中用 * 表示不确定的类型
class Step1Generic {

    //泛型类、泛型接口、泛型方法

    //1.泛型类
    inner class Generic<K>(key: K) {
        var key: K? = key
    }

    //泛型通配符kotlin *  java ?
    fun getGenericKey(obj: Generic<*>?): Any? = obj?.key

    //2.泛型接口
    interface Generator<T> {
        fun next(): T
    }

    inner class AnimalGenerator : Generator<String> {
        private val animals = arrayOf("cat", "dog", "bird")
        override fun next(): String {
            return animals[animals.indices.random()]
        }
    }

    //3.泛型方法
    //这里的 T : Comparable<T> ，表示 Comparable<T>是类型 T 的上界。也就是告诉编译器，
    // 类型参数 T 代表的都是实现了 Comparable<T> 接口的类，这样等于告诉编译器它们都实现了compareTo方法。
    // 如果没有这个类型上界声明，我们就无法直接使用 compareTo （ > ）操作符。
    // 也就是说，下面的代码编译不通过
    fun <N : Comparable<N>> eq(x: N, y: N): Boolean {
        return x > y
    }

    //PECS: producer-extends, consumer-super
    //in T 等价于 ? super T
    //out T 等价于 ? extends T
    //in consumer out producer
    //in 超类型下界限定符 ? super T 指定类型参数的下界（该类型必须是类型T或者它的父类型）
    //out 子类型上界限定符 ? extends T 指定类型参数的上界（该类型必须是类型T或者它的子类型）

    fun <T> copy(dest: ArrayList<in T>, src: ArrayList<out T>) {
        src.forEach {
            dest.add(it)
        }
    }

    //类型擦除 Kotlin 为泛型声明执行的类型安全检测仅在编译期进行，运行时实例不保留关于泛型类型的任何信息。这一点在 Java 中也是类似的
    //运行时 ？ * 转换成Object , 指定界的转换为界的类型

}
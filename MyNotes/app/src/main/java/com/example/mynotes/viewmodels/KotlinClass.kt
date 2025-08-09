package com.example.mynotes.viewmodels

class person(var firstName: String, secondName: String){
    //no var or val in secondary constructor
    constructor(firstName: String, age: Int): this("", ""){
        var firstNameLength = firstName.length
        println("first constructor $firstName $age");
        //var secondNameLength = secondName.length //Error
    }
    constructor(age: Int): this("",age){
        println("second constructor $age");
    }
    init {
        //we can access both firstname secondname
        println("${firstName} ${secondName} first init");
    }
    init {
        println("second init");
    }
}

fun main1(){
    //Calling second constructor
    person(age = 20)
    println(" ")
    println("Calling first constructor")
    //Calling first constructor
    var per = person(firstName = "Kalyan",30)
    //Calling main constructor
    println(" ")
    println("Calling main constructor")
    person(firstName = "Kalyan", "pidugu")


}

//Anonymous object in kotlin
val tempValues = object {
    var firstname = "kalyan"
    var secondname = "pidugu"
    var age = 10
}

//anonymous class that inherits from some type (or types),
//specify this type after object and a colon (:).
val t1 = Thread(object : Runnable{
    override fun run() {
        TODO("Not yet implemented")
    }
})

class SomeClass{
    companion object {
        val firstName = "Kalyan"
    }
}
class AnotherClass{
    companion object Counter{
        fun printName(){
            println("Companion Named Object")
        }
    }
}

fun main2(){
    println(SomeClass.firstName)
    println(AnotherClass.Counter.printName())

    var a = 10
    var b = 20
    // As an expression
    // Terinary operator replacement
    val max = if (a>b) a else b;
    val c = 20;
    val maxc = if(a>b) if(a>c) a else b else if(b>c) b else c


    //With if else block
    var maxNumber = 0;
    if(a>b){
        maxNumber = a;
    }else{
        maxNumber = b;
    }

    var number = 0;
    //Two or more choices
    //In Ranges
    when(number){
        1 -> println("One")
        2, 3 -> println("Two or Three")
        4 -> println("Four")
        in 5..8 -> println("Number between 5 and 8")
        !in 9..12 -> println("Number is not between 9 and 12")
        else -> println("Number is not between 1 and 4")
    }

    //Without arguments
    when {
        number < 1 -> println("Number is less than 1")
        number > 1 -> println("Number is greater than 1")
    }

    //Smart casting
    lateinit var x:Any
    when(x){
        is Int -> println("X is integer")
        is String -> println("X is string")
    }
    //Passing any type
    fun describe(obj: Any): String{
        when(obj){
            1 -> println("One")
            "Hello" -> println("Hello")
            is Int -> println("Number")
            else -> println("Number is not between 1 and 4")
        }
        return ""
    }


}

fun main3(){
    var names = listOf("Kotlin" ,"Dart","C#","JavaScript","Swift", "Java")
    //Single line
    for (name in names) println(name)
    //With bloc of statements
    for (name in names){
        println(name)
    }

    //With Index
    for ((name,index) in names.withIndex()){
        println("$name with index $index")
    }
    //with ranges
    for(i in 0..5){
        println(i)
    }
    //With ranges and steps
    for (i in 0..5 step 2) print(i)
}

fun main(){
    var names = listOf(1,2,3,4,5,6)
    //Each Indivisual item transformed
    //Resulted list has same length
    println(names.map { it * 2 })
    //Makes array into smaller array
    println(names.filter { it % 2 == 0 });
    //Reduce into single value
    //AGGREGATE / ACCUMULATE, acc have first value
    println(names.reduce { acc, i ->  acc + i})
    //Fold have initial value
    println(names.fold(20) { acc, i ->  acc + i})
}

package com.example.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab3.ui.theme.Lab3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab3Theme {
        Greeting("Android")
    }
}

//Task 1
abstract class Food(val name: String, val price: Float){
    abstract fun cook(): String
}

//Task 2
class Burguer(name: String, price: Float): Food(name, price){
    override fun cook(): String{
        return "Algo de asar una hamburguesa"
    }
}

class Pizza(name: String, price: Float): Food(name, price){
    override fun cook(): String{
        return "algo de hornear pizzas"
    }
}

//Task 3
interface Dessert {
    fun eat(): String
}

//Task 4
class IceCream(name: String, price: Float): Food(name, price), Dessert {
    override fun cook(): String{
        return "algo de enfriar helado"
    }
    override fun eat(): String{
        return "lamer el helado"
    }
}

//Task 5
abstract class Drink(name: String, price: Float): Food(name, price){
    abstract fun pour(): String
}

//Task 6
class Juice(name: String, price: Float): Drink(name, price){
    override fun pour(): String{
        return "algo de verter jugo"
    }
    override fun cook(): String{
        return "algo de exprimir jugo"
    }
}

//Task 7
fun Food.discountedPrice(discount: Int): Float{
    return this.price*(discount/100)
}

fun main(){
    val menu = listOf(Pizza("ChesePizza",12.99f),
        Burguer("MeltBurger",6.77f),
        IceCream("VanillaIceCream",2.49f),
        Juice("OrangeJuice",2.19f))

    //Task 8
    println("Task 8")
    menu.forEach{ i ->
        println(i.cook())
    }
    println("Task 9")
    //Task 9
    val trialIceCream = IceCream("ChocomintIceCream",2.49f)

    trialIceCream.eat()

    println("Task 10")
    val savage = Burguer("300 Savage",15.99f)

    //Task 10
    println(savage.discountedPrice(15))

}
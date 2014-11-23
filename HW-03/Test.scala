/*
 Yusuf Biber
 160201018
 CENG432
 Homework 3 - Test
  */

import scala.util.Random
import java.util.Scanner

object Test extends App {
  
  var input = new Scanner(System.in);
    
  val a = IyteImmutableSet()
  val b = a.add(10)
  val c = b.add(10)
  val d = c.add(5)
  val e = d.add(61)
  val f = e.add(99)
  val g = f.add(-3)
  val i = g.add(1)
  val j = i.add(1)

  println("Elements of immutable sets:")
  println("----------------------------------------")
  println(a.toString)
  println(b.toString)
  println(c.toString)
  println(d.toString)
  println(e.toString)
  println(f.toString)
  println(g.toString)
  println(i.toString)
  println(j.toString)
  println("----------------------------------------")
  
  var m = j.add(1000)
  for(k<-0 to 100000){
    var n = m.add(k)
  }
  println("Elements of immutable set 'm'")
  println(m.toString)
  println("----------------------------------------")
  
  var ms= IyteMutableSet()
  ms.add(9)
  ms.add(5)
  ms.add(61)
  ms.add(-6)
  ms.add(-1)
  ms.add(9)
  ms.add(0)
  
  println("Elements of mutable set 'ms'")
  println(ms.toString)
  println("-------------------------------------")
  
  println("From -1 millions to 1 millions all numbers are being added to the mutable set 'ms'")
  println("-----------------------------------------------------------------------------")
  
  for(j<-(-1000000) to 1000000){
    ms.add(j)
  }
  
  var y = 0
  
  while(y<100){
  println("Enter the number to look if it is contained by the mutable set 'ms'")
  var z = input.nextInt()
  println(ms.contains(z))
  println("-------------------------------------")
  y=y+1
  }
  
}

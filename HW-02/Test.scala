/*
 Yusuf Biber
 160201018
 CENG432
 Homework 2 - Test
  */

object Test extends App{
  
 
	val a = IyteMutableList()		//create object IyteMutableList
	println(a.toString)				//list the elements of the object a
	a.add(20)						//adds an element to the object a
	println(a.toString)
	a.add(24)
	println(a.toString)
	a.add(61)
	println(a.toString)
	a.add(18)
	println(a.toString)
	
	val j = a.add(1)				//adds an element to the object a, and also keeps as object j
	println(j.toString)
	println(a.toString)
	
	
	val b = IyteImmutableList()		//create object IyteImmutableList
	b.add(21)						//nothing changes because the object b is immutable
	
	val c = b.add(10)				//adds an element to the object b, and only keeps as object c
	val d = c.add(61)
	val e = d.add(82)
	val f = e.add(91)
	val g = c.add(99)
	val i = f.add(1967)
	
	println(b.toString)				//lists the elements of all immutable objects
	println(c.toString)
	println(d.toString)
	println(e.toString)
	println(f.toString)
	println(g.toString)
	println(i.toString)
	
}

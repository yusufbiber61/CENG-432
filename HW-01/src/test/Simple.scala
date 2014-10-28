/*
 Yusuf Biber
 160201018
 CENG432
 Homework 1
  */
 


package test

object Simple extends App{
  
  val numbersArray = Array(10,25,30)				//defined array whose element cant be changed later

  def getPrintedResult (number : Int) : Int = {			//the method to return the value up to the condition
	if(number%2 == 0){
	number*2
	}else{
	number*3
	}

  }
	
	try{
	  numbersArray.foreach(key => println(getPrintedResult(key)))	//tries to send all elements of the array to the method and print the returned values
	}
	catch{
	  case e: Exception => println("Error")
	}
}
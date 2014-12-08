/*
 Yusuf Biber
 160201018
 CENG432
 Homework 5 - RandomStuff
  */

trait RandomStuffTrait {
def transform(list: List[Int], op: (Int) => Int) : List[Int]
def allValid(list: List[Int], op: (Int) => Boolean) : Boolean
def executeWithRetry(retryCount: Int, op: => Int) : Option[Int]
}

object RandomStuff extends RandomStuffTrait {

  def transform(list: List[Int], op: (Int) => Int) : List[Int]={
    var transformedList = List[Int]()							//initialize the transformedList  
    for (currentItem <- list) {  
      try{													//try to operate the elements of the list      
        transformedList = transformedList :+ op(currentItem)
      }
      catch{													//operation is not valid
      case e: Exception => println("Ouppss!! Operation "+op+" could not be implemented to the "+currentItem+" !!")	 
      }
      
    }
    
    transformedList
  }
  
  def allValid(list: List[Int], op: (Int) => Boolean) : Boolean={
    for (currentItem <- list) {
      try{      
        if(!op(currentItem)){
          return false
        }
      }
      catch{
      case e: Exception => println("Ouppss!! Operation "+op+" could not be implemented to the "+currentItem+" !!")
      return false
      }
    }
    true
  }
  
  def executeWithRetry(retryCount: Int, op: => Int) : Option[Int]={        
    for( i <- 1 to retryCount){     
      try{
        return Option(op)
      }
      catch{
      case e: Exception => println(i+". Try failed!!")
      }
    }
    return None
  }
}

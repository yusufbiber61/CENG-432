/*
 Yusuf Biber
 160201018
 CENG432
 Homework 2 - IyteImmutableList
  */

class IyteImmutableList(consHead:Node) {	//we need head to know the start, and prepend an element

  val head = consHead						//constant head node is equal to constructed head
  
  def add(x:Int):IyteImmutableList={		//add method of the IyteImmutableList
    
  var number = new Node(x)				//creates the new node with item comes to function
  var nextHead=new Node(null)				//nextHead node which will be head of the IyteImmutableList that will be returned
	
    if(head.item == null){					//looks if the head is null or not
     nextHead=number
    }
    else{
      number.nextNode = head				//prepends new node
      nextHead=number
    }
	
  new IyteImmutableList(nextHead)			//returns the new IyteImmutableList with newHead
  }
  
  override def toString():String={			//toString method of the IyteImmutableList
    
    var returned=""						//create and initialize the string which will be returned
    var walker = head						//node that will search all of the elements by beginning from head
    
    if(walker.item != null){
      while(walker != null){
        returned=returned.concat(walker.item.toString+", ")	//adds found item to the returned string
        walker=walker.nextNode 					//goes to the next node of the element
      }
    }
    else{
      returned="There are no elements in the list  "
    }
    
  returned.dropRight(2)					//returns the string by removing last two chars
  }
}

object IyteImmutableList{					//companion object of the IyteImmutableList
	
	def apply() = {							//constructs the new empty IyteImmutableList
	  new IyteImmutableList(new Node(null))
	}
	
}

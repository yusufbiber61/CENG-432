/*
 Yusuf Biber
 160201018
 CENG432
 Homework 2 - IyteMutableList
  */

class IyteMutableList(consHead:Node,consLast:Node) {	//we need head to know the start, and last to append an element

  var last = consLast					//last node is equal to constructed last
  var head = consHead					//head node is equal to constructed head
  
  def add(x:Int):IyteMutableList={		//add method of the IyteMutableList
    
    var number = new Node(x)			//creates the new node with item comes to function
    
    if(head.item == null){				//looks if the head is null or not
     head=number
     last=number
    }
    else{
    last.nextNode=number				//appends new node
    last=number
    }
    new IyteMutableList(head,last)		//returns the new IyteMutableList with head and last nodes
  }
  
  override def toString():String={		//toString method of the IyteMutableList
    var returned=""						//create and initialize the string which will be returned
    var walker = head					//node that will search all of the elements by beginning from head
    if(walker.item != null){
      while(walker != null){
        returned=returned.concat(walker.item.toString+", ")	//adds found item to the returned string
        walker=walker.nextNode 								//goes to the next node of the element
      }
    }
    else{
      returned="There are no elements in the list  "
    }
    
    returned.dropRight(2)				//returns the string by removing last two chars
    }
  
  
}

object IyteMutableList{				//companion object of the IyteMutableList
	 

		def apply() = {												//constructs the new empty IyteMutableList
	  new IyteMutableList(new Node(null),new Node(null))
	}

}

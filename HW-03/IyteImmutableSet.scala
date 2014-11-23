/*
 Yusuf Biber
 160201018
 CENG432
 Homework 3 - IyteImmutableSet
  */

class IyteImmutableSet(val elements:Array[Int],val sorted:Array[Int],val lastIndex:Int,val emptyFirstIndex:Int) {
      
    		
  var nextElements = Array.fill(lastIndex+1){0}		//array keeping the elements of the set that number will be added
  var nextSorted = Array.fill(lastIndex+1){0}		//array keeping the elements in order that number will be added
  for(i<-0 to lastIndex ){
    nextElements(i)=elements (i)
	nextSorted(i)=sorted(i)
  }
  
  var nextLastIndex = lastIndex					//is used to know the capacity of the set that number will be added
  var nextEmptyFirstIndex = emptyFirstIndex		//is used to know the size of the set that number will be added

  def add(x:Int):IyteImmutableSet={ 
    
    if(!contains(x)){								//looks if the set contains the x
      
    	if(emptyFirstIndex <= lastIndex ){				//if capacity is not full
    	  
    		nextElements(nextEmptyFirstIndex)=x			//adds to the array 'nextElements'
    		nextSorted(nextEmptyFirstIndex)=x			//adds to the array 'nextSorted'
    		nextEmptyFirstIndex = emptyFirstIndex+1		//sizes of nextElements, and nextSorted are increased by 1
    		sort()										//sorts the array 'nextSorted' with new added number
    		
    	}
    	else{																//capacity is full
    		var tempArray = Array.fill(lastIndex*(lastIndex + 1)){0}		//capacity becomes larger for the new IyteImmutableSet
    		var tempSortedArray = Array.fill(lastIndex*(lastIndex+1)){0}
    		for(i<-0 to lastIndex ){
    			tempArray(i)=elements (i)
    			tempSortedArray(i)=sorted(i)
    		}
    		
    		nextElements=tempArray
    		nextSorted=tempSortedArray
    		nextLastIndex = lastIndex * lastIndex
    		nextElements(nextEmptyFirstIndex)=x				//adds to the next arrays
    		nextSorted(nextEmptyFirstIndex)=x
    		nextEmptyFirstIndex = emptyFirstIndex+1
    		sort()											//sorts the array 'nextSorted'
    	}
    }
    
    new IyteImmutableSet(nextElements,nextSorted,nextLastIndex,nextEmptyFirstIndex)	//returns new IyteImmutableSet with new constructors
  }
  
  
    
  def contains(x:Int):Boolean={		//binary search method is used to see if the set contains the number - O(log(n))

    var first = 0
    var last = emptyFirstIndex-1
    var i=0
    
    while (first <= last){
      
    	i = (first + last)/2;
    	
    	if (sorted(i) == x){
    		return true
    	}
    	else if (sorted(i) > x){
    		last = i - 1;
    	}
    	else{
    		first = i + 1;
    	}
    }
    return false
  }
  
    
  override def toString:String={
    var returned = ""
      
      if(emptyFirstIndex != 0){
      
        for(i<-0 to emptyFirstIndex-1 ){
        	returned += elements(i).toString + ", "
        }
      }
      else{
        returned = "There are no elements in the set  "
      }
      returned.dropRight(2)
  }
  
  def sort(){							//sort method that sorts the array 'nextSorted' when a new number is added to the array 'sorted'
    
   if(nextEmptyFirstIndex>1){
    var first=0
    var last=nextEmptyFirstIndex-2

    val value=nextSorted(nextEmptyFirstIndex-1)
    
    if(value<nextSorted(first)){
      
      for(i<-(nextEmptyFirstIndex-1) until first by -1){
    		    nextSorted(i)=nextSorted(i-1)
      }
   
      nextSorted(first)=value
   	  return
    }
    else if(value>nextSorted(last)){
      return
    }
    else{
          var first2=first+1
          var last2=last-1
    	
        while(first2 <= (last2+1)){
    		  if(value>nextSorted(first) && value<nextSorted(first2) ){
    		  
    		    for(i<-(nextEmptyFirstIndex-1) until first2 by -1){
    		      nextSorted(i)=nextSorted(i-1)
    		    }
    		    nextSorted(first2)=value
    		    return
    		  }
    		  else if(value>nextSorted(last2) && value<nextSorted(last)){
    		  
    		    for(i<-(nextEmptyFirstIndex-1) until last by -1){
    		      nextSorted(i)=nextSorted(i-1)
    		    }
    		  
    		  nextSorted(last)=value
    		  return
    		  }
    		first2 += 1
    		first += 1
    		last -= 1
    		last2 -= 1 
        }
    }
    return
   }
  }
}

object IyteImmutableSet{
    
  def apply() = {
      
    val consElements = Array.fill(10){0}		//constructed values for empty IyteImmutableSet
    val consSorted = Array.fill(10){0}
    val consLastIndex=9
    val consEmptyFirstIndex=0
    
    new IyteImmutableSet(consElements,consSorted,consLastIndex,consEmptyFirstIndex )
  }
  
}

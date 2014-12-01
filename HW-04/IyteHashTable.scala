/*
 Yusuf Biber
 160201018
 CENG432
 Homework 4 - IyteHashTable
  */

class IyteHashTable(var allItems:Array[Item],var sizeOfItems:Int,var numberOfItems:Int){

 def set(key:String, value:String){
   try{
     val loadFactor=numberOfItems.toFloat / sizeOfItems
     if(loadFactor > 0.65){										//if the capacity is close to be full array is copied to larger one
       val tempSizeOfItems=sizeOfItems*2
       var tempAllItems = new Array[Item](tempSizeOfItems)  
       for(i<-0 to (sizeOfItems-1) ){
         tempAllItems(i)=allItems(i)
       }
       sizeOfItems=tempSizeOfItems
       allItems=tempAllItems
     }
	   val item = new Item(key,value)					//added item constructed
	   var addedIndex=generateHashCode(key)				//index that the item will be added into
	   while(allItems(addedIndex) != null && addedIndex < sizeOfItems){		//if the index is not empty looks the increased one (Linear Probing)
	     if(allItems(addedIndex).key == key){		//looks if key is already used
	       println("Key is already used")
	       return
	     }  
	     addedIndex=addedIndex+1
			
	     if(addedIndex==sizeOfItems){		//go to the first one from last index of the array
	       addedIndex=0
	     }
	   }
     allItems(addedIndex)=item
     numberOfItems=numberOfItems+1
   }
   catch{
     case e: Exception => println("Ouppss!! Item could not be added!!")
   }
 }  

 def get(key:String):String={
   try{
     var getIndex=generateHashCode(key)					//index that the item will be got from
     
     while(allItems(getIndex).key != key && getIndex < sizeOfItems){	//if the key is not the wanted 
       getIndex=getIndex+1
       if(getIndex==sizeOfItems){
       getIndex=0
       }
     }
     allItems(getIndex).value		//return value
   }
   catch{
    case e: Exception => return null	//not found. return null
   }
 }  
 
 def generateHashCode(key:String):Int={		//generate hash code for the string key
   var code=5381
   for(i<-0 to key.length()-1){
     code = ((code << 5) + code) + key.charAt(i)	//djb2 hash algorithm (code * 33 + key.charAt(i)) 
   }

   if(code<0){
     code=code*(-1)
   }
   code%10000000			//the remaining from the division to the constructed array size
 }

}

object IyteHashTable{
  def apply()={
    val sizeOfItems=10000000						//construct new IyteHashTable
    val allItems=new Array[Item](sizeOfItems)
    val numberOfItems=0
    new IyteHashTable(allItems,sizeOfItems,numberOfItems)
  }
}

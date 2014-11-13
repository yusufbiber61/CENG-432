/*
 Yusuf Biber
 160201018
 CENG432
 Homework 2 - Node
  */

class Node(val number:Integer) {		//we need a number to construct 

  val item = number						//item that this node keeps (can not be changed later)
  var nextNode : Node = null			//nextNode that this node keeps (can be changed later)

}

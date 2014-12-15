/*
 Yusuf Biber
 160201018
 CENG432
 Homework 6 - Homework06
  */

case class User(name: String, email: String, grade: Int)

trait UserManagerTrait {
def add(name: String, email: String, grade: Int) : Option[User]
def getUser(email: String) : Option[User]
def getUserListForGrade(grade: Int) : List[User]
def getCertainGrades(gradeSelector: (Int) => Boolean): List[String]
}
object UserManager extends UserManagerTrait {

  var userList:List[User] = Nil							//initialize the user list
  
  def add(name: String, email: String, grade: Int) : Option[User]={
    if(grade<0 || email == "" || name == ""){								//look if the conditions are okay
      println("Grade can not be smaller than '0' or email,and name can not be empty")
      return None
    }
    
    if(userList .exists(user => user.email == email)){			//look if there is a user whose email is the same		
      return None
    }
    else{
      val userAdded = new User(name,email,grade)					//initialize the user that will be added
      userList = userList :+ userAdded								//add user to the list
      return Option(userAdded)
    }
  }
  
  def getUser(email: String) : Option[User]={     
    val gotUser=userList.find(user => user.email == email)		//find the user from the list
    gotUser
  }
  
  def getUserListForGrade(grade: Int) : List[User]={
    val returnedList=userList.filter(user => user.grade == grade)		//initialize the list that will be returned by adding users filtered from the user list
    returnedList
  }
  
  def getCertainGrades(gradeSelector: (Int) => Boolean): List[String]={
    val returnedList = userList.filter(user => gradeSelector(user.grade)).map(user => user.name)	//initialize the list that will be returned by adding users' name mapped from the list filtered from the user list
    returnedList
  }
}

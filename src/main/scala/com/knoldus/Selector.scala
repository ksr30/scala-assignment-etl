package com.knoldus

object Selector {

  def read(path: String, userName: String, password: String, databaseType:String)={
    if (databaseType == "File") FileHandler.reader(path,userName,password) else List()
  }
  def write(path:String,userName:String,password:String,databaseType:String,modifiedList:List[String]):String={
    if (databaseType=="File") FileHandler.writer(path,userName,password,modifiedList) else "Unsuccessful"
  }

}

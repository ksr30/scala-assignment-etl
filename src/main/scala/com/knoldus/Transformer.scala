package com.knoldus

object Transformer {
  def capitalize(readPath: String, writePath: String, userName: String, password: String, database: String): String = {
    val filterContent = Selector.read(readPath, userName, password, database)
    val modifiedContent = filterContent.map(_.capitalize)
    Selector.write(writePath, userName, password, database, modifiedContent)
  }

  def mapMaker(readPath: String, writePath: String, userName: String, password: String, database: String): String = {
    val content = Selector.read(readPath, userName, password, database)
    val modifiedContent = content.toList.flatMap(_.split(" "))
    val genratedMap = mapper(modifiedContent, Map()).toList.map(_.toString)
    Selector.write(writePath,userName,password,database,genratedMap)

  }

  def mapper(modifiedContent: List[String], map: Map[String, Int]): Map[String, Int] = {
    modifiedContent match {
      case Nil => map
      case head :: rest => if (map.keySet.contains(head)) mapper(rest, map ++ Map(head -> (map(head) + 1))) else mapper(rest, map ++ Map(head -> 1))
    }
  }


}

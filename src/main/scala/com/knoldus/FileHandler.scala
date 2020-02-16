package com.knoldus
import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

object FileHandler {
  def reader(path: String, userName: String, password: String): List[String] = {

    val credential = Credential(path, userName, password)
    val lines = Source.fromFile(credential.path).getLines.toList
    lines
  }

  def writeFile(filename: String, lines: List[String]): Unit = {
    val file = new File(filename)
    val bw = new BufferedWriter(new FileWriter(file))
    for (line <- lines) {
      bw.write(line + " \n")
    }
    bw.close()
  }

  def writer(path: String, userName: String, password: String, modifiedList: List[String]):String = {
    writeFile(path, modifiedList)
    "written successfully"

  }
}



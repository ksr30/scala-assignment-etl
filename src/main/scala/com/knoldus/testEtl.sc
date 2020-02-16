import java.io.{BufferedWriter, File, FileWriter}

import scala.io.Source

val lines = Source.fromFile("/home/knoldus/Music/f1.txt").getLines.toList.flatMap(_.split(" "))

def mapMaker(lines: List[String], map: Map[String, Int]):Map[String,Int] = {
  lines match {
    case Nil => map
    case x :: y => if(map.keySet.contains(x)) mapMaker(y, map ++ Map(x -> (map(x)+1))) else mapMaker(y, map ++ Map(x -> 1))
  }
}
print(mapMaker(lines,Map()))

print(lines)



//def writeFile(filename: String, lines: Seq[String]): Unit = {
//  val file = new File(filename)
//  val bw = new BufferedWriter(new FileWriter(file))
//  for (line <- lines) {
//    bw.write(line+" \n")
//  }
//  bw.close()
//}

//writeFile("/home/knoldus/Music/f2.txt",x)



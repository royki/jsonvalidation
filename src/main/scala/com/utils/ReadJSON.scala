package com.utils


import scala.io.Source
import java.net.URL


// Read JSON file and return as String	
class ReadJSONFile(filename: String) {
		
	def getPath(path: String) = getClass.getResourceAsStream(filename)

	def readFile = {
		val file = Source.fromInputStream(getPath(filename))
		try file.getLines.mkString finally file.close
	}	
}


object ReadJSONFile {		

	// val fileJson = Source.fromFile("src/main/resources/wud_1.json").getLines.mkString
	val fileJson1 = new ReadJSONFile("/wud_1.json")
	// val fileJSON = Source.fromURL("https://git.io/vpg9V").mkString
	val readJson1 = fileJson1.readFile
	
	val fileJson2 = new ReadJSONFile("/wud_2.json")
	// val fileJSON = Source.fromURL("https://git.io/vpg9V").mkString
	val readJson2 = fileJson2.readFile
}

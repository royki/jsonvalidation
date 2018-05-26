package com.base


import play.api.libs.json._
import play.api.libs.json.JsNull
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._

import com.utils.ReadJSONFile._
import JsValueToModel._

object ValidateJSON extends App {
	
	// Parsing Json file to JsArray
	val json = Json.parse(readJson1) 	
	// val json = Json.parse(readJson2) 	

	// Using Recursive path by each key to traverse json
	val web_pages = json \\ "web_pages"	
	val name = json \\ "name" // val name = (json \\ "name").map(_.as[String]).toList	
	val alpha_two_code = json \\ "alpha_two_code"
	val `state-province` = json \\ "state-province"
	val domains = json \\ "domains"
	val country = json \\ "country"

	// All Key of the Json Object
	def allKeys(j: JsValue): collection.Set[String] = j match {
		case o: JsObject => o.keys ++ o.values.flatMap(allKeys)
	  	case JsArray(as) => as.flatMap(allKeys).toSet
	  	case _ => Set()
	}
	println(allKeys(json))

	// Converting JsValue to Model to read the json key value
	implicit val JsValueToModelReads: Reads[JsValueToModel] = (
		(JsPath \ "web_pages").read[Seq[String]] and
		(JsPath \ "name").read[String] and
		(JsPath \ "alpha_two_code").read[String] and
		(JsPath \ "state-province").readNullable[String] and
		(JsPath \ "domains").read[Seq[String]] and
		(JsPath \ "country").read[String]
	)(JsValueToModel.apply _)	
	

	// Validation Json Object with JsonSchemaModel
	// val validateJson: JsResult[List[JsValueToModel]] = json.validate[List[JsValueToModel]]
	// println(validateJson)	
	val validateJson = json.validate[List[JsValueToModel]] match {
		case s: JsSuccess[List[JsValueToModel]] => {
			// val v: List[JsValueToModel] = s.get	
			println("Validation Success")
		}
		case e: JsError => {
			println("Validation Errors: " + JsError.toJson(e).toString())
		}
	}	

	// val JsonArray = json.as[JsArray]
	// println(JsonArray.value.size)
		
	val nullKey = json.as[JsArray].value.map(_ \\ "state-province").map(x => x.head)
	val nullValueCount = nullKey.count {
	    case JsNull => true
	    case _ => false
  	}  	

	println(s"Key is state-province and number of null values is $nullValueCount")

}
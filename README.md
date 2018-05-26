##### _Prerequisite_
- `scala 2.12.4`
- `sbt 1.1.1`
- OS:`Linux/Ubuntu 16.04`

##### _Library_
- `play-json`
- `scalatest`

##### _Json Schema Validation_
- `SchemaJSON.scala` represents schema model of the json data
- `ValidateJSON.scala` validation of schema model
- `ReadJSON.scala` read json files from resource or url

- If validation is success it will print a Success message
- If validation failed, it will print a Error message with error values.

##### _Launch the Execution_
- Run
    + `sbt run` (it will download necessary librabry to execute the code)


##### _Expected Result_ 
- For Success Case
    +   `val json = Json.parse(readJson1)`
```scala
Set(name, web_pages, alpha_two_code, domains, country, state-province)
Validation Success
Key is state-province and number of null values is 9659
```
- For Failure Case
    + Change the value `json` as `readJson2` - `val json = Json.parse(readJson2)`
```scala
Set(name, web_pages, alpha_two_code, domains, country, county, state-province)
Validation Errors: {"obj[7740].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7741].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7742].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7743].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7744].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7745].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7746].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7747].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7748].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7749].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7750].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7751].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7752].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7753].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7754].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7755].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7756].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7757].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7758].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7759].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7760].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7761].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7762].country":[{"msg":["error.path.missing"],"args":[]}],"obj[7763].country":[{"msg":["error.path.missing"],"args":[]}]}
Key is state-province and number of null values is 9659
```


##### _to be continued_

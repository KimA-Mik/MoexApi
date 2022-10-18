import Api.MoexResponse
import moex.Request
import moex.RequestSender


fun main(args: Array<String>) {
    /*val securities = mutableListOf<Security>()*/
    val sender = RequestSender()
    val request = Request().Securities(".json")

    val response = sender.Send(request)

    if (response.statusCode() == 200){
        val moexResponse = MoexResponse()
        val tables = moexResponse.ParseFromJson(response.body())[0]
        for (sec in tables.data){
            println("${sec["id"]}:${sec["name"]}")
        }
    }
    /*if (response.statusCode() == 200){
        val deserializer = ModelDeserializer()
        val element = Json.parseToJsonElement(response.body())
        println(response.body())
        var securityData = element.jsonObject["securities"]?.jsonObject?.get("data")
        if (securityData != null) {
            for (data in securityData.jsonArray){

                securities.add(deserializer.JArrToBaseSecurity(data))
            }
        }
    }

    for (sec in securities){
        println("${sec.id}:${sec.name}")
    }*/

}
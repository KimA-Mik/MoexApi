import Api.Models.Security
import kotlinx.serialization.json.*
import moex.Request
import moex.RequestSender


fun main(args: Array<String>) {
    val securities = mutableListOf<Security>()
    val sender = RequestSender()
    val request = Request().Securities(".json")

    val response = sender.Send(request)

    if (response.statusCode() == 200){
        val element = Json.parseToJsonElement(response.body())
        println(response.body())
        var securityData = element.jsonObject["securities"]?.jsonObject?.get("data")
        if (securityData != null) {
            for (data in securityData.jsonArray){

                securities.add(DataArrayToSecurity(data))
            }
        }
    }

    for (sec in securities){
        println("${sec.id}:${sec.name}")
    }

}

fun DataArrayToSecurity(data: JsonElement) : Security{
    var temp = Security()

    temp.id = data.jsonArray[0].jsonPrimitive.int

    if (data.jsonArray[1].jsonPrimitive.isString)
        temp.secid = Json.decodeFromJsonElement(data.jsonArray[1])

    if (data.jsonArray[2].jsonPrimitive.isString)
        temp.shortname = Json.decodeFromJsonElement(data.jsonArray[2])

    if (data.jsonArray[3].jsonPrimitive.isString)
        temp.regnumber = Json.decodeFromJsonElement(data.jsonArray[3])

    if (data.jsonArray[4].jsonPrimitive.isString)
        temp.name = Json.decodeFromJsonElement(data.jsonArray[4])

    if (data.jsonArray[5].jsonPrimitive.isString)
        temp.isin = Json.decodeFromJsonElement(data.jsonArray[5])

    temp.is_traded = data.jsonArray[6].jsonPrimitive.int


    return temp
}
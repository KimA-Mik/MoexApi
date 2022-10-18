import Api.MoexResponse
import Api.MoexTable
import moex.Request
import moex.RequestSender
import kotlin.system.measureTimeMillis


fun main(args: Array<String>) {
    /*val securities = mutableListOf<Security>()*/
    val sender = RequestSender()
    val request = Request().Engines().Engine(Request.EngineType.stock).
    Markets().Market(Request.MarketType.shares).
    Securities(Request.OutputExtension.Json)

    val response = sender.Send(request)

    if (response.statusCode() == 200){
        val moexResponse = MoexResponse()
        var tables : MoexTable
        val time = measureTimeMillis {
            tables = moexResponse.ParseFromJson(response.body())[0]
        }
        for (sec in tables.data){
            println("${sec["SECID"]}:${sec["SHORTNAME"]}")
        }
        println("It took $time ms")
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
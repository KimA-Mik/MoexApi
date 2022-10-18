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
        var tables : MutableList<MoexTable>
        val time = measureTimeMillis {
            tables = moexResponse.ParseFromJson(response.body())
        }
        println("${tables[1].name}")
        for (sec in tables[1].data){
            println("${sec["SECID"]}:${ if (sec["BID"] == null) "No BID" else sec["BID"]  } - ${sec["ISSUECAPITALIZATION"]}")
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
package Api.Models

import kotlinx.serialization.json.*

class ModelDeserializer {
    fun JArrToBaseSecurity(data: JsonElement) : Security{
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
}
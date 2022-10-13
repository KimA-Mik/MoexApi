package Api.Models

import kotlinx.serialization.Serializable

@Serializable
class Security {

    var id: Int = 0
    var secid: String = String()
    var shortname: String = String()
    var regnumber: String = String()
    var name: String = String()
    var isin: String = String()
    var is_traded: Int = 0
    var emitent_id: Int = 0
    var emitent_title: String = String()
    var emitent_inn: String = String()
    var emitent_okpo: String = String()
    var gosreg: String = String()
    var type: String = String()
    var group: String = String()
    var primary_boardid: String = String()
    var marketprice_boardid: String = String()
}
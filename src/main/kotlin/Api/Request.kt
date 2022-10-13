package moex

class Request {
    var body : String = String()
    private set

    public enum class EngineType(val id : Int){
        stock(1),           //Фондовый рынок и рынок депозитов
        state(2),           //Рынок ГЦБ (размещение)
        currency(3),        //Валютный рынок
        futures(4),         //Срочный рынок
        commodity(5),	    //Товарный рынок
        interventions(6),   //Товарные интервенции
        offboard(7),	        //ОТС-система
        agro(9),	            //Агро
        otc(1012)	        //OTC Система
    }

    constructor(){
        body = "https://iss.moex.com/iss"
    }

    fun Securities(outputType : String = String()) : Request {
        body += "/securities"
        body += outputType
        return this
    }

    fun Security(securityName : String, outputType : String = String()) : Request{
        body += '/'
        body += securityName
        body += outputType
        return this
    }

    fun Aggregates(outputType : String = String()) : Request{
        body += "/aggregates"
        body += outputType
        return this
    }

    fun Engines() : Request{
        body += "/engines"
        return this
    }

    fun Engine(engineType : EngineType, outputType : String = String()) : Request{
        body += '/'
        body += engineType.name
        body += outputType
        return this
    }

}
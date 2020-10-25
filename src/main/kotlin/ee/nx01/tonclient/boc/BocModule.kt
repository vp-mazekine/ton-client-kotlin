package ee.nx01.tonclient.boc

import ee.nx01.tonclient.JsonUtils
import ee.nx01.tonclient.TonClient

class BocModule(private val tonClient: TonClient) {
    suspend fun parseMessage(params: ParamsOfParse): ResultOfParse {
        return JsonUtils.read(tonClient.request("boc.parse_message", params))
    }

    suspend fun parseTransaction(params: ParamsOfParse): ResultOfParse {
        return JsonUtils.read(tonClient.request("boc.parse_transaction", params))
    }

    suspend fun parseAccount(params: ParamsOfParse): ResultOfParse {
        return JsonUtils.read(tonClient.request("boc.parse_account", params))
    }

    suspend fun parseBlock(params: ParamsOfParse): ResultOfParse {
        return JsonUtils.read(tonClient.request("boc.parse_block", params))
    }
}

data class ParamsOfParse(
    val boc: String
)

data class ResultOfParse(
    val parsed: Map<String, Any>
)
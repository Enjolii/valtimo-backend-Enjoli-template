package com.ritense.valtimo.Enjoli.plugin

import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient


@Component
class EnjoliClient {
    fun print(print: Any) {
        println("Print function print: $print")
    }

    fun createObject(url: String, type: String, data: Any) {
        val restClient: RestClient = RestClient.create(url)
        val urlTypeAdd = "/$type"

        val response = restClient.post()
            .uri(urlTypeAdd)
            .header("Content-Type", "application/json")
            .body(data)
            .retrieve()
            .body(String::class.java)

        println("Response: $response")
    }
}
package com.ritense.valtimo.practice.service

import com.ritense.valtimo.contract.annotation.ProcessBean
import org.springframework.stereotype.Service

@ProcessBean
@Service
class Hello {
    fun hello(input: String) {
        println(input)
    }

    fun error(input: String) {
        println(input)
    }
}
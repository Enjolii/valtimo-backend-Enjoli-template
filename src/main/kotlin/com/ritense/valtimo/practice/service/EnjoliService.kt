package com.ritense.valtimo.practice.service

import com.ritense.valtimo.contract.annotation.ProcessBean
import org.springframework.stereotype.Service

@ProcessBean
@Service
class EnjoliService {
    fun hello(input: String) {
        println(input)
    }

    fun som(input1: Int, input2: Int) {
        println(input1 + input2)
    }
}
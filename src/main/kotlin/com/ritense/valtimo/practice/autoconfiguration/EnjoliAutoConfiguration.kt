package com.ritense.valtimo.practice.autoconfiguration

import com.ritense.plugin.service.PluginService
import com.ritense.valtimo.Enjoli.plugin.EnjoliClient
import com.ritense.valtimo.Enjoli.plugin.EnjoliPluginFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class EnjoliAutoConfiguration {
    @Bean
    fun enjoliPluginFactory(
        pluginService: PluginService,
        enjoliClient: EnjoliClient,
    ): EnjoliPluginFactory =
        EnjoliPluginFactory(
            pluginService = pluginService,
            enjoliClient = enjoliClient,
        )
}
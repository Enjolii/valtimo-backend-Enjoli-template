package com.ritense.valtimo.Enjoli.plugin

import com.ritense.plugin.PluginFactory
import com.ritense.plugin.service.PluginService
import org.springframework.stereotype.Component

@Component
class EnjoliPluginFactory(
    pluginService: PluginService,
    val enjoliClient: EnjoliClient,
) : PluginFactory<EnjoliPlugin>(pluginService) {
    override fun create(): EnjoliPlugin {
        return EnjoliPlugin(enjoliClient)
    }
}
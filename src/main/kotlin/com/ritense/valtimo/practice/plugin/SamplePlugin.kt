package com.ritense.valtimo.practice.plugin

import com.ritense.plugin.annotation.Plugin
import com.ritense.plugin.annotation.PluginAction
import com.ritense.plugin.annotation.PluginProperty
import com.ritense.processlink.domain.ActivityTypeWithEventName
import org.camunda.bpm.engine.delegate.DelegateExecution
import java.net.URI

@Plugin(
    key = "sample",
    title = "Sample Plugin",
    description = "Sample plugin description",
)
class SamplePlugin(
    val sampleClient: SampleClient,
) {
    @PluginProperty(key = "url", secret = false)
    lateinit var url: URI

    @PluginAction(
        key = "sample-action",
        title = "Sample action",
        description = "Sample plugin action",
        activityTypes = [ActivityTypeWithEventName.SERVICE_TASK_START],
    )
    fun samplePrinter(
        execution: DelegateExecution,
    ) {
        sampleClient.hello()
    }
}
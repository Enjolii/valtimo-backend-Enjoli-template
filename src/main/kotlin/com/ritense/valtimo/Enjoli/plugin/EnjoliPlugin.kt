package com.ritense.valtimo.Enjoli.plugin

import com.ritense.plugin.annotation.Plugin
import com.ritense.plugin.annotation.PluginAction
import com.ritense.plugin.annotation.PluginActionProperty
import com.ritense.processlink.domain.ActivityTypeWithEventName
import org.camunda.bpm.engine.delegate.DelegateExecution

@Plugin(
    key = "enjoli",
    title = "Enjoli Plugin",
    description = "Dit is mijn zelf gemaakte plugin die gebruik maakt van mijn eigen objects api client",
)
class EnjoliPlugin(private val enjoliClient: EnjoliClient) {

    @PluginAction(
        key = "enjoli-action",
        title = "Enjoli action",
        description = "Enjoli plugin action",
        activityTypes = [ActivityTypeWithEventName.SERVICE_TASK_START],
    )
    fun createObject(
        execution: DelegateExecution,
        @PluginActionProperty apiUrl: String,
        @PluginActionProperty type: String,
        @PluginActionProperty gamedata: Any,
        @PluginActionProperty filmdata: Any,
    ) {
        if (type == "game") {
            enjoliClient.createObject(apiUrl, type, gamedata)
        } else {
            val filmData = filmdata as? Map<String, Any>
            val updatedFilmData = filmData?.toMutableMap()?.apply {
                (this["cast"] as? String)?.let {
                    this["cast"] = it.split(",").map(String::trim)
                }
            }
            println("Updated film data: $updatedFilmData")
            enjoliClient.createObject(apiUrl, type, updatedFilmData ?: filmdata)
        }
    }

    @PluginAction(
        key = "print-action",
        title = "Print Action",
        description = "Print plugin action",
        activityTypes = [ActivityTypeWithEventName.SERVICE_TASK_START],
    )
    fun printAction(
        execution: DelegateExecution,
        @PluginActionProperty print: Any,
    ) {
        enjoliClient.print(print)
    }
}
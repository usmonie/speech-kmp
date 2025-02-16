package com.usmonie.compass.core

import androidx.collection.MutableScatterMap
import androidx.collection.ObjectList
import androidx.collection.ScatterMap
import androidx.collection.emptyScatterMap
import androidx.collection.mutableScatterMapOf
import com.usmonie.compass.core.ui.Screen
import com.usmonie.compass.core.ui.ScreenFactory
import com.usmonie.compass.core.ui.ScreenId
import kotlin.jvm.JvmInline

@JvmInline
public value class GraphId(public val id: String)

public open class NavigationGraphFactory(
    public val id: GraphId,
    public val screensFactories: ScatterMap<ScreenId, ScreenFactory>,
    public val rootScreenFactoryId: ScreenId,
    private val builder: NavigationGraph.() -> Unit = {}
) {
    public open operator fun invoke(
        params: ScatterMap<String, String> = emptyScatterMap(),
        extra: Extra? = null,
        storeInBackstack: Boolean
    ): NavigationGraph {
        return NavigationGraph(
            id,
            rootScreenFactoryId,
            screensFactories,
            extra,
            params,
        ).apply(builder)
    }
}

public data class NavigationGraph(
    val id: GraphId,
    val rootScreenFactory: ScreenFactory,
    val extra: Extra? = null,
    val params: ScatterMap<String, String> = emptyScatterMap(),
) {
    private val screenFactories: MutableScatterMap<ScreenId, ScreenFactory> =
        mutableScatterMapOf(rootScreenFactory.id to rootScreenFactory)

    public constructor(
        id: GraphId,
        rootScreenFactoryId: ScreenId,
        screenFactories: ScatterMap<ScreenId, ScreenFactory>,
        extra: Extra? = null,
        params: ScatterMap<String, String> = emptyScatterMap(),
    ) : this(
        id,
        screenFactories.getOrElse(
            rootScreenFactoryId
        ) { throw IllegalArgumentException("Not found factory for root screen with id: $rootScreenFactoryId") },
        extra,
        params,
    ) {
        this.screenFactories.remove(rootScreenFactoryId)
        this.screenFactories.putAll(screenFactories)
    }

    public fun register(factory: ScreenFactory) {
        screenFactories[factory.id] = factory
    }

    public fun findScreen(
        screenId: ScreenId,
        storeInBackstack: Boolean,
        params: ScatterMap<String, String>?,
        extras: Extra?,
        sharedElements: ObjectList<SharedElement>
    ): Screen? {
        val factory = screenFactories[screenId] ?: return null
        return factory(storeInBackstack, params, extras)
    }
}

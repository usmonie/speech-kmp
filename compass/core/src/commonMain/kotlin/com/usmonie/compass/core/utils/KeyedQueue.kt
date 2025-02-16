package com.usmonie.compass.core.utils

public interface KeyedStack<K : Any, V : Any> : Collection<V> {
    public val keys: Set<K>
    public val entries: Set<Map.Entry<K, V>>

    public fun peek(): V
    public fun peekKey(): K
    public fun peekOrNull(): V?
    public fun peekKeyOrNull(): K?
    public fun peekPast(): V?
    public fun get(key: K): V?
    public fun containsKey(key: K): Boolean
}

public interface MutableKeyedStack<K : Any, V : Any> : KeyedStack<K, V> {
    public fun put(key: K, value: V)
    public fun putAll(from: Map<K, V>)
    public fun pop(): V
    public fun popKey(): Pair<K?, List<V>>
    public fun remove(): V
    public fun removeOrNull(): V?
    public fun removeByKey(key: K): V?
    public fun removeUntilKey(key: K): Boolean
    public fun removeUntilValue(value: V): Boolean
    public fun removeUntil(predicate: (K, V) -> Boolean): Boolean
    public fun clear()
}

public class LinkedStack<K : Any, V : Any> : MutableKeyedStack<K, V> {
    private class Node<K : Any, V : Any>(
        val key: K,
        val value: V,
        var prev: Node<K, V>? = null,
        var next: Node<K, V>? = null
    )

    private var head: Node<K, V>? = null
    private var tail: Node<K, V>? = null
    private val keyToNode = mutableMapOf<K, Node<K, V>>()

    override val size: Int get() = keyToNode.size
    override val keys: Set<K> get() = keyToNode.keys
    override val entries: Set<Map.Entry<K, V>>
        get() = keyToNode.entries.map { MapEntry(it.key, it.value.value) }.toSet()

    override fun peek(): V = tail?.value ?: throw NoSuchElementException()
    override fun peekKey(): K = tail?.key ?: throw NoSuchElementException()
    override fun peekOrNull(): V? = tail?.value
    override fun peekKeyOrNull(): K? = tail?.key
    override fun peekPast(): V? = tail?.prev?.value
    override fun get(key: K): V? = keyToNode[key]?.value
    override fun containsKey(key: K): Boolean = key in keyToNode

    override fun put(key: K, value: V) {
//        val existingNode = keyToNode[key]
//        if (existingNode != null) {
//            existingNode.prev?.next = existingNode.next
//            existingNode.next?.prev = existingNode.prev
//            if (tail == existingNode) tail = existingNode.prev
//            if (head == existingNode) head = existingNode.next
//        }

        val newNode = Node(key, value)
        keyToNode[key] = newNode

        if (head == null) {
            head = newNode
            tail = newNode
        } else {
            newNode.prev = tail
            tail?.next = newNode
            tail = newNode
        }
    }

    override fun putAll(from: Map<K, V>) {
        from.forEach { (key, value) -> put(key, value) }
    }

    override fun pop(): V {
        return remove()
    }

    override fun popKey(): Pair<K?, List<V>> {
        val lastKey = tail?.key ?: return Pair(null, emptyList())
        val removedValues = mutableListOf<V>()
        var current = tail

        while (current != null && current.key == lastKey) {
            removedValues.add(current.value)
            val prev = current.prev
            removeNode(current)
            current = prev
        }

        return Pair(lastKey, removedValues)
    }

    override fun remove(): V {
        val node = tail ?: throw NoSuchElementException()
        return removeNode(node)
    }

    override fun removeOrNull(): V? {
        val node = tail ?: return null
        return removeNode(node)
    }

    override fun removeByKey(key: K): V? {
        val node = keyToNode[key] ?: return null
        return removeNode(node)
    }

    override fun removeUntilKey(key: K): Boolean {
        val targetNode = keyToNode[key] ?: return false
        while (tail != null && tail != targetNode) {
            removeNode(tail!!)
        }
        return true
    }

    override fun removeUntilValue(value: V): Boolean {
        var found = false
        var current = tail

        while (current != null && !found) {
            if (current.value == value) {
                found = true
            } else {
                val prev = current.prev
                removeNode(current)
                current = prev
            }
        }

        return found
    }

    override fun removeUntil(predicate: (K, V) -> Boolean): Boolean {
        var success = false
        while (tail != null && !predicate(tail!!.key, tail!!.value)) {
            removeNode(tail!!)
            success = true
        }
        return success
    }

    private fun removeNode(node: Node<K, V>): V {
        keyToNode.remove(node.key)

        val prev = node.prev
        val next = node.next

        prev?.next = next
        next?.prev = prev

        if (node == head) head = next
        if (node == tail) tail = prev

        return node.value
    }

    override fun clear() {
        head = null
        tail = null
        keyToNode.clear()
    }

    override fun isEmpty(): Boolean = size == 0
    override fun containsAll(elements: Collection<V>): Boolean =
        elements.all { value -> keyToNode.any { it.value.value == value } }
    override fun contains(element: V): Boolean =
        keyToNode.any { it.value.value == element }

    override fun iterator(): Iterator<V> = object : Iterator<V> {
        private var current = head

        override fun hasNext(): Boolean = current != null
        override fun next(): V {
            val value = current?.value ?: throw NoSuchElementException()
            current = current?.next
            return value
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is LinkedStack<*, *>) return false
        if (size != other.size) return false

        // Проверяем типы дженериков
        if (other.head?.key?.let { it::class } != head?.key?.let { it::class }) return false
        if (other.head?.value?.let { it::class } != head?.value?.let { it::class }) return false

        // Сравниваем последовательно все элементы
        var thisNode = head
        var otherNode = other.head as Node<*, *>?

        while (thisNode != null && otherNode != null) {
            if (thisNode.key != otherNode.key || thisNode.value != otherNode.value) {
                return false
            }
            thisNode = thisNode.next
            otherNode = otherNode.next
        }

        return thisNode == null && otherNode == null
    }

    override fun hashCode(): Int {
        var result = 1
        var current = head

        while (current != null) {
            result = 31 * result + current.key.hashCode()
            result = 31 * result + current.value.hashCode()
            current = current.next
        }

        return result
    }

    override fun toString(): String {
        return buildString {
            append("LinkedStack(")
            var current = head
            var first = true
            while (current != null) {
                if (!first) append(", ")
                append("[${current.key}=${current.value}]")
                first = false
                current = current.next
            }
            append(")")
        }
    }

    private class MapEntry<K : Any, V : Any>(
        override val key: K,
        override val value: V
    ) : Map.Entry<K, V>
}

package tgo1014.placeholder.data.base

import androidx.lifecycle.LiveData

interface BaseRepository<T> {
    fun add(vararg item: T)
    fun update(vararg item: T)
    fun delete(vararg item: T)
    fun get(): LiveData<List<T>>
}
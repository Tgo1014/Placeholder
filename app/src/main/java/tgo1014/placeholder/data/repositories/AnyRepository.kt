package tgo1014.placeholder.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.experimental.launch
import tgo1014.placeholder.data.base.BaseRepository

class AnyRepository : BaseRepository<Any> {

    override fun add(vararg item: Any) {
        launch { }
    }

    override fun update(vararg item: Any) {
        launch { }
    }

    override fun delete(vararg item: Any) {
        launch { }
    }

    override fun get(): LiveData<List<Any>> {
        launch { }
        return MutableLiveData<List<Any>>()
    }

}
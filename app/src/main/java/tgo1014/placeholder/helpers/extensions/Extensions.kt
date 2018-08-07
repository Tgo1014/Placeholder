package tgo1014.placeholder.helpers.extensions

import android.content.Context
import android.util.Base64
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Any.convertToJson(): String = Gson().toJson(this)

fun Any.toBase64(): String {
    val str = this.convertToJson()
    return Base64.encodeToString(str.toByteArray(), Base64.URL_SAFE)
}

inline fun <reified T> Gson.fromJson(json: String): T {
    return this.fromJson<T>(json, object : TypeToken<T>() {}.type)
}

fun String.fromBase64() = String(Base64.decode(this, Base64.URL_SAFE))

inline fun <reified T : ViewModel> Fragment.getViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }
    return ViewModelProviders.of(this, vmFactory)[T::class.java]
}

infix fun Int.dpToPixel(context: Context): Int {
    val metrics = context.resources.displayMetrics
    return this * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
}

inline fun <reified T> List<T>?.hasAnyElementsFrom(otherList: List<T>?, compare: (T, T) -> Boolean): Boolean {
    if (this == null || otherList == null)
        return false
    this.forEach { aItem ->
        if (otherList.any { bItem -> compare(aItem, bItem) })
            return true
    }
    return false
}
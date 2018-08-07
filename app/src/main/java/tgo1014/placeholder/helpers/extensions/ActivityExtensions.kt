package tgo1014.placeholder.helpers.extensions

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar


fun AppCompatActivity.snack(message: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(findViewById(android.R.id.content), message, length).show()
}

inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }
    return ViewModelProviders.of(this, vmFactory)[T::class.java]
}

fun AppCompatActivity.startActivity(activityToOpen: Class<*>, parameters: Bundle? = null) {
    val intent = Intent(this, activityToOpen)
    if (parameters != null) intent.putExtras(parameters)
    startActivity(intent)
}
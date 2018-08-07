package tgo1014.placeholder.helpers.extensions

import android.animation.ObjectAnimator
import android.view.View
import android.widget.TextView


fun View.show(show: Boolean = true) {
    visibility = if (show) View.VISIBLE else View.GONE
}

fun View.invisible(invisible: Boolean = true) {
    visibility = if (!invisible) View.VISIBLE else View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.toggle() {
    this.show(this.visibility != View.VISIBLE)
}

fun View.animateElevation(value: Float) =
        ObjectAnimator.ofFloat(this, "elevation", this.elevation, value)
                .apply { duration = 150 }
                .run { start() }


fun TextView.getTxt() = this.text.toString()
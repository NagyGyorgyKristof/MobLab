package hu.bme.aut.android.kotifydemo.ui.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

inline fun ImageView.load(url: String, requestOptions: RequestOptions? = null) {
    loadGlideRequest(
        loadCall = { load(url) },
        requestOptions = requestOptions
    )
}

@Suppress("DeprecatedCallableAddReplaceWith")
@Deprecated(message = "Do not call this method directly, use `load` instead", level = DeprecationLevel.WARNING)
inline fun ImageView.loadGlideRequest(
    loadCall: RequestManager.() -> RequestBuilder<Drawable>,
    requestOptions: RequestOptions? = null
) {
    Glide.with(this)
        .loadCall()
        .apply {
            if (requestOptions != null) {
                apply(requestOptions)
            }
        }
        .into(this)
}

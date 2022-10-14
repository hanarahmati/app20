package co.fanavari.myapplication20.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Urls(
    val raw: String,
    val regular: String,
    val thumb: String
): Parcelable {

}

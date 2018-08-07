package tgo1014.placeholder.data.repositories.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import tgo1014.placeholder.helpers.extensions.convertToJson

abstract class BaseTypeConverter<T> {

    @TypeConverter
    fun from(item: T?): String? {
        return item?.convertToJson()
    }

    @TypeConverter
    fun to(json: String?): T? {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson(json, type)
    }
}
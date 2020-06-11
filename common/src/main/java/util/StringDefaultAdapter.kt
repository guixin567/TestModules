package util

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter


class StringDefaultAdapter : TypeAdapter<String>() {
    override fun write(out: JsonWriter?, value: String?) {
        if (value == null) {
            out?.value("")
            return
        }
        out?.value(value)
    }

    override fun read(`in`: JsonReader?): String? {
        try {
            if (`in`?.peek() == JsonToken.NULL) {
                `in`.nextNull()
                return ""
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
        return `in`?.nextString()
    }

}
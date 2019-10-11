package com.shawn.wanandroid.utils

import android.content.Context
import android.content.SharedPreferences
import com.shawn.wanandroid.app.App
import java.io.*
import java.net.URLDecoder
import java.net.URLEncoder
import kotlin.reflect.KProperty

/**
 * 作者：create by @author{ YSH } on 2019/10/11
 * 描述: kotlin委托属性+SharedPreference实例
 * 修改备注:
 */
class PreferenceUtil<T>(val name: String, private val default: T) {

    companion object {
        private val file_name = "wan_android_sp"
    }

    private val prefs: SharedPreferences by lazy {
        App.context.getSharedPreferences(file_name, Context.MODE_PRIVATE)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getSharedPreferences(name, default)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putSharedPreferences(name, value)
    }

    private fun getSharedPreferences(name: String, default: T): T = with(prefs) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is String -> getString(name, default)
            is Float -> getFloat(name, default)
            else -> deSerialization(getString(name, serialize(default)))
        }
        return res as T
    }

    private fun putSharedPreferences(name: String, value: T) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> putString(name, serialize(value))
        }.apply()
    }

    /**
     * 序列化对象
     */
    @Throws(IOException::class)
    private fun <A> serialize(obj: A): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val objectOutputStream = ObjectOutputStream(byteArrayOutputStream)
        objectOutputStream.writeObject(obj)
        var serStr = byteArrayOutputStream.toString("ISO-8859-1")
        serStr = URLEncoder.encode(serStr, "UTF-8")
        objectOutputStream.close()
        byteArrayOutputStream.close()
        return serStr
    }

    /**
     * 反序列化对象
     */
    @Throws(IOException::class, ClassNotFoundException::class)
    private fun <A> deSerialization(str: String): A {
        val readStr = URLDecoder.decode(str, "UTF-8")
        val byteArrayInputStream = ByteArrayInputStream(readStr.toByteArray(charset("ISO-8859-1")))
        val objectInputStream = ObjectInputStream(byteArrayInputStream)
        val obj = objectInputStream.readObject() as A
        objectInputStream.close()
        byteArrayInputStream.close()
        return obj
    }
}
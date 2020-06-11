package route

import android.app.Activity
import android.net.Uri
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import com.zhengyinuo.base.extension.default

/**
 * 支持Scheme协议
 *
 * deepLink:
 *  格式：scheme://host/path
 *  实例：link://test/list
 * 页面跳转:
 *  格式：/组名/类名
 *  实例：/detail/detail/
 * 发送事件:
 *  格式：/事件/事件名
 *  实例：/event/collect
 */
class Router private constructor(val postcard: Postcard, val data: MutableMap<String, Any?>) {


    fun withString(key: String, value: String?): Router {
        data[key] = value.default()
        postcard.withString(key, value)
        return this
    }

    fun withInt(key: String, value: Int): Router {
        data[key] = value
        postcard.withInt(key, value)
        return this
    }

    fun withObject(key: String, value: Any): Router {
        data[key] = value
        postcard.withObject(key, value)
        return this
    }

    fun withMap(key: String, value: Map<String, Any?>): Router {
        data[key] = value
        addParams(postcard, value)
        return this
    }

    fun addFlag(flags: Int): Router {
        postcard.addFlags(flags)
        return this
    }


    fun push() {
        postcard.withObject(KEY_ORIGIN_DATA, data).navigation()
    }

    fun push(activity: Activity, requestCode: Int) {
        postcard.withObject(KEY_ORIGIN_DATA, data).navigation(activity, requestCode)
    }

    companion object {
        const val KEY_ORIGIN_PATH = "origin_path"
        const val KEY_ORIGIN_DATA = "origin_data"
        const val Event = "event"

        fun build(uriString: String?): Router {
            val data = mutableMapOf<String, Any?>()
            val uri = Uri.parse(uriString)
            val host = uri.host
            val scheme = uri.scheme
            val originalPath = uri.path.default()
            var path = originalPath

            if (host.isNullOrEmpty()) {
                if (path.startsWith(Event)) {
                    path = Path.event_path
                } else {

                }
            }
            val postcard = ARouter.getInstance().build(path)
            postcard.withString(KEY_ORIGIN_PATH, originalPath)
            addParams(postcard, data)
            return Router(postcard = postcard, data = data)
        }

        private fun addParams(postcard: Postcard, value: Map<String, Any?>) {
            value.forEach {
                when (val value = it.value) {
                    is String -> postcard.withString(it.key, value)
                    is Int -> postcard.withInt(it.key, value)
                    is Long -> postcard.withLong(it.key, value)
                    is Float -> postcard.withFloat(it.key, value)
                    is Double -> postcard.withDouble(it.key, value)
                    null -> postcard.withString(it.key, value)
                    else -> postcard.withObject(it.key, value)
                }
            }
        }

    }


}
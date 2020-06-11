package route.interceptor

import android.content.Context
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.annotation.Interceptor
import com.alibaba.android.arouter.facade.callback.InterceptorCallback
import com.alibaba.android.arouter.facade.template.IInterceptor
import com.google.gson.reflect.TypeToken
import route.Path
import route.Router
import route.bus.LiveBus
import util.GsonUtil

@Interceptor(priority = 1, name = "事件拦截器")
class EventInterceptor : IInterceptor {
    override fun process(postcard: Postcard?, callback: InterceptorCallback?) {
        if (postcard?.path == Path.event_path) {
            val path = postcard.extras.getString(Router.KEY_ORIGIN_PATH)
            val data = postcard.extras.getString(Router.KEY_ORIGIN_DATA)
            val map =
                if (data.isNullOrEmpty()) mutableMapOf<String, Any>() else GsonUtil.gson.fromJson(
                    data,
                    object : TypeToken<HashMap<String, Any>>() {}.type
                )

            if (!path.isNullOrEmpty()) {
                LiveBus.with(path).postValue(map)
            }
            callback?.onInterrupt(null)
        } else {
            callback?.onContinue(postcard)
        }
    }

    override fun init(context: Context?) {

    }


}
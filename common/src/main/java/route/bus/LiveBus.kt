package route.bus

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import java.util.concurrent.ConcurrentHashMap

class LiveBus private constructor() {
    private val busMap by lazy { ConcurrentHashMap<String, BusLiveData<*>>() }

    private fun <T> bus(channel: String, clazz: Class<T>) =
        busMap.getOrPut(channel) { BusLiveData<T>() }

    /**
     * 订阅，确保一个channel 只对应一种class 否则会崩溃
     */
    fun <T> with(channel: String, clazz: Class<T>) = bus(channel, clazz) as BusLiveData<T>

    /**
     * 发送事件 类型任意 但是得保证跟channel一一对应
     */
    fun with(channel: String) = with(channel, Any::class.java)


    companion object {

        const val START_VERSION = -1

        @Volatile
        private var instance: LiveBus? = null

        @JvmStatic
        fun getInstance() = instance ?: synchronized(this) {
            instance
                ?: LiveBus().also { instance = it }
        }

        /**
         * 订阅，确保一个channel 只对应一种class 否则会崩溃
         */
        fun <T> with(channel: String, clazz: Class<T>) = getInstance().with(channel, clazz)

        /**
         * 发送事件 类型任意 但是得保证跟channel一一对应
         */
        fun with(channel: String) = getInstance().with(channel)

        private val lifecycleRegistry: LifecycleRegistry by lazy {
            LifecycleRegistry(lifecycleOwner).apply {
                currentState = Lifecycle.State.RESUMED
            }
        }

        /**
         * 使用这个来做全局生命周期的监听
         * 不要在普通的activity fragment中使用 可能会造成内存泄漏
         */
        val lifecycleOwner = LifecycleOwner {
            lifecycleRegistry
        }

    }

}
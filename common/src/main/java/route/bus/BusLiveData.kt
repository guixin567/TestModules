package route.bus

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class BusLiveData<T> : MutableLiveData<T>() {

    var mVersion = -1

    var mStickyEvent: T? = null

    /**
     * stick ：是否接收粘性事件，即事件先产生，后监听
     */
    private fun observe(owner: LifecycleOwner, observer: Observer<in T>, sticky: Boolean) {
        super.observe(owner, ObserverWrapper(observer, this, sticky))
    }

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        observe(owner, observer, false)
    }

    /**
     * 发送普通事件
     */
    override fun setValue(value: T) {
        mVersion++
        super.setValue(value)
    }

    override fun postValue(value: T) {
        mVersion++
        super.postValue(value)
    }

    /**
     * 发送粘性事件
     */
    fun setValueSticky(value: T) {
        mStickyEvent = value
        setValue(value)
    }

    fun postValueSticky(value: T) {
        mStickyEvent = value
        postValue(value)
    }

    fun removeSticky() {
        mStickyEvent = null
    }
}
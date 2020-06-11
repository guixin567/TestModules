package route.bus

import androidx.lifecycle.Observer

open class ObserverWrapper<T>(
    val observer: Observer<in T>,
    val liveData: BusLiveData<T>,
    val sticky: Boolean
) : Observer<T> {

    // 通过标志位过滤旧数据
    private var mLastVersion = liveData.mVersion

    override fun onChanged(t: T?) {

        if (mLastVersion >= liveData.mVersion) {
            // 回调粘性事件
            if (sticky && liveData.mStickyEvent != null) {
                observer.onChanged(liveData.mStickyEvent)
            }
            return
        }
        mLastVersion = liveData.mVersion

        observer.onChanged(t)
    }
}
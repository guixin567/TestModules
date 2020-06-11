package debug

import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.me.R
import kotlinx.android.synthetic.main.activity_test_me.*
import route.routeToMe

class TestMeActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_test_me
    override fun initListener() {
        tv_test.setOnClickListener {
            routeToMe()
        }
    }
}

package debug

import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.detail.R
import kotlinx.android.synthetic.main.activity_test_detail.*
import route.routeToDetail

class TestDetailActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_test_detail
    override fun initListener() {
        tv_test.setOnClickListener {
            routeToDetail("2222")
        }
    }
}

package debug

import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.list.R
import kotlinx.android.synthetic.main.activity_test_list.*
import route.routeToList

class TestListActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_test_list
    override fun initListener() {
        tv_test.setOnClickListener {
            routeToList("333")
        }
    }
}

package debug

import android.content.Intent
import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.list.R
import com.zhengyinuo.list.ui.ListActivity
import kotlinx.android.synthetic.main.activity_test_list.*
import route.IntentKey

class TestListActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_test_list
    override fun initListener() {
        tv_test.setOnClickListener {
            startActivity(Intent(this, ListActivity::class.java).apply {
                putExtra(IntentKey.categoryId, "333")
            })
        }
    }
}

package debug

import android.content.Intent
import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.detail.R
import com.zhengyinuo.detail.ui.DetailActivity
import kotlinx.android.synthetic.main.activity_test_detail.*
import route.IntentKey

class TestDetailActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_test_detail
    override fun initListener() {
        tv_test.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java).apply {
                putExtra(IntentKey.articleId, "2222")
            })
        }
    }
}

package debug

import android.content.Intent
import com.zhengyinuo.base.base.BaseActivity
import com.zhengyinuo.me.R
import com.zhengyinuo.me.main.ui.MainActivity
import kotlinx.android.synthetic.main.activity_test_me.*

class TestMeActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.activity_test_me
    override fun initListener() {
        tv_test.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}

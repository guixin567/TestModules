package util

import com.zhengyinuo.base.extension.default
import com.zhengyinuo.common.list.InfoBean
import com.zhengyinuo.common.me.BannerItemBean
import com.zhengyinuo.common.me.HomeBannerBean
import com.zhengyinuo.common.me.HomeListBean

class DataUtils {
    companion object {
        private const val imageUrl1 =
            "http://i3.letvimg.com/lc07_crawler/201712/15/22/29/151334818985009-1.jpg"
        private const val imageUrl2 =
            "http://img0.imgtn.bdimg.com/it/u=1125723489,855057867&fm=26&gp=0.jpg"

        fun getHomeBannerBean(): HomeBannerBean {
            return HomeBannerBean(
                banners = mutableListOf(
                    BannerItemBean(imageUrl1, "1111"),
                    BannerItemBean(imageUrl2, "2222")
                )
            )
        }

        fun getHomeListBean(): HomeListBean {
            return HomeListBean(getListInfoItems())
        }

        fun getListInfoItemsWithCategoryId(categoryId: String?): MutableList<InfoBean> {
            return getListInfoItems().map {
                it.categoryId == categoryId.default()
                it.title = "${it.title}分类ID:${categoryId}"
                it
            }.toMutableList()
        }

        fun getListInfoItems(): MutableList<InfoBean> {
            return mutableListOf(
                InfoBean(
                    "测试标题111",
                    "111111111测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容",
                    "1111"
                ),
                InfoBean(
                    "测试标题222",
                    "222222222测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容",
                    "2222"
                ),
                InfoBean(
                    "测试标题333",
                    "333333测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容",
                    "3333"
                ),
                InfoBean(
                    "测试标题444",
                    "444444测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容",
                    "4444"
                ),
                InfoBean(
                    "测试标题555",
                    "555555555测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容",
                    "5555"
                ),
                InfoBean(
                    "测试标题777",
                    "777777777测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容",
                    "6666"
                ),
                InfoBean("测试标题888", "测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容", "7777"),
                InfoBean("测试标题999", "测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容", "8888"),
                InfoBean("测试标题666", "测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容", "1111"),
                InfoBean("测试标题666", "测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容", "1111"),
                InfoBean("测试标题666", "测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容", "1111"),
                InfoBean("测试标题666", "测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容", "1111"),
                InfoBean("测试标题666", "测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容测试内容", "1111"),
                InfoBean("测试标题777", "测试内容测试内容测试内测试内容测试内容测试内容测试内容测试内容测试内容容测试内容测试内容测试内容", "1111")
            )
        }
    }
}
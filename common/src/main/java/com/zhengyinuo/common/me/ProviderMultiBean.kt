package com.zhengyinuo.common.me

open class ProviderMultiBean(var type: Int) {
    companion object {
        const val bannerType = 1                //banner类型
        const val fixCategoryType = 2           //固定分类类型
        const val horizontalCategoryType = 3    //水平分类类型
        const val listType = 4                  //列表类型
    }
}
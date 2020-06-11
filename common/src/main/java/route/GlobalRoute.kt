package route

//主页面
fun routeToMe() {
    Router.build(Path.me_main).push()
}

//列表页
fun routeToList(categoryId: String?) {
    Router.build(Path.list_list).withString(Param.categoryId, categoryId).push()
}

//详情页
fun routeToDetail(articleId: String?) {
    Router.build(Path.detail_detail).withString(Param.articleId, articleId).push()
}
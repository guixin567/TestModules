package com.zhengyinuo.common.list.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zhengyinuo.base.extension.dp2px

class GridItemDecoration(var space: Int = 12.dp2px().toInt()) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val layoutManager = parent.layoutManager
        if (layoutManager is GridLayoutManager) {
            outRect.top = space
            if (position % 2 == 0) {
                outRect.left = space
                outRect.right = space / 2
            } else {
                outRect.left = space / 2
                outRect.right = space
            }

        }
    }
}
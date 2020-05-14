package eu.kanade.tachiyomi.ui2.base.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class RockViewPager(context: Context, attributeSet: AttributeSet) : ViewPager(context, attributeSet) {
    var smoothScrollEnabled = false
    var swipeEnabled = false

    override fun setCurrentItem(item: Int) {
        super.setCurrentItem(item, smoothScrollEnabled)
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        if (this.swipeEnabled) {
            return super.onTouchEvent(ev)
        }
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        if (this.swipeEnabled) {
            return super.onInterceptTouchEvent(ev)
        }
        return false
    }
}

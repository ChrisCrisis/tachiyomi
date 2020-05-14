package eu.kanade.tachiyomi.ui2.base.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
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

    class PagerAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager) {
        val favoritesFragment = Fragment()
        val recentFragment = Fragment()
        val discoverFragment = Fragment()
        val settingsFragment = Fragment()
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> favoritesFragment
                1 -> recentFragment
                2 -> discoverFragment
                3 -> settingsFragment
                else -> throw IllegalStateException("Position is out of viewPager adapter bounds")
            }
        }

        override fun getCount(): Int {
            return 4
        }
    }
}

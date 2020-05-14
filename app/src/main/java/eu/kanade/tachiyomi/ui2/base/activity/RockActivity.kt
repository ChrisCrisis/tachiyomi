package eu.kanade.tachiyomi.ui2.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import eu.kanade.tachiyomi.R
import kotlinx.android.synthetic.main.activity_rock.*

class RockActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rock)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.page_favorites -> {
                    rock_view_pager.currentItem = 0
                    true
                }
                R.id.page_recent -> {
                    rock_view_pager.currentItem = 1
                    true
                }
                R.id.page_discover -> {
                    rock_view_pager.currentItem = 2
                    true
                }
                R.id.page_settings -> {
                    rock_view_pager.currentItem = 3
                    true
                }
                else -> {
                    false
                }
            }
        }
    }
}

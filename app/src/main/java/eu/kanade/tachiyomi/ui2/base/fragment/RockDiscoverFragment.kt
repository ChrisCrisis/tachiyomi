package eu.kanade.tachiyomi.ui2.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import eu.kanade.tachiyomi.R

open class RockDiscoverFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_rock_discover, container, false)
    }
}

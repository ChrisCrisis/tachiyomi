package eu.kanade.tachiyomi.ui2.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.ui2.viewModel.DiscoverViewModel

open class RockDiscoverFragment : Fragment() {

    private lateinit var vm: DiscoverViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        activity?.application?.let {
            vm = DiscoverViewModel(it)
        }
        searchTowerOfGod()
        return inflater.inflate(R.layout.fragment_rock_discover, container, false)
    }

    private fun searchTowerOfGod() {
        vm.searchFor("Tower of God").observe(
            viewLifecycleOwner,
            Observer { results ->
                if (results.isEmpty()) {
                    Toast.makeText(context, "Nothing found yet", Toast.LENGTH_LONG).show()
                    return@Observer
                }
                results.first().let {
                    Toast.makeText(context, it.title, Toast.LENGTH_LONG).show()
                }
            }
        )
    }
}

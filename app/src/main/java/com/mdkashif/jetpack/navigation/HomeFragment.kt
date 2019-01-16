package com.mdkashif.jetpack.navigation

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.mdkashif.jetpack.navigation.HomeFragmentDirections
import com.mdkashif.jetpack.navigation.R

/**
 * Fragment used to show how to navigate to another destination
 */
class HomeFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigateDestinationButton = view.findViewById<Button>(R.id.navigate_destination_button)
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        navigateDestinationButton.setOnClickListener{
            findNavController().navigate(R.id.flow_step_one_dest, null, options)
        }

        val navigateActionButton = view.findViewById<Button>(R.id.navigate_action_button)
        navigateActionButton.setOnClickListener{
            val action = HomeFragmentDirections.nextAction()
            action.setFlowStepNumber(2)
            findNavController().navigate(action)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }
}

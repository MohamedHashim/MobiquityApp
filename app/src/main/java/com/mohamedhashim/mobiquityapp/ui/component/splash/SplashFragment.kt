package com.mohamedhashim.mobiquityapp.ui.component.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mohamedhashim.mobiquityapp.R
import kotlinx.coroutines.*

/**
 * Created by Mohamed Hashim on 4/12/2021.
 */
class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    //TODO addd simple ui test to oopen details screen
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        MainScope().launch {
            delay(2000L)
            findNavController().navigate(
                R.id.categoriesFragment
            )
        }
    }
}
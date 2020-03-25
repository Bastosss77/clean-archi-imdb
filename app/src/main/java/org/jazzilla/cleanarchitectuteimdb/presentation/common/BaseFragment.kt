package org.jazzilla.cleanarchitectuteimdb.presentation.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

class BaseFragment(@LayoutRes private val layout: Int) : Fragment() {
    protected lateinit var dataBinding: ViewDataBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, layout, container, false)

        return dataBinding.root
    }

    fun navigateBack() {}

    fun navigate(@IdRes to: Int) {}
}
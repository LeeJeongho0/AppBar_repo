package com.example.appbar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CustomViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragmenList = ArrayList<Fragment>()

    override fun getItemCount() : Int = fragmenList.size

    override fun createFragment(position: Int): Fragment = fragmenList.get(position)

    fun addListFragment(fragment: Fragment){
        this.fragmenList.add(fragment)
    }
}
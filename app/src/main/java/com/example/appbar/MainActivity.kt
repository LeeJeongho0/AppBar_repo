package com.example.appbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appbar.databinding.ActivityMainBinding
import com.example.appbar.databinding.UsertabButtonBinding
import com.example.viewpagertablayout.ThreeFragment
import com.example.viewpagertablayout.TwoFragment
import com.example.viewpagertablayoutpro.OneFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var customViewPagerAdapter: CustomViewPagerAdapter
    lateinit var tabTitleList:MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        customViewPagerAdapter = CustomViewPagerAdapter(this)
        customViewPagerAdapter.addListFragment(OneFragment())
        customViewPagerAdapter.addListFragment(TwoFragment())
        customViewPagerAdapter.addListFragment(ThreeFragment())
        tabTitleList = mutableListOf("car", "home", "air")
        binding.viewpager2.adapter = customViewPagerAdapter

        TabLayoutMediator(binding.tablayout,binding.viewpager2){ tab, position ->
            tab.text = tabTitleList.get(position)
            tab.setCustomView(tabCustomView(position))
        }.attach()
        binding.eftb.setOnClickListener {
            Toast.makeText(applicationContext,"확장텝이다",Toast.LENGTH_SHORT).show()
        }
    }
    fun tabCustomView(position:Int): View {
        val binding = UsertabButtonBinding.inflate(layoutInflater)
        when(position){
            0 -> binding.ivIcon.setImageResource(R.drawable.car_24)

            1 -> binding.ivIcon.setImageResource(R.drawable.house_24)

            2 -> binding.ivIcon.setImageResource(R.drawable.car_24)
        }
        binding.tvTabName.text = tabTitleList.get(position)
        return binding.root
    }
}
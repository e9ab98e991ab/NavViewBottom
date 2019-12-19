package com.e9ab98e991ab.nav

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.e9ab98e991ab.nav.databinding.ActivityMainBinding
import com.e9ab98e991ab.nav.fragment.ClassificationFragment
import com.e9ab98e991ab.nav.fragment.HomeFragment
import com.e9ab98e991ab.nav.fragment.MineFragment
import com.e9ab98e991ab.nav.fragment.TopicFragment
import com.e9ab98e991ab.nav.moduler.NavItem
import com.google.common.collect.Lists
import com.jkb.fragment.rigger.annotation.Puppet
import com.jkb.fragment.rigger.rigger.Rigger


@Puppet(containerViewId = R.id.main_container, stickyStack = true)
class MainActivity : AppCompatActivity() {
    private var mainBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        setTitle(R.string.app_name_kotlin)
        init()
    }

    private fun init() {
        mainBinding!!.navContainer.addItem(
            Lists.newArrayList(
                NavItem(
                    R.string.home,
                    R.raw.icon_home,
                    R.color.blue
                ),
                NavItem(
                    R.string.classification,
                    R.raw.icon_home,
                    R.color.red
                ),
                NavItem(
                    R.string.topic,
                    R.raw.icon_home,
                    R.color.yellow
                ),
                NavItem(
                    R.string.mine,
                    R.raw.icon_home,
                    R.color.green
                )
            )
        )
        mainBinding!!.navContainer.setCustomSelectedPosition(0)
        Rigger.getRigger(this).startFragment(HomeFragment.newInstance())
        mainBinding!!.navContainer.setOnItemClickListener { newPosition: Int, oldPosition: Int ->
            Toast.makeText(
                this,
                "newPosition:$newPosition oldPosition:$oldPosition",
                Toast.LENGTH_SHORT
            ).show()
            mainBinding!!.navContainer.setCustomSelectedPosition(newPosition)
            when (newPosition) {
                0 -> Rigger.getRigger(this).startFragment(HomeFragment.newInstance())
                1 -> Rigger.getRigger(this).startFragment(ClassificationFragment.newInstance())
                2 -> Rigger.getRigger(this).startFragment(TopicFragment.newInstance())
                3 -> Rigger.getRigger(this).startFragment(MineFragment.newInstance())
                else -> {
                }
            }
        }
    }
}
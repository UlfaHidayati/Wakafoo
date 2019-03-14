package com.ulfa.wakafoo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var menu : Menu = bn_main.menu
        selectedMenu(menu.getItem(0))
        bottomView.setOnNavigationItemSelectedListener {
                item: MenuItem ->  selectedMenu(item)

            false
        }

    }
    private fun selectedMenu(item : MenuItem) {
        item.isChecked = true
        when(item.itemId) {
            R.id.home_menu -> selectedFragment(beranda.getInstance())
            R.id.profil_menu -> selectedFragment(HistoryFragment.getInstance())
            R.id.riwayat_menu -> selectedFragment(NewestFragment.getInstance())
        }
    }

    fun selectedFragment(fragment: Fragment) {
        var transaction : FragmentTransaction? = fragmentManager.beginTransaction()
        transaction?.replace(R.id.rootFragment, fragment)
        transaction?.commit()
    }

}

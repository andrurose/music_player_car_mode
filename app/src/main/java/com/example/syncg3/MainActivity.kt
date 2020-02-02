package com.example.syncg3

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_music, R.id.navigation_climate, R.id.navigation_phone, R.id.navigation_settings
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val inflater = layoutInflater
        val navigationMenuView = navView.getChildAt(0) as BottomNavigationMenuView
        val menu: Menu = navView.menu
        for (i in 0 until menu.size()) {
            val view =
                navigationMenuView.getChildAt(i) as BottomNavigationItemView
            val itemBottomNavigation: View =
                inflater.inflate(R.layout.item_bottom_navigation_bar, null, false)
            (itemBottomNavigation.findViewById<View>(R.id.icon) as ImageView).setImageDrawable(
                menu.getItem(i).icon
            )
            (itemBottomNavigation.findViewById<View>(R.id.title) as TextView).text =
                menu.getItem(i).title
            view.removeAllViews()
            view.addView(itemBottomNavigation)
        }
    }
}

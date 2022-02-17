package fi.oamk.idlebirb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager // creating object of ViewPager
    private lateinit var tab: TabLayout  // creating object of TabLayout
    private lateinit var bar: Toolbar    // creating object of ToolBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set the references of the declared objects above
        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        //bar = findViewById(R.id.toolbar)

        // To make our toolbar show the application
        // we need to give it to the ActionBar
       // setSupportActionBar(bar)

        // Initializing the ViewPagerAdapter
        val adapter = MyAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(Home(), "Home")
        adapter.addFragment(Upgrades(), "Upgrades")
        adapter.addFragment(Flock(), "Flock")

        // Adding the Adapter to the ViewPager
        pager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(pager)




    }


   // var seeds: Int = 0

    /*fun gatherSeeds() {
        Toast.makeText (getApplicationContext(), "seed got!", Toast.LENGTH_SHORT).show()
        seeds += 1
        seedc.text = seeds.toString()
    }*/
}
package fi.oamk.idlebirb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_s = findViewById<Button>(R.id.button_s)
        button_s.setOnClickListener {
            Toast.makeText (getApplicationContext(), "toast test", Toast.LENGTH_SHORT).show()
            gatherSeeds()

        }
    }


    var seeds: Int = 0
    val seedc by lazy { findViewById<TextView>(R.id.textView1) }


    fun gatherSeeds() {
        Toast.makeText (getApplicationContext(), "seed got!", Toast.LENGTH_SHORT).show()
        seeds += 1
        seedc.text = seeds.toString()
    }
}
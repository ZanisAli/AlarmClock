package startup.softflix.com.startup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveData= SaveData(applicationContext)
        tvShowTime.text = saveData.getHour().toString() + ":" + saveData.getMinute().toString()
    }

    fun BuSetTime(view: View)
    {
        val popTime=PopTime()
        val fm= fragmentManager
        popTime.show(fm,"Select Time")
    }

    fun SetTime(Hours: Int, Minutes: Int) {
        tvShowTime.text = Hours.toString() + ":" + Minutes.toString()

        val saveData= SaveData(applicationContext)
        saveData.SaveData(Hours,Minutes)// in broadcast receiver for saving data in sharef pref

    }
}
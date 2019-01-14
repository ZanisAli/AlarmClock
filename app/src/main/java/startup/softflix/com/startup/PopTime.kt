package startup.softflix.com.startup

import android.app.DialogFragment
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TimePicker

//in order to work with dialog we have to use : DialogFragment
class PopTime:DialogFragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var myView= inflater!!.inflate(R.layout.pop_time, container, false)

        var buDone = myView.findViewById<LinearLayout>(R.id.buDone) as Button

        var tp1= myView.findViewById<TimePicker>(R.id.tp1) as TimePicker

        buDone.setOnClickListener({

            //for getting current activity you can use that activity as X activity
            var ma= activity as MainActivity
            if(Build.VERSION.SDK_INT>=23) {
                ma.SetTime(tp1.hour, tp1.minute)
            }else{
                ma.SetTime(tp1.currentHour, tp1.currentMinute)
            }
            this.dismiss()
        })

        return myView
    }
}
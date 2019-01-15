package startup.softflix.com.startup

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

//have to register this broadcase receiver in the manifest, check there
class myBroadCastReceiver: BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        //whenever action happens that is defined in the manifest intent filter then system will directly direct action in this activity because broadcastreceiver is registered for this activity.
        //when action happen just showing some message
        if(intent!!.action.equals("com.tester.alarmmanager")){
            //can read message which is inserted in intent of SaveData class
            var b= intent.extras
            Toast.makeText(context, b.getString("message"), Toast.LENGTH_LONG).show()
        }
        //if the system in restarted
        else if (intent!!.action.equals("android.intent.action.BOOT_COMPLETED")){
            val saveData= SaveData(context!!)
            saveData.setAlarm()
        }

    }

}
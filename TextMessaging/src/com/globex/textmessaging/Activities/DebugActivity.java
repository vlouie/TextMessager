package com.globex.textmessaging.Activities;

import transport.NetInfo;
import transport.Packetizer;
import transport.SendTask;
import transport.SockReceiveThread;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.globex.textmessaging.R;
import com.globex.textmessaging.SMS.SMSMessage;
import com.globex.textmessaging.SMS.SMSReader;


/**
 * @author sterling
 *
 */
public class DebugActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SMSMessage messages[] = (new SMSReader(this)).getInboxMessages();

        String toSend = Packetizer.packetize(messages);
 
        NetInfo.setIp("10.0.2.2");
        

        Thread thr = new Thread(new SockReceiveThread());
        thr.start();
        
        (new SendTask()).execute(toSend
        		,NetInfo.getIp()
        		,String.valueOf(NetInfo.getPort())); 
        
        TextView tv = (TextView)findViewById(R.id.android_id);        
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
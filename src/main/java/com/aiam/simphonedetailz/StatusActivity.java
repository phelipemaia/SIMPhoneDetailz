package com.aiam.simphonedetailz;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.google.ads.AdRequest;
import com.google.ads.AdView;

@SuppressWarnings("deprecation")
public class StatusActivity extends TabActivity {

    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AdView adView = (AdView) this.findViewById(R.id.adView);
        AdRequest ar = new AdRequest();
        adView.loadAd(ar);

        TabHost host = getTabHost();
        
        TabSpec statusspec = host.newTabSpec("Phone");
        statusspec.setIndicator("Phone",getResources().getDrawable(R.drawable.nphone));
        Intent phoneStatusIntent = new Intent(this, PhoneStatusActivity.class);
        statusspec.setContent(phoneStatusIntent);
        
        TabSpec batteryspec = host.newTabSpec("Battery");
        batteryspec.setIndicator("Battery", getResources().getDrawable(R.drawable.nbattery));
        Intent batteryIntent = new Intent(this, BatteryStatusActivity.class);
        batteryspec.setContent(batteryIntent);

        /*TabSpec contactsspec = host.newTabSpec("Contacts");
        batteryspec.setIndicator("Contacts", getResources().getDrawable(R.drawable.nbattery));
        Intent contactsIntent = new Intent(this, BatteryStatusActivity.class);
        batteryspec.setContent(contactsIntent);*/

        // Adding all TabSpec to TabHost
        host.addTab(statusspec); 
        host.addTab(batteryspec);
        //host.addTab(contactsspec);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.phonestatus, menu);
        return true;
    }
}

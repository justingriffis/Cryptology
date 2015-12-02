package com.android.cryptology;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class CloudSelection extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_selection);
    }

    public void upload(View view){
        //box button clicked code here
        Intent i = new Intent(getBaseContext(), SaverMain.class);
        startActivity(i);

    }
    public void download(View view) {
        //add button clicked code here
        Intent i = new Intent(getBaseContext(), PickerMain.class);
        startActivity(i);

    }
    public void crypt(View view) {
        //add button clicked code here
        Intent i = new Intent(getBaseContext(), EncryptionActivity.class);
        startActivity(i);

    }

}

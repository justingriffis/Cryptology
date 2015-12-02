package com.android.cryptology;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.nononsenseapps.filepicker.FilePickerActivity;

import java.io.File;
import java.util.ArrayList;

public class EncryptionActivity extends Activity {
    int[] key = new int[32];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);

       // int[] key = new int[32]; // THE KEY MUST BE INT[32]
        key[0] = 1;
        for(int i = 0;i < 32; i++) {
            key[i] = 4 * i + key[i];
        }
    }

    public void encrypt(View view) {
        // Do something in response to button click
        Intent i = new Intent(this.getApplicationContext(), FilePickerActivity.class);
        // Set these depending on your use case. These are the defaults.
        i.putExtra(FilePickerActivity.EXTRA_ALLOW_MULTIPLE, false);
        i.putExtra(FilePickerActivity.EXTRA_ALLOW_CREATE_DIR, false);
        i.putExtra(FilePickerActivity.EXTRA_MODE, FilePickerActivity.MODE_FILE);

        // Configure initial directory by specifying a String.
        // You could specify a String like "/storage/emulated/0/", but that can
        // dangerous. Always use Android's API calls to get paths to the SD-card or
        // internal memory.
        i.putExtra(FilePickerActivity.EXTRA_START_PATH, Environment.getExternalStorageDirectory().getPath());

        startActivityForResult(i, 0);

    }
    public void decrypt(View view) {
        // Do something in response to button click
        Intent i = new Intent(this.getApplicationContext(), FilePickerActivity.class);
        // Set these depending on your use case. These are the defaults.
        i.putExtra(FilePickerActivity.EXTRA_ALLOW_MULTIPLE, false);
        i.putExtra(FilePickerActivity.EXTRA_ALLOW_CREATE_DIR, false);
        i.putExtra(FilePickerActivity.EXTRA_MODE, FilePickerActivity.MODE_FILE);

        // Configure initial directory by specifying a String.
        // You could specify a String like "/storage/emulated/0/", but that can
        // dangerous. Always use Android's API calls to get paths to the SD-card or
        // internal memory.
        i.putExtra(FilePickerActivity.EXTRA_START_PATH, Environment.getExternalStorageDirectory().getPath());

        startActivityForResult(i, 1);

    }
    public void delete(View view) {
        // Do something in response to button click
        Intent i = new Intent(this.getApplicationContext(), FilePickerActivity.class);
        // Set these depending on your use case. These are the defaults.
        i.putExtra(FilePickerActivity.EXTRA_ALLOW_MULTIPLE, false);
        i.putExtra(FilePickerActivity.EXTRA_ALLOW_CREATE_DIR, false);
        i.putExtra(FilePickerActivity.EXTRA_MODE, FilePickerActivity.MODE_FILE);

        // Configure initial directory by specifying a String.
        // You could specify a String like "/storage/emulated/0/", but that can
        // dangerous. Always use Android's API calls to get paths to the SD-card or
        // internal memory.
        i.putExtra(FilePickerActivity.EXTRA_START_PATH, Environment.getExternalStorageDirectory().getPath());

        startActivityForResult(i, 2);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            // Encrypt URI
            Encryption.startEncrypt(uri.getPath(),key);


        }
        else if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            Encryption.startDecrypt(uri.getPath(),key);

        }
        else if (requestCode == 2 && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            // Delete URI
            Toast.makeText(this,
                    "Deleted:\n"
                            + uri,
                    Toast.LENGTH_LONG).show();
            File file = new File(uri.getPath());
            file.delete();

        }
    }

}

package com.example.menuproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuhelp) {
            helpactivity(item);
            return true;
        }
        if (id == R.id.menusettings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


        public void sendsms (View view) {
            Uri phoneNum = Uri.parse("smsto:" + Uri.encode(getString(R.string.phonenumber)));
            Intent intentSMS = new Intent(Intent.ACTION_SENDTO, phoneNum);
            intentSMS.putExtra("sms_body", getString(R.string.message));
            startActivity(intentSMS);
        }

        public void newactivity (View view) {
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
        }

        public void callnumber (View view) {
        Uri phoneNum = Uri.parse("tel:" + Uri.encode(getString(R.string.phonenumber)));
        Intent intentcall = new Intent(Intent.ACTION_DIAL, phoneNum);
        startActivity(intentcall);
        }

        public void openwebpage (View view) {
        Uri webpage = Uri.parse(getString(R.string.weburl));
        Intent intentwebpage = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intentwebpage);
        }

        public void sharetext (View view) {
            ShareCompat.IntentBuilder.from(this).setType("text/plain").setChooserTitle(getString(R.string.sharetitle)).setText(getString(R.string.sharemsg)).startChooser();
        }

        public void openmap (View view) {
        Uri maplocation = Uri.parse("geo:0,0?q=" + getString(R.string.location));
        Intent intentmap = new Intent(Intent.ACTION_VIEW, maplocation);
        startActivity(intentmap);
        }

        public void helpactivity (MenuItem item) {
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
        }

}
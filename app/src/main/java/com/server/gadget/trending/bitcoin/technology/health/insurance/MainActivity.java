package com.server.gadget.trending.bitcoin.technology.health.insurance;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String Banner1 = "BannerKey";
    public static final String Interstitial1 = "InterstitialKey";
    public static final String Scond1 = "ScondKey";
    public static final String Scond2 = "Scond2Key";
    public static final String mypreference = "mypref";
    Button btnSeting;
    Button btnStart;
    Button btnTutor;
    EditText edtBanner2;
    EditText edtInterstitial2;
    EditText edtScond2;
    EditText edtScond3;
    Intent intent;
    private AdView mAdView;
    SharedPreferences sharedpreferences;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        WebView view = (WebView) findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl("https://www.wieistmeineip.de/ip-address/");



        {
            this.edtBanner2 = (EditText) findViewById(R.id.edtBanner2);


            this.edtScond2 = (EditText) findViewById(R.id.edtScond2);
            this.edtScond3 = (EditText) findViewById(R.id.edtScond3);
            this.edtInterstitial2 = (EditText) findViewById(R.id.edtIntertitial2);
            this.btnStart = (Button) findViewById(R.id.btnStart);

            this.btnSeting = (Button) findViewById(R.id.btnSeting);
            this.mAdView = (AdView) findViewById(R.id.adView);
            this.mAdView.loadAd(new Builder().addTestDevice("C0AE6C45DB835D1E370B998A2D81871C").build());
            this.btnSeting.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    MainActivity.this.intent = new Intent(MainActivity.this.getApplicationContext(), Seting.class);
                    MainActivity.this.startActivity(MainActivity.this.intent);
                }
            });
            this.btnStart.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    MainActivity.this.intent = new Intent(MainActivity.this.getApplicationContext(), Pilih.class);
                    MainActivity.this.startActivity(MainActivity.this.intent);
                    


                }
            });

            this.edtBanner2 = (EditText) findViewById(R.id.edtBanner2);
            this.edtScond2 = (EditText) findViewById(R.id.edtScond2);
            this.edtScond3 = (EditText) findViewById(R.id.edtScond3);
            this.edtInterstitial2 = (EditText) findViewById(R.id.edtIntertitial2);
            this.btnStart = (Button) findViewById(R.id.btnStart);

            this.btnSeting = (Button) findViewById(R.id.btnSeting);
            this.mAdView = (AdView) findViewById(R.id.adView);
            this.mAdView.loadAd(new Builder().addTestDevice("C0AE6C45DB835D1E370B998A2D81871C").build());

        }
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://t.me/keju_manis"));
            final String appName = "org.telegram.messenger";
            i.setPackage(appName);
            this.startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
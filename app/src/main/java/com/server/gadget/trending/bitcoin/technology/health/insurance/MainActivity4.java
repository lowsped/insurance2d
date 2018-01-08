package com.server.gadget.trending.bitcoin.technology.health.insurance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity4 extends AppCompatActivity {
    public static final String Banner1 = "BannerKey";
    public static final String Interstitial1 = "InterstitialKey";
    public static final String Scond1 = "ScondKey";
    public static final String Scond2 = "Scond2Key";
    public static final String mypreference = "mypref";
    Button btnStart;
    int clickcount;
    int clickcount2 = 0;
    TextView edtBanner2;
    TextView edtInterstitial2;
    TextView edtScond2;
    TextView edtScond3;
    Intent intent;
    private InterstitialAd interstitial;
    private AdView mAdView;
    private AdView mAdView2;
    SharedPreferences sharedpreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main4);
        this.edtBanner2 = (TextView) findViewById(R.id.edtBanner2);
        this.edtInterstitial2 = (TextView) findViewById(R.id.edtInterstitial2);
        this.edtScond2 = (TextView) findViewById(R.id.edtScond2);
        this.edtScond3 = (TextView) findViewById(R.id.edtScond3);
        this.btnStart = (Button) findViewById(R.id.btnStart);
        this.sharedpreferences = getSharedPreferences("mypref", 0);
        if (this.sharedpreferences.contains("BannerKey")) {
            this.edtBanner2.setText(this.sharedpreferences.getString("BannerKey", ""));
        }
        if (this.sharedpreferences.contains("InterstitialKey")) {
            this.edtInterstitial2.setText(this.sharedpreferences.getString("InterstitialKey", ""));
        }
        if (this.sharedpreferences.contains("ScondKey")) {
            this.edtScond2.setText(this.sharedpreferences.getString("ScondKey", ""));
        }
        if (this.sharedpreferences.contains("Scond2Key")) {
            this.edtScond3.setText(this.sharedpreferences.getString("Scond2Key", ""));
        }
        RelativeLayout layout = new RelativeLayout(this);
        layout.setBackgroundColor(Color.parseColor("#ff3c4556"));
        LayoutParams params = new LayoutParams(-1, -2);
        params.addRule(12);
        this.mAdView = new AdView(this);
        this.mAdView.setAdSize(AdSize.BANNER);
        this.mAdView.setAdUnitId(this.edtBanner2.getText().toString());
        this.mAdView2 = new AdView(this);
        this.mAdView2.setAdSize(AdSize.BANNER);
        this.mAdView2.setAdUnitId(this.edtBanner2.getText().toString());
        layout.addView(this.mAdView, params);
        layout.addView(this.mAdView2, params);
        setContentView((View) layout);
        final Handler mhandler = new Handler();
        mhandler.postDelayed(new Runnable() {
            public void run() {
                Integer scond2 = Integer.valueOf(0);
                scond2 = Integer.valueOf(MainActivity4.this.edtScond3.getText().toString());
                Builder adRequestBuilder = new Builder();
                adRequestBuilder.addTestDevice("B3EEABB8EE11C2BE770B684D95219ECB");
                MainActivity4.this.mAdView.loadAd(adRequestBuilder.build());
                MainActivity4.this.clickcount2++;
                if (MainActivity4.this.clickcount2 == 1) {
                    mhandler.postDelayed(this, (long) (scond2.intValue() * 1000));
                } else {
                    mhandler.postDelayed(this, (long) (scond2.intValue() * 1000));
                }
            }
        }, 2000);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Integer scond = Integer.valueOf(0);
                scond = Integer.valueOf(MainActivity4.this.edtScond2.getText().toString());
                AdRequest adRequest = new Builder().addTestDevice("C0AE6C45DB835D1E370B998A2D81871C").build();
                MainActivity4.this.interstitial = new InterstitialAd(MainActivity4.this);
                MainActivity4.this.interstitial.setAdUnitId(MainActivity4.this.edtInterstitial2.getText().toString());
                MainActivity4.this.interstitial.loadAd(adRequest);
                MainActivity4.this.interstitial.setAdListener(new AdListener() {
                    public void onAdLoaded() {
                        displayInterstitial();
                    }

                    public void displayInterstitial() {
                        if (MainActivity4.this.interstitial.isLoaded()) {
                            MainActivity4.this.interstitial.show();
                        }
                        MainActivity4.this.clickcount++;
                        if (MainActivity4.this.clickcount == 1) {
                            Toast.makeText(MainActivity4.this.getApplicationContext(), " Interistial 1x Banner 1x ", 1).show();
                        } else {
                            Toast.makeText(MainActivity4.this.getApplicationContext(), " Interistial " + MainActivity4.this.clickcount + "x " + " Banner " + MainActivity4.this.clickcount2 + "x ", 1).show();
                        }
                    }
                });
                handler.postDelayed(this, (long) (scond.intValue() * 1000));
            }
        }, 2000);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(268468224);
        startActivity(i);
        finish();
        finishAffinity();
        System.exit(0);
    }
}
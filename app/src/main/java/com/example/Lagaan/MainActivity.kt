package com.example.Lagaan

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ironsource.mediationsdk.IronSource
import com.ironsource.mediationsdk.logger.IronSourceError
import com.ironsource.mediationsdk.sdk.InitializationListener
import com.ironsource.mediationsdk.sdk.InterstitialListener


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        IronSource.init(this, "1375f3b81");
        IronSource.init(this, "1375f3b81", object : InitializationListener {
            override fun onInitializationComplete() {
            }


        }
        )

//        IronSource.loadBanner(findViewById(R.id.bannerContainer));

        IronSource.setInterstitialListener(object : InterstitialListener {
            override fun onInterstitialAdReady() {
                IronSource.showInterstitial("DefaultInterstitial");
            }

            override fun onInterstitialAdLoadFailed(p0: IronSourceError?) {
                Toast.makeText(this@MainActivity, "failed", Toast.LENGTH_SHORT).show()
            }

            override fun onInterstitialAdOpened() {
            }

            override fun onInterstitialAdClosed() {
            }

            override fun onInterstitialAdShowSucceeded() {
            }

            override fun onInterstitialAdShowFailed(p0: IronSourceError?) {
            }

            override fun onInterstitialAdClicked() {
            }

        })
        IronSource.loadInterstitial();
    }

    override fun onResume() {
        super.onResume()
        IronSource.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        IronSource.onPause(this)
    }
}
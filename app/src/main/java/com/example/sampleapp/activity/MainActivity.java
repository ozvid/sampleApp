/**
 *@copyright : OZVID Technologies Pvt. Ltd. < www.ozvid.com >
 *@author	 : Shiv Charan Panjeta < shiv@ozvid.com >
 */
package com.example.sampleapp.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.sampleapp.R;
import com.example.sampleapp.fragments.HomeFragment;


public class MainActivity extends AppCompatActivity {
    private boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gotoHomeFragment();
    }

    private void gotoHomeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameFL, new HomeFragment())
                .commit();
    }


    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frameFL);
        if (fragment instanceof HomeFragment) {
            backAction();
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            gotoHomeFragment();
        }
    }

    public void backAction() {
        if (exit) {
            finishAffinity();
        } else {
            showToast(getString(R.string.press_one_more_time));
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 2 * 1000);
        }
    }


    public void showToast(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

}

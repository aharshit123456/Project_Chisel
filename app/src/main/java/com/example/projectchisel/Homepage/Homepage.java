package com.example.projectchisel.Homepage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.projectchisel.Login;
import com.example.projectchisel.R;
import com.example.projectchisel.Utils.BottomNavigationViewHelper;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Homepage extends AppCompatActivity {

    public static final String TAG = "HomeActivity" ;
    public static final int ACTIVITY_NUM = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Log.d(TAG, "onCreate starting") ;
        setupBottomNavigationView() ;
        overridePendingTransition(0,0) ;
        setupViewPager() ;

    }



//Setting Up Fragments

    private void setupViewPager(){
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragments(new Camera_Fragment());
        adapter.addFragments(new Home_Fragment());
        adapter.addFragments(new Chat_Fragment());
        ViewPager viewpager = findViewById(R.id.container) ;
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(1);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewpager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_photo_camera_black_24dp);
        tabLayout.getTabAt(1).setText("Project Chisel");
        tabLayout.getTabAt(2).setIcon(R.drawable.chat_fragment);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }


    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting Up Helper");
        BottomNavigationViewEx bottomNavigationViewEx = findViewById(R.id.bottomnavviewbar);
        BottomNavigationViewHelper.setupBottomNavigationViewHelper(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNav(Homepage.this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem =  menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}



package com.example.fragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.fragment.Fragment.Favorite;
import com.example.fragment.Fragment.Home;
import com.example.fragment.Fragment.Profile;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnMain;

    Home homefrag;
    Favorite favFrag;
    Profile profileFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homefrag = new Home();
        favFrag = new Favorite();
        profileFrag = new Profile();

        changeFragment(homefrag);


        btnMain = findViewById(R.id.BtnMain);
        btnMain.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.MmenuHome:
                        changeFragment(homefrag);
                        break;
                    case R.id.MmenuFavorite:
                        changeFragment(favFrag);
                        break;
                    case R.id.MmenuProfile:
                        changeFragment(profileFrag);
                        break;

                }
                return true;

            }
        });
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameMain, fragment)
                .commit();
    }
}

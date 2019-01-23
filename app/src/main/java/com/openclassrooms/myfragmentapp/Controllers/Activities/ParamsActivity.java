package com.openclassrooms.myfragmentapp.Controllers.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.ParamsFragment;
import com.openclassrooms.myfragmentapp.R;

public class ParamsActivity extends AppCompatActivity {

    //Declare detail fragment
    private ParamsFragment paramsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_params);
        this.configureAndShowDetailFragment();
        this.configureToolbar();
    }
    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowDetailFragment(){
        paramsFragment = (ParamsFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_params);
        if (paramsFragment == null) {
            paramsFragment = new ParamsFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_params, paramsFragment)
                    .commit();
        }
    }

    // --------------
    // UPDATE UI
    // --------------

    private void configureToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }
}

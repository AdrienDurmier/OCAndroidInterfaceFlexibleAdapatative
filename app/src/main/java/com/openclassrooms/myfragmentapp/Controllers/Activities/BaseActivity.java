package com.openclassrooms.myfragmentapp.Controllers.Activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.openclassrooms.myfragmentapp.R;

import butterknife.ButterKnife;
import icepick.Icepick;

public abstract class BaseActivity extends AppCompatActivity {

    // --------------
    // Force developer implement those methods
    // --------------
    protected abstract int getFragmentLayout();
    protected abstract void configureDesign();
    protected abstract void updateDesign();

    // -----------------
    // Override
    // -----------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getFragmentLayout());
        ButterKnife.bind(this);
        Icepick.restoreInstanceState(this, savedInstanceState);
        this.configureDesign();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.updateDesign();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }

    // --------------
    // Design
    // --------------
    protected void configureToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    protected void configureUp(){
        ActionBar ab = getSupportActionBar();
        if (ab != null) ab.setDisplayHomeAsUpEnabled(true);
    }

}

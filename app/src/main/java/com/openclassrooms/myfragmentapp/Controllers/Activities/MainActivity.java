package com.openclassrooms.myfragmentapp.Controllers.Activities;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.openclassrooms.myfragmentapp.Controllers.Fragments.MainFragment;
import com.openclassrooms.myfragmentapp.R;

public class MainActivity extends BaseActivity implements MainFragment.OnButtonClickedListener {

    //Declare our two fragments
    private MainFragment mainFragment;
    private DetailFragment detailFragment;

    /** ********************************************************************************************
     * Partie méthodes du BaseActivity
     */
    @Override
    protected int getFragmentLayout() { return R.layout.activity_main; }

    @Override
    protected void configureDesign() {
        this.configureAndShowMainFragment();    // -> Fragment Main
        this.configureAndShowDetailFragment();  // -> Fragment detail
        this.configureToolbar();                // -> Toolbar
    }

    @Override
    protected void updateDesign() { }
    /**
     * FIN/ Partie méthodes du BaseActivity
     ******************************************************************************************** */

    // --------------
    // CallBack
    // --------------

    @Override
    public void onButtonClicked(View view) {
        //Retrieve button tag
        int buttonTag = Integer.parseInt(view.getTag().toString());

        //Check if DetailFragment is visible (Tablet)
        if (detailFragment != null && detailFragment.isVisible()) {
            //TABLET : Update directly TextView
            detailFragment.updateTextView(buttonTag);
        } else {
            //SMARTPHONE : Pass tag to the new intent that will show DetailActivity (and so DetailFragment)
            Intent i = new Intent(this, DetailActivity.class);
            i.putExtra(DetailActivity.EXTRA_BUTTON_TAG, buttonTag);
            startActivity(i);
        }
    }

    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowMainFragment(){
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

        if (mainFragment == null) {
            mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_main, mainFragment)
                    .commit();
        }
    }

    private void configureAndShowDetailFragment(){
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (detailFragment == null && findViewById(R.id.frame_layout_detail) != null) {
            detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit();
        }
    }

    // --------------
    // Override
    // --------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //3 - Handle actions on menu items
        switch (item.getItemId()) {
            case R.id.menu_params:
                Intent i = new Intent(this, ParamsActivity.class);
                startActivity(i);
                return true;
            case R.id.menu_search:
                Toast.makeText(this, "Recherche indisponible, demandez plutôt l'avis de Google, c'est mieux et plus rapide.", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

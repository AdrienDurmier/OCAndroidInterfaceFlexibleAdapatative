package com.openclassrooms.myfragmentapp.Controllers.Activities;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.DetailFragment;
import com.openclassrooms.myfragmentapp.R;

public class DetailActivity extends BaseActivity {

    public static final String EXTRA_BUTTON_TAG = "com.openclassrooms.myfragmentapp.Controllers.Activities.DetailActivity.EXTRA_BUTTON_TAG";
    private DetailFragment detailFragment;

    /** ********************************************************************************************
     * Partie méthodes du BaseActivity
     */
    @Override
    protected int getFragmentLayout() { return R.layout.activity_detail; }

    @Override
    protected void configureDesign() {
        this.configureAndShowDetailFragment();  // -> Fragment
        this.configureToolbar();                // -> Toolbar
        this.configureUp();                     // -> Bouton de retour
    }

    @Override
    protected void updateDesign() { this.updateDetailFragmentTextViewWithIntentTag(); }
    /**
     * FIN/ Partie méthodes du BaseActivity
     ******************************************************************************************** */

    // --------------
    // FRAGMENTS
    // --------------

    private void configureAndShowDetailFragment(){
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);
        if (detailFragment == null) {
            detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit();
        }
    }

    // --------------
    // UPDATE UI
    // --------------

    //Update DetailFragment with tag passed from Intent
    private void updateDetailFragmentTextViewWithIntentTag(){
        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);
        detailFragment.updateTextView(buttonTag);
    }
}

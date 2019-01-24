package com.openclassrooms.myfragmentapp.Controllers.Activities;

import com.openclassrooms.myfragmentapp.Controllers.Fragments.ParamsFragment;
import com.openclassrooms.myfragmentapp.R;

public class ParamsActivity extends BaseActivity {

    private ParamsFragment paramsFragment;

    /** ********************************************************************************************
     * Partie méthodes du BaseActivity
     */
    @Override
    protected int getFragmentLayout() { return R.layout.activity_params; }

    @Override
    protected void configureDesign() {
        this.configureAndShowParamsFragment();  // -> Fragment
        this.configureToolbar();                // -> Toolbar
        this.configureUp();                     // -> Bouton de retour
    }

    @Override
    protected void updateDesign() { }
    /**
     * FIN/ Partie méthodes du BaseActivity
     ******************************************************************************************** */

    private void configureAndShowParamsFragment(){
        paramsFragment = (ParamsFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_params);
        if (paramsFragment == null) {
            paramsFragment = new ParamsFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_params, paramsFragment)
                    .commit();
        }
    }
}

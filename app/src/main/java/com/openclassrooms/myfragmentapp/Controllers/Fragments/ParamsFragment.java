package com.openclassrooms.myfragmentapp.Controllers.Fragments;


import com.openclassrooms.myfragmentapp.R;


public class ParamsFragment extends BaseFragment {

    // --------------
    // BASE METHODS
    // --------------

    @Override
    protected BaseFragment newInstance() { return new ParamsFragment(); }

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_params; }

    @Override
    protected void configureDesign() { }

    @Override
    protected void updateDesign() { }
}
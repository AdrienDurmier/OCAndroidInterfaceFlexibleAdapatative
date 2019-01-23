package com.openclassrooms.myfragmentapp.Controllers.Fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.openclassrooms.myfragmentapp.R;

import butterknife.BindView;


public class MainFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.fragment_main_button_happy) Button buttonHappy;
    @BindView(R.id.fragment_main_button_sad) Button buttonSad;
    @BindView(R.id.fragment_main_button_horrible) Button buttonHorrible;

    // Declare callback
    private OnButtonClickedListener mCallback;

    // Declare our interface that will be implemented by any container activity
    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }

    // --------------
    // BASE METHODS
    // --------------

    @Override
    protected BaseFragment newInstance() { return new MainFragment(); }

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_main; }

    @Override
    protected void configureDesign() {
        this.updateClickListener();
    }

    @Override
    protected void updateDesign() { }

    // --------------

    public void updateClickListener(){
        this.buttonHappy.setOnClickListener(this);
        this.buttonSad.setOnClickListener(this);
        this.buttonHorrible.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();
    }

    // --------------
    // ACTIONS
    // --------------

    @Override
    public void onClick(View v) {
        // Spread the click to the parent activity
        mCallback.onButtonClicked(v);
    }

    // --------------
    // FRAGMENT SUPPORT
    // --------------

    // Create callback to parent activity
    private void createCallbackToParentActivity(){
        try {
            // Parent activity will automatically subscribe to callback
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }
}

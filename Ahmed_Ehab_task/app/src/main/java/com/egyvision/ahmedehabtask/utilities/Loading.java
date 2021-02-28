package com.egyvision.ahmedehabtask.utilities;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;

import com.egyvision.ahmedehabtask.R;

public class Loading extends DialogFragment {
    ImageView logo_s, logo_e;
    int time = 700 ;

    public Loading() {
        // Required empty public constructor
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(getActivity());
        String applang = sharedPrefUtil.getValueFromSharePref("appLang");

        getDialog().getWindow()
                .getAttributes().windowAnimations = R.style.DialogStyle;
        getDialog().getWindow().setGravity(Gravity.CENTER);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogStyle);

        View root = inflater.inflate(R.layout.fragment_loading, container, false);




        return root;
    }

    public void closeFragment(){
        this.getDialog().dismiss();
    }
}
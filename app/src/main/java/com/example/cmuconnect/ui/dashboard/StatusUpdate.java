package com.example.cmuconnect.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.cmuconnect.MainActivity;
import com.example.cmuconnect.R;
import com.example.cmuconnect.ui.Login;


public class StatusUpdate extends Fragment {


    private StatusUpdateVM suVM;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        suVM = ViewModelProviders.of(this).get(StatusUpdateVM.class);
        View root = inflater.inflate(R.layout.update_status, container, false);
        final ImageView close = root.findViewById(R.id.close);
        //final Fragment frag = new NavHostFragment();
//        close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                FragmentManager fm = getActivity().getSupportFragmentManager();
////                FragmentTransaction transaction = fm.beginTransaction();
////                transaction.replace(R.id.container, frag );
////                transaction.addToBackStack(null);
////                transaction.commit();
//            }
//        });
        return root;
    }


}

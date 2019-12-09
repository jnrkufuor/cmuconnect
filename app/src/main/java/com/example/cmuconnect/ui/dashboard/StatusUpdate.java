package com.example.cmuconnect.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
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


    private static final int RESULT_LOAD_IMAGE = 1;
    private StatusUpdateVM suVM;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        suVM = ViewModelProviders.of(this).get(StatusUpdateVM.class);
        View root = inflater.inflate(R.layout.update_status, container, false);
        final ImageView upload = root.findViewById(R.id.upload);

        //final Fragment frag = new NavHostFragment();
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i,RESULT_LOAD_IMAGE);
            }
        });
        return root;
    }


}

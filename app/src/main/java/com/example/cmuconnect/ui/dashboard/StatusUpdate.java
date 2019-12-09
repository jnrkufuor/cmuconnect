package com.example.cmuconnect.ui.dashboard;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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

    private ImageView upload;
    private ImageView camera ;

    private static final int RESULT_LOAD_IMAGE = 1;
    private StatusUpdateVM suVM;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        suVM = ViewModelProviders.of(this).get(StatusUpdateVM.class);
        View root = inflater.inflate(R.layout.update_status, container, false);
         upload = root.findViewById(R.id.upload);
         camera = root.findViewById(R.id.camera);

        //final Fragment frag = new NavHostFragment();
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i,RESULT_LOAD_IMAGE);
            }
        });
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            camera.setEnabled(false);
            ActivityCompat.requestPermissions(getActivity(), new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //file = Uri.fromFile(getContext().getOutputMediaFile());
                //intent.putExtra(MediaStore.EXTRA_OUTPUT, file);

                startActivityForResult(intent, 100);
            }
        });

        return root;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                camera.setEnabled(true);
            }
        }
    }


}

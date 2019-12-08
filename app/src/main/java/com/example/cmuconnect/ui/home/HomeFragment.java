package com.example.cmuconnect.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.cmuconnect.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private String[] maintitle ={
            "Title 1","Title 2",
            "Title 3",};

    private String[] subtitle ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3"};

    private Integer[] imgid={
            R.drawable.bg,R.drawable.bg,
            R.drawable.bg,  };
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        final ListView list = root.findViewById(R.id.communitylist);

        ListAdapter adapter=new ListAdapter(getActivity(), maintitle, subtitle,imgid);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) list.getItemAtPosition(position);
                Toast.makeText(getActivity(),clickedItem,Toast.LENGTH_LONG).show();
            }
        });

        return root;
    }
}
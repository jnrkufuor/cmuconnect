package com.example.cmuconnect.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cmuconnect.Model.ModelFeed;
import com.example.cmuconnect.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private RecyclerView rv;
    private ArrayList<ModelFeed> mf = new ArrayList<>();
    private AdapterFeed adapterFeed;
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        final Fragment frag = new StatusUpdate();
        final FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.add(R.id.container, frag );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        rv = root.findViewById(R.id.recycler);
        System.out.println(rv);

        RecyclerView.LayoutManager lm = new LinearLayoutManager(getContext());
        rv.setLayoutManager(lm);

        adapterFeed = new AdapterFeed(getContext(),mf);
        rv.setAdapter(adapterFeed);
        populateRecycleView();

        return root;
    }

    public void populateRecycleView()
    {
        ModelFeed modelFeed = new ModelFeed(1,2,R.drawable.bg,0,
                5,4,11,"Ernest Jabar","Social media News Feed UI design in Android Studio using recycler view. Hope you find it useful. Thanks for watching.","11 hours","Data Science");
        mf.add(modelFeed);
        ModelFeed modelFeed1 = new ModelFeed(1,2,R.drawable.bg,0,
                5,4,11,"Ernest Jabar","Social media News Feed UI design in Android Studio using recycler view. Hope you find it useful. Thanks for watching.","11 hours","Data Science");
        mf.add(modelFeed1);
        ModelFeed modelFeed2 = new ModelFeed(1,2,R.drawable.bg,R.drawable.cake,
                5,4,11,"Ernest Jabar","Social media News Feed UI design in Android Studio using recycler view. Hope you find it useful. Thanks for watching.","11 hours","Data Science");
        mf.add(modelFeed2);
        ModelFeed modelFeed3 = new ModelFeed(1,2,R.drawable.bg,0,
                5,4,11,"Ernest Jabar","Social media News Feed UI design in Android Studio using recycler view. Hope you find it useful. Thanks for watching.","11 hours","Data Science");
        mf.add(modelFeed3);
        adapterFeed.notifyDataSetChanged();
    }
}
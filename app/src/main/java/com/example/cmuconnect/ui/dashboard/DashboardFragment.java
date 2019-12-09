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

import com.example.cmuconnect.Database.Database;
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
        Database db = new Database(getContext());


        ModelFeed modelFeed = new ModelFeed(1,2,R.drawable.a,0,
                5,4,15,"Ernest Jabar","There was no ice cream in the freezer, nor did they have money to go to the store.","2 hours","Random Stuff");
        mf.add(modelFeed);
        ModelFeed modelFeed1 = new ModelFeed(1,2,R.drawable.aa,0,
                5,4,110,"Fred Morning","She only paints with bold colors; she does not like pastels.","5 hours","Data Science");
        mf.add(modelFeed1);
        ModelFeed modelFeed2 = new ModelFeed(1,2,R.drawable.aaaa,R.drawable.cake,
                5,4,11,"Julio22","Where do random thoughts come from?.","15 hours","Data Science");
        mf.add(modelFeed2);
        ModelFeed modelFeed3 = new ModelFeed(1,2,R.drawable.bg,0,
                5,4,2000,"Amazing Stuff","Sometimes, all you need to do is completely make an ass of yourself and laugh it off to realise that life isn’t so bad after all.","1 day","Student Guild");
        ModelFeed modelFeed4 = new ModelFeed(1,2,R.drawable.aaa,0,
                5,4,15,"Ernest Jabar","There was no ice cream in the freezer, nor did they have money to go to the store.","2 hours","Random Stuff");
        mf.add(modelFeed4);
        ModelFeed modelFeed5 = new ModelFeed(1,2,R.drawable.bg,0,
                5,4,110,"Fred Morning","She only paints with bold colors; she does not like pastels.","5 hours","Data Science");
        mf.add(modelFeed5);
        ModelFeed modelFeed6 = new ModelFeed(1,2,R.drawable.a,R.drawable.aaaa,
                5,4,11,"Julio22","Where do random thoughts come from?.","15 hours","Data Science");
        mf.add(modelFeed6);
        ModelFeed modelFeed7 = new ModelFeed(1,2,R.drawable.bg,0,
                5,4,2000,"Amazing Stuff","Sometimes, all you need to do is completely make an ass of yourself and laugh it off to realise that life isn’t so bad after all.","1 day","Student Guild");

        mf.add(modelFeed4);
        ModelFeed modelFeed8 = new ModelFeed(1,2,R.drawable.aaa,0,
                5,4,110,"Fred Morning","She only paints with bold colors; she does not like pastels.","5 hours","Data Science");
        mf.add(modelFeed8);
        ModelFeed modelFeed9 = new ModelFeed(1,2,R.drawable.aaaa,R.drawable.cake,
                5,4,11,"Julio22","Where do random thoughts come from?.","15 hours","Data Science");
        mf.add(modelFeed9);
        ModelFeed modelFeed10 = new ModelFeed(1,2,R.drawable.a,0,
                5,4,2000,"Amazing Stuff","Sometimes, all you need to do is completely make an ass of yourself and laugh it off to realise that life isn’t so bad after all.","1 day","Student Guild");

        mf.add(modelFeed10);
        adapterFeed.notifyDataSetChanged();
    }
}
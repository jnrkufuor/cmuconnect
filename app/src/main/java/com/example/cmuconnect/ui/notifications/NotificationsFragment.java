package com.example.cmuconnect.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.cmuconnect.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        String[] array = {"Create Community","Update Profile","Change Language","Settings",
                "FAQs","About","Logout"};
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),R.layout.listview,array);
        final ListView listView = (ListView) root.findViewById(R.id.profile_list);
        listView.setAdapter(adapter);

        return root;
    }
}
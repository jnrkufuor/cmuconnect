package com.example.cmuconnect.ui.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cmuconnect.R;


public class ListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] title;
    private final String[] sub;
    private final Integer[] img;

    public ListAdapter(Activity context, String[] maintitle,String[] subtitle, Integer[] imgid) {
        super(context, R.layout.list, maintitle);

        this.context=context;
        this.title=maintitle;
        this.sub=subtitle;
        this.img=imgid;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list, null,true);

        TextView titleText =  rowView.findViewById(R.id.title);
        ImageView imageView =  rowView.findViewById(R.id.icon);
        TextView subtitleText = rowView.findViewById(R.id.subtitle);

        titleText.setText(title[position]);
        imageView.setImageResource(img[position]);
        subtitleText.setText(sub[position]);

        return rowView;

    };
}

package com.wusui.todoist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fg on 2016/2/19.
 */
public class SecondAdapter extends ArrayAdapter<Second> {
    private int resourceId;

    public SecondAdapter(Context context,int textViewResourceId, List<Second> objects) {
        super(context,textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    public View getView(int position,View convertView,ViewGroup parent){
        Second second = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView secondName = (TextView)view.findViewById(R.id.second_name);
        ImageView secondImage= (ImageView)view.findViewById(R.id.second_image);

        secondName.setText(second.getName());
        secondImage.setImageResource(second.getImageId());

        return view;
    }
}

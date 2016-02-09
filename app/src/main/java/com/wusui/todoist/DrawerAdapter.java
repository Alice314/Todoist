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
 * Created by fg on 2016/2/8.
 */
public class DrawerAdapter extends ArrayAdapter<Drawer>{
    private int resourceId;

    public DrawerAdapter(Context context,int textViewResourceId,List<Drawer> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        Drawer drawer = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, true);
        TextView drawerName = (TextView)view.findViewById(R.id.item_title);
        ImageView drawerImage = (ImageView)view.findViewById(R.id.icon);

        drawerImage.setImageResource(drawer.getImageId());
        drawerName.setText(drawer.getName());
        return view;
    }
}

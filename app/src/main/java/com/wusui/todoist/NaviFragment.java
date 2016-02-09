package com.wusui.todoist;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fg on 2016/2/9.
 */
public class NaviFragment extends Fragment {
    private ListView leftMenu;
    private List<Drawer> drawerList;

    public interface menuClickListener{
        void menuClick(String menuName);
    }
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_main_drawer,container,false);
        initleftMenuContral(view);
        return view;
    }
    private void initleftMenuContral(View view){
        leftMenu = (ListView)view.findViewById(R.id.list_view);
        drawerList = getMenuItem();
        DrawerAdapter adapter = new DrawerAdapter(getActivity(),R.layout.item,drawerList);
        leftMenu.setAdapter(adapter);
        leftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (getActivity() instanceof menuClickListener) {
                    ((menuClickListener) getActivity()).menuClick(drawerList.get(position).getName());

                }
            }
        });
    }
    private List<Drawer>getMenuItem(){
        List<Drawer>drawerList = new ArrayList<>();

        String[]itemTitle = getResources().getStringArray(R.array.myarray);
        TypedArray itemIconRes = getResources().obtainTypedArray(R.array.yourarray);

        for (int i = 0;i<itemTitle.length;i++){
            Drawer lmi = new Drawer();
            lmi.setImageId(itemIconRes.getResourceId(i,0));
            lmi.setName(itemTitle[i]);
            drawerList.add(lmi);
        }
        return drawerList;
    }
}

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
        leftMenu = (ListView)view.findViewById(R.id.leftmenu);
        drawerList = getMenuItem();
        DrawerAdapter adapter = new DrawerAdapter(getActivity(),R.layout.item,drawerList);
        leftMenu.setAdapter(adapter);
        leftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (getActivity() instanceof menuClickListener) {
//                    java 中的instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例。instanceof通过返回一个布尔值来指出，这个对象是否是这个特定类或者是它的子类的一个实例。
//                  用法:result = object instanceof class
//                 参数:Result：布尔类型。
//                    Object：必选项。任意对象表达式。
//                    Class：必选项。任意已定义的对象
                    ((menuClickListener) getActivity()).menuClick(drawerList.get(position).getName());

                }
            }
        });
    }
    private List<Drawer>getMenuItem(){
        List<Drawer>drawerList = new ArrayList<Drawer>();

        String[]itemTitle = getResources().getStringArray(R.array.myarray);
        // getStringArray:Return the string array associated with a particular resource ID.还有String、Text类型的
        TypedArray itemIconRes = getResources().obtainTypedArray(R.array.yourarray);
//obtainTypedArray:Return an array of heterogeneous values.
        for (int i = 0;i<itemTitle.length;i++){
            Drawer lmi = new Drawer();
            lmi.setImageId(itemIconRes.getResourceId(i,0));
            //第二个参数叫做defValue，也就是default Value,默认值，如果你要取得的属性没有定义，或者不属于资源，就会返回这个defValue
            lmi.setName(itemTitle[i]);
            drawerList.add(lmi);
        }
        return drawerList;
    }
}

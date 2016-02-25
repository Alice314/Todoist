package com.wusui.todoist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by fg on 2016/2/18.
 */
public class SecondActivity extends AppCompatActivity {
    private List<Second>secondList = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar second_toolbar = (Toolbar)findViewById(R.id.second_toolbar);
        setSupportActionBar(second_toolbar);
        second_toolbar.setNavigationIcon(R.mipmap.ic_jiantou);
        second_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        initSecond();
        SecondAdapter adapter = new SecondAdapter(SecondActivity.this,R.layout.item_second,secondList);
        final ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                Second s = secondList.get(position);
                switch (s.getName()) {
                    case "到期日期":
                        Toast.makeText(SecondActivity.this, "抱歉，暂不开放此功能", Toast.LENGTH_SHORT).show();
                        break;
                    case "优先级":

                        view.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),listView);
                                getMenuInflater().inflate(R.menu.menu_third_priority,popupMenu.getMenu());
                                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem item) {
                                        switch (item.getItemId()){
                                            case R.id.four:
                                                String four = "优先级 4";
                                                Intent intent = new Intent();
                                                intent.putExtra("four",four);
                                                setResult(RESULT_OK,intent);
                                                finish();
                                                break;
                                            default:
                                        }
                                        return false;
                                    }
                                });
                                popupMenu.show();
                            }
                        });
                        break;
                    case "标签":
                        Toast.makeText(SecondActivity.this, "抱歉，暂不开放此功能", Toast.LENGTH_SHORT).show();
                        break;
                    case "次级任务":
                        Toast.makeText(SecondActivity.this, "抱歉，暂不开放此功能", Toast.LENGTH_SHORT).show();
                        break;
                    case "评论":
                        Toast.makeText(SecondActivity.this, "抱歉，暂不开放此功能", Toast.LENGTH_SHORT).show();
                        break;
                    case "提醒":
                        Toast.makeText(SecondActivity.this, "抱歉，暂不开放此功能", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                }
            }
        });
    }

        public void initSecond(){
          Second date = new Second("到期日期",R.mipmap.ic_rili);
            secondList.add(date);
            Second priority = new Second("优先级",R.mipmap.ic_hongqi);
            secondList.add(priority);
            Second note = new Second("标签",R.mipmap.ic_biaoqian);
            secondList.add(note);
            Second cheif = new Second("次级任务",R.mipmap.ic_santiaoxian1);
            secondList.add(cheif);
            Second pinglun = new Second("评论",R.mipmap.ic_pinglun);
            secondList.add(pinglun);
            Second tixing = new Second("提醒",R.mipmap.ic_tixing);
            secondList.add(tixing);
        }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.example) { //noinspection SimplifiableIfStatement
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_second,menu);
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_third_priority,menu);

        super.onCreateContextMenu(menu,v,menuInfo);
    }
//    public boolean onContextItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case R.id.four:
//                String four = "优先级 4";
//                Intent intent = new Intent();
//                intent.putExtra("four",four);
//                setResult(RESULT_OK,intent);
//                finish();
//                break;
//            default:
//        }
//        return super.onContextItemSelected(item);
//    }
//    public void onContextMenuClosed(Menu menu){
//        super.onContextMenuClosed(menu);
//    }
}

package cn.wujing.nine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.wujing.nine.adapter.TestAdapter;

public class MainActivity extends AppCompatActivity {
    ListView testlistView;
    TestAdapter adapter;
    Map<Integer,ArrayList> map=new HashMap<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setlist();
        initView();
    }

    private void initView() {
        testlistView = (ListView) findViewById(R.id.test_List);
        adapter=new TestAdapter(this,map);
        testlistView.setAdapter(adapter);
    }

    public void setlist(){
        ArrayList<String> list1=new ArrayList();
        String[]img1=getResources().getStringArray(R.array.img1);
        for(int i=0; i<img1.length; i++){
            list1.add(img1[i]);
        }
        map.put(0,list1);
        ArrayList<String> list2=new ArrayList();
        String[]img2=getResources().getStringArray(R.array.img2);
        for(int i=0; i<img2.length; i++){
            list2.add(img2[i]);
        }
        map.put(1,list2);
        ArrayList<String> list3=new ArrayList();
        String[]img3=getResources().getStringArray(R.array.img3);
        for(int i=0; i<img3.length; i++){
            list3.add(img3[i]);
        }
        map.put(2,list3);
        ArrayList<String> list4=new ArrayList();
        String[]img4=getResources().getStringArray(R.array.img4);
        for(int i=0; i<img4.length; i++){
            list4.add(img4[i]);
        }
        map.put(3,list4);
        Log.v("test",map.toString());
    }
}

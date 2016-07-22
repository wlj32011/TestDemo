package cn.boc.testdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private  TextView textView;
    MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        final String phone  = getIntent().getExtras().getString("phone");

        textView = (TextView) findViewById(R.id.phone);
        textView.setText(phone);

        //初始化控件
        RecyclerView list = (RecyclerView) findViewById(R.id.list);
        //设置显示方式-线性列表方式展示
        list.setLayoutManager(new LinearLayoutManager(this));

        //初始化适配器
        MyAdapter myAdapter = new MyAdapter(this,initTestData());

        //RecyclerView设置适配器
        list.setAdapter(myAdapter);



        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("send_action");
                intent.putExtra("content",phone+"广播");
                sendBroadcast(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(myReceiver == null){
            myReceiver = new MyReceiver();
        }
        IntentFilter intentFilter = new IntentFilter("send_action");

        registerReceiver(myReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(myReceiver != null)
            unregisterReceiver(myReceiver);
    }

    class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("send_action")){
                String content = intent.getExtras().getString("content");
                textView.setText(content);
            }
        }
    }

    /**
     * 初始化一组测试数据
     *
     * @return 测试数据List
     */
    private List<HashMap<String,String>> initTestData(){

        List<HashMap<String,String>> dataList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            HashMap<String,String> map = new HashMap<>();
            map.put("content","这是一条测试内容"+i);
            dataList.add(map);
        }

        return  dataList;
    }
}

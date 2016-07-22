package cn.boc.testdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wanglj on 16/7/21.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{

    private Context context;
    private List<HashMap<String,String>> dataList;


    /**
     * 构造函数
     *
     * @param context 上下文对象
     * @param dataList 数据源
     */
    public MyAdapter(Context context, List<HashMap<String,String>> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //初始化布局文件
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        //初始化MyHolder,将itemview传入
        MyHolder myHolder = new MyHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        //通过position拿到当前item显示的数据源
        HashMap<String,String> itemData = dataList.get(position);

        //绑定view的显示内容
        holder.textView.setText(itemData.get("content"));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item click", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {//List显示itemview的数量
        return dataList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public MyHolder(View itemView) {
            super(itemView);
            //从itemView里面找出对应的子控件
            textView = (TextView)itemView.findViewById(R.id.textview);
            imageView = (ImageView)itemView.findViewById(R.id.imageview);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.layout);
        }
    }
}

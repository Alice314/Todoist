package com.wusui.todoist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fg on 2016/2/21.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private Context mContext;
    private List<String> mDatas;
    public MainAdapter(Context context, List<String> mDatas){
        mContext = context;
        this.mDatas =mDatas;
    }
    @Override//视图的问题
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)//（在哪里创建，创建什么类型的view)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.item_first, parent,//把holder给new出来
                false));
        return holder;
    }



    @Override
    public void onBindViewHolder( final MyViewHolder holder,final int position)//（绑定到哪里，绑什么——数据的实例）
    {
        holder.tv.setText(mDatas.get(position));
        if (mOnItemClickListener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();//Returns the position of the ViewHolder in terms of the latest layout pass.
                    mOnItemClickListener.onItemClick(holder.itemView,pos);
                }
            });
        }
    }
    public int getItemCount()
    {
        return mDatas.size();
    }

    class MyViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder
    {

        TextView tv;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.text_view);
        }
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
    private OnItemClickListener mOnItemClickListener;

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
}

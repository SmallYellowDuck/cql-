package com.bawei.chengqianlang0407;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 作者:程千浪
 * .时间：2017/4/7 21:08
 * 类用途：
 */

public class Mybase extends BaseAdapter {
    private List<Mybean.ListBean> list;
    private Context context;

    public Mybase(Context context, List<Mybean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            vh=new ViewHolder();
            convertView=convertView.inflate(context,R.layout.listview,null);
            vh.tv1= (TextView) convertView.findViewById(R.id.lvtv);
            vh.tv2= (TextView) convertView.findViewById(R.id.lvtv2);
            convertView.setTag(vh);
        }else{
            vh= (ViewHolder) convertView.getTag();
        }
        vh.tv1.setText(list.get(position).getSite_name());
        vh.tv2.setText(list.get(position).getAddress());
        return convertView;
    }
    class ViewHolder{
        TextView tv1,tv2;
    }
}

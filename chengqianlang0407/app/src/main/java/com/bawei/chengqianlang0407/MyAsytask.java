package com.bawei.chengqianlang0407;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * 作者:程千浪
 * .时间：2017/4/7 20:51
 * 类用途：
 */

public class MyAsytask extends AsyncTask<String,Integer,String> {
    private HttpURLConnection connect;
    private Context context;
    private ListView lv;
    private List<Mybean.ListBean> mList;
    private Mybase mMybase;

    public MyAsytask(Context context, ListView lv) {
        this.context = context;
        this.lv = lv;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            URL path = new URL(params[0]);
            connect = (HttpURLConnection) path.openConnection();
            connect.setRequestMethod("GET");
            connect.setReadTimeout(8000);
            connect.setConnectTimeout(8000);
            if (connect.getResponseCode()==200){
                InputStream inputStream = connect.getInputStream();
                String json = StreamtoStr(inputStream);
                return json;
            }else {
                return "gg";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connect!= null) {
                connect.disconnect();
            }}

        return "gg";


    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s.equals("gg")){
            Toast.makeText(context,"你网络有问题",Toast.LENGTH_SHORT).show();
        }else{
            Mybean mybean = (Mybean) new MyGsonUtils(s, Mybean.class).jsonToGson();
            mList = mybean.getList();
            mMybase = new Mybase(context, mList);
            lv.setAdapter(mMybase);
           lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
               @Override
               public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   Toast.makeText(context,"我改一下看看",Toast.LENGTH_SHORT).show();
               }
           });
            lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    mList.remove(position);
                    mMybase.notifyDataSetChanged();
                    return true;
                }
            });
        }

    }

    private String StreamtoStr(InputStream inputStream){
        StringBuffer sb = new StringBuffer();
        String str=null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            while ((str=reader.readLine())!=null){
                sb.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}

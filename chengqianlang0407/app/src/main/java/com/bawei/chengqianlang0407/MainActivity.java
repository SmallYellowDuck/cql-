package com.bawei.chengqianlang0407;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.lv);
        MyAsytask myAsytask = new MyAsytask(MainActivity.this, lv);
        myAsytask.execute(Mypath.url);
    }
}

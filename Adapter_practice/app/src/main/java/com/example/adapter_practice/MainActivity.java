package com.example.adapter_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("리스트뷰 테스트");

        final String[] mid = {"셜록홈즈","프렌즈","로스트","글리","스킨스","모던패밀리"};

        ListView list = (ListView) findViewById(R.id.listView1);

        // ArrayAdapter<String>형의 변수를 선언하고, 리스트뷰의 모양과 내용을 미리 만든 String[] mid...배열로 채운다.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mid);

        //생성한 어레이어댑터를 리스트뷰 변수에 적용시킴
        list.setAdapter(adapter);


        //리스트뷰의 항목을 클릭했을 때 동작하는 리스너 정의
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getApplicationContext(),mid[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}



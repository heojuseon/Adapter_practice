package com.example.adapter_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //ArrayList 생성
        final ArrayList<String> midList = new ArrayList<String>();
        ListView list = (ListView)findViewById(R.id.listView1);

        //ArrayAdapter<String>형의 변수를 선언하고, 위에서 생성한 midList 배열로 채운다.
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,midList);

        //생성한 어레이어댑터를 리스트뷰 변수에 적용시킴
        list.setAdapter(adapter);

        //edttext로 입력받은값
        final EditText edtItem = (EditText) findViewById(R.id.edtItem);


        //입력한값 버튼 클릭시 리스트 저장
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                midList.add(edtItem.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        //추가된 항목 길게 클릭시 삭제되는 메소드드
       list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                midList.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
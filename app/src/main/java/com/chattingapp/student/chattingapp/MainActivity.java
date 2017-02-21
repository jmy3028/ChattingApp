package com.chattingapp.student.chattingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.start_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_button:
                Intent intent = new Intent(this,NewChattingActivity.class);
                startActivity(intent);
                break;

        }
    }

//    private void showAlertDialog() {
//
//        // 생성자에 Context 를 넘기는데 getApplicationContext 말고 Activity.this
//        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        // 연결할 레이아웃을 설정
//        View innerview = getLayoutInflater().inflate(R.layout.choose_dialog, null);
//        // 레이아웃 셋팅
//        builder.setView(innerview);
//        // 다른 곳을 터치하거나 뒤로가기를 눌렀을 때 팝업이 꺼지는 것 방지
//        builder.setCancelable(false);
//
//        final CheckBox manCheckBox = (CheckBox) findViewById(R.id.man_checkbox);
//        final CheckBox womanCheckBox = (CheckBox) findViewById(R.id.woman_checkbox);
//        final CheckBox man2CheckBox = (CheckBox) findViewById(R.id.man2_checkbox);
//        final CheckBox woman2CheckBox = (CheckBox) findViewById(R.id.woman2_checkbox);
//        final CheckBox noCheckBox = (CheckBox) findViewById(R.id.no_checkbox);
//
//        manCheckBox.setOnCheckedChangeListener(this);
//        womanCheckBox.setOnCheckedChangeListener(this);
//        man2CheckBox.setOnCheckedChangeListener(this);
//        woman2CheckBox.setOnCheckedChangeListener(this);
//        noCheckBox.setOnCheckedChangeListener(this);
//
//        final AlertDialog dialog = builder.create();
//
//        dialog.show();
//        // 취소 버튼
//        builder.setNegativeButton("취속", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//
//        builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(MainActivity.this, ChattingFragment.class);
//                startActivity(intent);
//            }
//        });
//
//        builder.show();
//
//        // 확인버튼
//
//        setContentView(R.layout.activity_agree);
//
//
//    }
//
//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        switch (buttonView.getId()) {
//            case R.id.man_checkbox :
//            case R.id.woman_checkbox :
//            case R.id.man2_checkbox :
//            case R.id.woman2_checkbox :
//            case R.id.no_checkbox :
//        }
//    }
}

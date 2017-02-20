package com.chattingapp.student.chattingapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.app_start_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_start_button:
                showAlertDialog();
        }
    }

    private void showAlertDialog() {

        // 생성자에 Context 를 넘기는데 getApplicationContext 말고 Activity.this
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // 다른 곳을 터치하거나 뒤로가기를 눌렀을 때 팝업이 꺼지는 것 방지
        builder.setCancelable(false);
//        View view =
        View dialogButton = new View(getApplicationContext());

        final AlertDialog dialog = builder.create();

        // 확인버튼
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linearLayout = new LinearLayout(MainActivity.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                LinearLayout linearLayout1 = new LinearLayout(MainActivity.this);
                linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
                CheckBox male = new CheckBox(MainActivity.this);
                male.setText("남자");
                male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    }
                });
                CheckBox female = new CheckBox(MainActivity.this);
                female.setText("여자");
                female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    }
                });

//                String name, gender;
//                getSupportFragmentManager().beginTransaction().add().addToBackStack(null)
//                dialog.dismiss();
            }
        });

//        builder.setView(view)

        setContentView(R.layout.activity_agree);


    }


    public void onClick(View view) {

    }
}

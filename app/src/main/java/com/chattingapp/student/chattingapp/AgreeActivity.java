package com.chattingapp.student.chattingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class AgreeActivity extends AppCompatActivity {

    private TextView mAgreeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree);

        mAgreeText = (TextView) findViewById(R.id.agree_text);
        mAgreeText.setText("이 앱은 새로운 사람들을 사귀기 위한 목적으로 만들어진 앱입니다\n" +
                "그러나 대화내용 중 비속한 표현, 증오심 유발,유혈묘사, 성행위 등이 포함되어 있을 수 있습니다.\n" +
                "본인의 의사에 따라 개인정보가 노출이 될 수 있지만, 가급적 개인정보(전화번호,주민번호,계좌번호 등)\n" +
                "를 노출 하지 마시길 바랍니다.개인정보노출로 인한 사기에 주위하시기 바랍니다.\n" +
                "이 모든 사항에 동의를 하신다면 동의함을 눌러주시기 바랍니다.\n" +
                "동의를 원하지 않으신다면 동의하지 않음을 눌러주시기 바랍니다.");

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.no_button:
                break;
            case R.id.ok_button:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}

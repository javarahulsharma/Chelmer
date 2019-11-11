package com.palo.chelmer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScreenEight extends AppCompatActivity {
    Button next, back;
    @BindView(R.id.sourceOfFound)
    Spinner sourceOfFound;
    @BindView(R.id.work)
    Spinner work;
    @BindView(R.id.status)
    Spinner status;
    String[] sourceoffound = {"- Select -",
    "Salary","Business","Pension","Interest","Inheritance","Other"};
    String[] works = {"- Select -","Philippines","Overseas"};
    String[] statu = {"- Select -","I'm a U.S. citizen","Not a U.S. citizen but have U.S. indicia","Not U.S. citizen and without U.S. indicia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_eight);
        ButterKnife.bind(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sourceoffound);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceOfFound.setAdapter(aa);

        ArrayAdapter aaa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,works);
        aaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        work.setAdapter(aaa);


        ArrayAdapter aaaa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,statu);
        aaaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status.setAdapter(aaaa);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        back = (Button) findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next = (Button) findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScreenEight.this, ScreenNine.class);
                startActivity(intent);
            }
        });
        //make translucent statusBar on kitkat devices
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            MainActivity.setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            MainActivity.setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        // soft key bord not show oncreate
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

//    @OnClick({R.id.sourceOfFound, R.id.work, R.id.status})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.sourceOfFound:
//                break;
//            case R.id.work:
//                break;
//            case R.id.status:
//                break;
//        }
//    }
}

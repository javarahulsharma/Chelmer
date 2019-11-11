package com.palo.chelmer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.palo.chelmer.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScreenTherteen extends AppCompatActivity {
    Button next, back;
    @BindView(R.id.radioAvailableAnytime)
    RadioButton radioAvailableAnytime;
    @BindView(R.id.radioWillRequir)
    RadioButton radioWillRequir;
    @BindView(R.id.radioDoNotreq)
    RadioButton radioDoNotreq;
    @BindView(R.id.radioWillNot)
    RadioButton radioWillNot;
    @BindView(R.id.radioGroupThrteen)
    RadioGroup radioGroupThrteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_therteen);
        ButterKnife.bind(this);
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
                Intent intent = new Intent(ScreenTherteen.this, ScreenFourteen.class);
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

        radioGroupThrteen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == (R.id.radioAvailableAnytime)){
                    setDefa(radioAvailableAnytime);
                }else if (selectedId == (R.id.radioWillRequir)){
                    setDefa(radioWillRequir);

                }else if(selectedId == (R.id.radioDoNotreq)){
                    setDefa(radioDoNotreq);

                }else {
                    setDefa(radioWillNot);
                }
            }
        });
    }

    public void setDefa(RadioButton view)
    {
        radioAvailableAnytime.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioAvailableAnytime.setBackgroundResource(R.drawable.radiobtn);
        radioAvailableAnytime.setPadding(Utils.dpToPx(16), Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radioWillRequir.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioWillRequir.setBackgroundResource(R.drawable.radiobtn);
        radioWillRequir.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radioDoNotreq.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioDoNotreq.setBackgroundResource(R.drawable.radiobtn);
        radioDoNotreq.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radioWillNot.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioWillNot.setBackgroundResource(R.drawable.radiobtn);
        radioWillNot.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        view.setTextColor(getResources().getColor(R.color.white));
        view.setBackgroundResource(R.drawable.radiobtnblue);
        view.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
    }
}

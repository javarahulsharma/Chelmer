package com.palo.chelmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.palo.chelmer.utils.Utils;

public class ScreenEleven extends AppCompatActivity {
    Button next,back;
    RadioGroup radioGroup;
    RadioButton radbtnone,radbtntwo,radiothree,radiofour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_eleven);
        back = (Button) findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        next = (Button)findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScreenEleven.this,ScreenTweal.class);
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

        radioGroup = (RadioGroup)findViewById(R.id.radiogroupEleven);
        radbtnone = (RadioButton)findViewById(R.id.radioOne);
        radbtntwo = (RadioButton)findViewById(R.id.radioTwo);
        radiothree = (RadioButton)findViewById(R.id.radioThree);
        radiofour = (RadioButton)findViewById(R.id.radioFour);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == (R.id.radioOne)){
                    setDefa(radbtnone);
                }else if (selectedId == (R.id.radioTwo)){
                    setDefa(radbtntwo);

                }else if(selectedId == (R.id.radioThree)){
                    setDefa(radiothree);

                }else {
                    setDefa(radiofour);
                }
            }
        });

    }

    public void setDefa(RadioButton view)
    {
        radbtnone.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radbtnone.setBackgroundResource(R.drawable.radiobtn);
        radbtnone.setPadding(Utils.dpToPx(16), Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radbtntwo.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radbtntwo.setBackgroundResource(R.drawable.radiobtn);
        radbtntwo.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radiothree.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radiothree.setBackgroundResource(R.drawable.radiobtn);
        radiothree.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radiofour.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radiofour.setBackgroundResource(R.drawable.radiobtn);
        radiofour.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        view.setTextColor(getResources().getColor(R.color.white));
        view.setBackgroundResource(R.drawable.radiobtnblue);
        view.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
    }

}

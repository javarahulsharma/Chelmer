package com.palo.chelmer;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;


import com.palo.chelmer.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScreenFifteen extends AppCompatActivity {
    Button next, back;
    @BindView(R.id.radio_bank_deposite)
    CheckBox radioBankDeposite;
    @BindView(R.id.radio_time_deposite)
    CheckBox radioTimeDeposite;
    @BindView(R.id.radio_govt)
    CheckBox radioGovt;
    @BindView(R.id.radio_equlite)
    CheckBox radioEqulite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_fifteen);
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
                Intent intent = new Intent(ScreenFifteen.this, Screensixteen.class);
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
        
        radioBankDeposite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radioBankDeposite.isSelected()){
                    radioBankDeposite.setTextColor(getResources().getColor(R.color.LIGHTblue));
                    //  radioBankDeposite.setBackgroundResource(R.drawable.radiobtnblue);
                    radioBankDeposite.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
                }else{
                    radioBankDeposite.setTextColor(getResources().getColor(R.color.white));
                    // radioBankDeposite.setBackgroundResource(R.drawable.radiobtn);
                    radioBankDeposite.setPadding(Utils.dpToPx(16), Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
                }

            }
        });

        radioTimeDeposite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radioTimeDeposite.isSelected()){
                    radioTimeDeposite.setTextColor(getResources().getColor(R.color.LIGHTblue));
                    //  radioBankDeposite.setBackgroundResource(R.drawable.radiobtnblue);
                    radioTimeDeposite.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
                }else{
                    radioTimeDeposite.setTextColor(getResources().getColor(R.color.white));
                    // radioBankDeposite.setBackgroundResource(R.drawable.radiobtn);
                    radioTimeDeposite.setPadding(Utils.dpToPx(16), Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
                }

            }
        });

        radioGovt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radioGovt.isSelected()){
                    radioGovt.setTextColor(getResources().getColor(R.color.LIGHTblue));
                    //  radioBankDeposite.setBackgroundResource(R.drawable.radiobtnblue);
                    radioGovt.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
                }else{
                    radioGovt.setTextColor(getResources().getColor(R.color.white));
                    // radioBankDeposite.setBackgroundResource(R.drawable.radiobtn);
                    radioGovt.setPadding(Utils.dpToPx(16), Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
                }

            }
        });

        radioEqulite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (radioEqulite.isSelected()){
                    radioEqulite.setTextColor(getResources().getColor(R.color.LIGHTblue));
                    //  radioBankDeposite.setBackgroundResource(R.drawable.radiobtnblue);
                    radioEqulite.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
                }else{
                    radioEqulite.setTextColor(getResources().getColor(R.color.white));
                    // radioBankDeposite.setBackgroundResource(R.drawable.radiobtn);
                    radioEqulite.setPadding(Utils.dpToPx(16), Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
                }

            }
        });

//        radioBankDeposite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (radioBankDeposite.isSelected()){
//                    radioBankDeposite.setTextColor(getResources().getColor(R.color.white));
//                    radioBankDeposite.setBackgroundResource(R.drawable.radiobtnblue);
//                    radioBankDeposite.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
//                }else {
//                    radioBankDeposite.setTextColor(getResources().getColor(R.color.LIGHTblue));
//                    radioBankDeposite.setBackgroundResource(R.drawable.radiobtn);
//                    radioBankDeposite.setPadding(Utils.dpToPx(16), Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
//                }
//            }
//        });


//        radioGroupFiveteen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                int selectedId = radioGroup.getCheckedRadioButtonId();
//
//                if (selectedId == (R.id.radio_bank_deposite)){
//                    setDefa(radioBankDeposite);
//                }else if (selectedId == (R.id.radio_time_deposite)){
//                    setDefa(radioTimeDeposite);
//
//                }else if(selectedId == (R.id.radio_govt)){
//                    setDefa(radioGovt);
//
//                }else {
//                    setDefa(radioEqulite);
//                }
//            }
//        });
    }

//    public void setDefa(RadioButton view)
//    {
//        radioBankDeposite.setTextColor(getResources().getColor(R.color.LIGHTblue));
//        radioBankDeposite.setBackgroundResource(R.drawable.radiobtn);
//        radioBankDeposite.setPadding(Utils.dpToPx(16), Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
//
//        radioTimeDeposite.setTextColor(getResources().getColor(R.color.LIGHTblue));
//        radioTimeDeposite.setBackgroundResource(R.drawable.radiobtn);
//        radioTimeDeposite.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
//
//        radioGovt.setTextColor(getResources().getColor(R.color.LIGHTblue));
//        radioGovt.setBackgroundResource(R.drawable.radiobtn);
//        radioGovt.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
//
//        radioEqulite.setTextColor(getResources().getColor(R.color.LIGHTblue));
//        radioEqulite.setBackgroundResource(R.drawable.radiobtn);
//        radioEqulite.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
//
//        view.setTextColor(getResources().getColor(R.color.white));
//        view.setBackgroundResource(R.drawable.radiobtnblue);
//        view.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
//    }
}

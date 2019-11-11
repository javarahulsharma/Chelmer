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

public class ScreenTweal extends AppCompatActivity {
    Button next,back;
    RadioGroup radioGroup;
    RadioButton radioButtonOne,radioButtonTwo,radioButtonthree,radioButtonFour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_tweal);
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
                Intent intent = new Intent(ScreenTweal.this,ScreenTherteen.class);
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


        radioGroup = (RadioGroup)findViewById(R.id.radiotweal);
        radioButtonOne = (RadioButton)findViewById(R.id.radioOne);
        radioButtonTwo = (RadioButton)findViewById(R.id.radioTwo);
        radioButtonthree = (RadioButton)findViewById(R.id.radioThree);
        radioButtonFour = (RadioButton)findViewById(R.id.radioFour);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == (R.id.radioOne)){
                    setDefa(radioButtonOne);
                }else if (selectedId == (R.id.radioTwo)){
                    setDefa(radioButtonTwo);

                }else if(selectedId == (R.id.radioThree)){
                    setDefa(radioButtonthree);

                }else {
                    setDefa(radioButtonFour);
                }
            }
        });
    }

    public void setDefa(RadioButton view)
    {
        radioButtonOne.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioButtonOne.setBackgroundResource(R.drawable.radiobtn);
        radioButtonOne.setPadding(Utils.dpToPx(16), Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radioButtonTwo.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioButtonTwo.setBackgroundResource(R.drawable.radiobtn);
        radioButtonTwo.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radioButtonthree.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioButtonthree.setBackgroundResource(R.drawable.radiobtn);
        radioButtonthree.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radioButtonFour.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioButtonFour.setBackgroundResource(R.drawable.radiobtn);
        radioButtonFour.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        view.setTextColor(getResources().getColor(R.color.white));
        view.setBackgroundResource(R.drawable.radiobtnblue);
        view.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
    }

}

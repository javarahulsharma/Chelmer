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

public class ScreenFourteen extends AppCompatActivity {
    Button next, back;
    @BindView(R.id.radio_principal)
    RadioButton radioPrincipal;
    @BindView(R.id.radio_privent)
    RadioButton radioPrivent;
    @BindView(R.id.radio_can_tolerate)
    RadioButton radioCanTolerate;
    @BindView(R.id.radio_tolerate_substantial)
    RadioButton radioTolerateSubstantial;
    @BindView(R.id.radio_group_fourteen)
    RadioGroup radioGroupFourteen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_fourteen);
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
                Intent intent = new Intent(ScreenFourteen.this, ScreenFifteen.class);
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

        radioGroupFourteen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == (R.id.radio_principal)){
                    setDefa(radioPrincipal);
                }else if (selectedId == (R.id.radio_privent)){
                    setDefa(radioPrivent);

                }else if(selectedId == (R.id.radio_can_tolerate)){
                    setDefa(radioCanTolerate);

                }else {
                    setDefa(radioTolerateSubstantial);
                }
            }
        });
    }

    public void setDefa(RadioButton view)
    {
        radioPrincipal.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioPrincipal.setBackgroundResource(R.drawable.radiobtn);
        radioPrincipal.setPadding(Utils.dpToPx(16), Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radioPrivent.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioPrivent.setBackgroundResource(R.drawable.radiobtn);
        radioPrivent.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radioCanTolerate.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioCanTolerate.setBackgroundResource(R.drawable.radiobtn);
        radioCanTolerate.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        radioTolerateSubstantial.setTextColor(getResources().getColor(R.color.LIGHTblue));
        radioTolerateSubstantial.setBackgroundResource(R.drawable.radiobtn);
        radioTolerateSubstantial.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));

        view.setTextColor(getResources().getColor(R.color.white));
        view.setBackgroundResource(R.drawable.radiobtnblue);
        view.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
    }
}

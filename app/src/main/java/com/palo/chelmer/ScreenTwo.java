package com.palo.chelmer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class ScreenTwo extends AppCompatActivity {
    TextView termText;
    Button next,back;
   // CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_two);
        termText = (TextView)findViewById(R.id.textTerm);
      //  cardView = (CardView)findViewById(R.id.card);

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

        //Animation slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
            //    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
             //   1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
      //  slide.setDuration(500);
     //   slide.setFillAfter(true);
      //  slide.setFillEnabled(true);
      //  cardView.startAnimation(slide);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            termText.setText(Html.fromHtml(getResources().getString(R.string.termTwo),Html.FROM_HTML_MODE_LEGACY));
        }

        else
        {
            termText.setText(Html.fromHtml(getResources().getString(R.string.termTwo)));
        }
        next = (Button)findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScreenTwo.this,Screenthree.class);
                startActivity(intent);
            }
        });
        back = (Button) findViewById(R.id.backBtn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

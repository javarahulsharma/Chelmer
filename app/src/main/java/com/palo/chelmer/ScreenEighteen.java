package com.palo.chelmer;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.kyanogen.signatureview.SignatureView;
import com.palo.chelmer.utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScreenEighteen extends AppCompatActivity {
    Button next, back;
    @BindView(R.id.radioDigitalSig)
    RadioButton radioDigitalSig;
    @BindView(R.id.signature_view)
    SignatureView signatureView;
    @BindView(R.id.clear)
    Button clear;
    @BindView(R.id.button2)
    Button button2;

//    Button btn_get_sign, mClear, mGetSign, mCancel;
//    File file;
//    Dialog dialog;
//    LinearLayout mContent;
//    View view;
//    signature mSignature;
//    Bitmap bitmap;

    // Creating Separate Directory for saving Generated Images
    String DIRECTORY = Environment.getExternalStorageDirectory().getPath() + "/DigitSign/";
    String pic_name = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
    String StoredPath = DIRECTORY + pic_name + ".png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_eighteen);
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
                Intent intent = new Intent(ScreenEighteen.this, ScreenNinteen.class);
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


        radioDigitalSig.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!radioDigitalSig.isSelected()){
                    signatureView.setVisibility(View.VISIBLE);
                    clear.setVisibility(View.VISIBLE);
                    radioDigitalSig.setTextColor(getResources().getColor(R.color.LIGHTblue));
                    radioDigitalSig.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
                }else {
                    signatureView.setVisibility(View.GONE);
                    clear.setVisibility(View.GONE);
                    radioDigitalSig.setTextColor(getResources().getColor(R.color.white));
                    radioDigitalSig.setPadding(Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16),Utils.dpToPx(16));
                }
            }
        });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signatureView.clearCanvas();
            }
        });

    }

//    public void dialog_action() {
//        mContent = (LinearLayout) dialog.findViewById(R.id.linearLayout);
//        mSignature = new signature(getApplicationContext(), null);
//        mSignature.setBackgroundColor(Color.WHITE);
//        // Dynamically generating Layout through java code
//        mContent.addView(mSignature, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//        mClear = (Button) dialog.findViewById(R.id.clear);
//        mGetSign = (Button) dialog.findViewById(R.id.getsign);
//        mGetSign.setEnabled(false);
//        mCancel = (Button) dialog.findViewById(R.id.cancel);
//        view = mContent;
//
//        mClear.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Log.v("log_tag", "Panel Cleared");
//                mSignature.clear();
//                mGetSign.setEnabled(false);
//            }
//        });
//
//        mGetSign.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//
//                Log.v("log_tag", "Panel Saved");
//                view.setDrawingCacheEnabled(true);
//                mSignature.save(view, StoredPath);
//                dialog.dismiss();
//                Toast.makeText(getApplicationContext(), "Successfully Saved", Toast.LENGTH_SHORT).show();
//                // Calling the same class
//                recreate();
//
//            }
//        });
//
//        mCancel.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Log.v("log_tag", "Panel Canceled");
//                dialog.dismiss();
//                // Calling the same class
//                recreate();
//            }
//        });
//        dialog.show();
//    }

//    public class signature extends View {
//
//        private static final float STROKE_WIDTH = 5f;
//        private static final float HALF_STROKE_WIDTH = STROKE_WIDTH / 2;
//        private Paint paint = new Paint();
//        private Path path = new Path();
//
//        private float lastTouchX;
//        private float lastTouchY;
//        private final RectF dirtyRect = new RectF();
//
//        public signature(Context context, AttributeSet attrs) {
//            super(context, attrs);
//            paint.setAntiAlias(true);
//            paint.setColor(Color.BLACK);
//            paint.setStyle(Paint.Style.STROKE);
//            paint.setStrokeJoin(Paint.Join.ROUND);
//            paint.setStrokeWidth(STROKE_WIDTH);
//        }
//
//        public void save(View v, String StoredPath) {
//            Log.v("log_tag", "Width: " + v.getWidth());
//            Log.v("log_tag", "Height: " + v.getHeight());
//            if (bitmap == null) {
//                bitmap = Bitmap.createBitmap(mContent.getWidth(), mContent.getHeight(), Bitmap.Config.RGB_565);
//            }
//            Canvas canvas = new Canvas(bitmap);
//            try {
//                // Output the file
//                FileOutputStream mFileOutStream = new FileOutputStream(StoredPath);
//                v.draw(canvas);
//
//                // Convert the output file to Image such as .png
//                bitmap.compress(Bitmap.CompressFormat.PNG, 90, mFileOutStream);
//                mFileOutStream.flush();
//                mFileOutStream.close();
//
//            } catch (Exception e) {
//                Log.v("log_tag", e.toString());
//            }
//
//        }
//
//        public void clear() {
//            path.reset();
//            invalidate();
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas) {
//            canvas.drawPath(path, paint);
//        }
//
//        @Override
//        public boolean onTouchEvent(MotionEvent event) {
//            float eventX = event.getX();
//            float eventY = event.getY();
//            mGetSign.setEnabled(true);
//
//            switch (event.getAction()) {
//                case MotionEvent.ACTION_DOWN:
//                    path.moveTo(eventX, eventY);
//                    lastTouchX = eventX;
//                    lastTouchY = eventY;
//                    return true;
//
//                case MotionEvent.ACTION_MOVE:
//
//                case MotionEvent.ACTION_UP:
//
//                    resetDirtyRect(eventX, eventY);
//                    int historySize = event.getHistorySize();
//                    for (int i = 0; i < historySize; i++) {
//                        float historicalX = event.getHistoricalX(i);
//                        float historicalY = event.getHistoricalY(i);
//                        expandDirtyRect(historicalX, historicalY);
//                        path.lineTo(historicalX, historicalY);
//                    }
//                    path.lineTo(eventX, eventY);
//                    break;
//
//                default:
//                    debug("Ignored touch event: " + event.toString());
//                    return false;
//            }
//
//            invalidate((int) (dirtyRect.left - HALF_STROKE_WIDTH),
//                    (int) (dirtyRect.top - HALF_STROKE_WIDTH),
//                    (int) (dirtyRect.right + HALF_STROKE_WIDTH),
//                    (int) (dirtyRect.bottom + HALF_STROKE_WIDTH));
//
//            lastTouchX = eventX;
//            lastTouchY = eventY;
//
//            return true;
//        }
//
//        private void debug(String string) {
//
//            Log.v("log_tag", string);
//
//        }
//
//        private void expandDirtyRect(float historicalX, float historicalY) {
//            if (historicalX < dirtyRect.left) {
//                dirtyRect.left = historicalX;
//            } else if (historicalX > dirtyRect.right) {
//                dirtyRect.right = historicalX;
//            }
//
//            if (historicalY < dirtyRect.top) {
//                dirtyRect.top = historicalY;
//            } else if (historicalY > dirtyRect.bottom) {
//                dirtyRect.bottom = historicalY;
//            }
//        }
//
//        private void resetDirtyRect(float eventX, float eventY) {
//            dirtyRect.left = Math.min(lastTouchX, eventX);
//            dirtyRect.right = Math.max(lastTouchX, eventX);
//            dirtyRect.top = Math.min(lastTouchY, eventY);
//            dirtyRect.bottom = Math.max(lastTouchY, eventY);
//        }
//    }

}

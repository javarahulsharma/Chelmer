package com.palo.chelmer;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.palo.chelmer.utils.Utils;

import java.net.URISyntaxException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScreenSix extends AppCompatActivity {
    Button next, back;
    RadioGroup radioGroup;
    @BindView(R.id.attachment_six)
    Button attachmentSix;
    @BindView(R.id.addressDropdown)
    Spinner addressDropdown;
    @BindView(R.id.backBtn)
    Button backBtn;
    @BindView(R.id.button2)
    Button button2;
    private RadioButton radbtnone, radbtntwo;
    private static final int FILE_SELECT_CODE = 0;
    String[] type = {"LICENSE", "PASSPORT" , "DRIVER’S" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_six);
        ButterKnife.bind(this);
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

        next = (Button) findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScreenSix.this, ScreenSeven.class);
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
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupSixP);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                radbtnone = (RadioButton) findViewById(R.id.radbtnOne);
                radbtntwo = (RadioButton) findViewById(R.id.radbtnTwo);
                if (selectedId == (R.id.radbtnOne)) {
                    radbtnone.setTextColor(getResources().getColor(R.color.white));
                    radbtnone.setBackgroundResource(R.drawable.radiobtnblue);
                    radbtntwo.setTextColor(getResources().getColor(R.color.LIGHTblue));
                    radbtntwo.setBackgroundResource(R.drawable.radiobtn);
                    radbtnone.setPadding(Utils.dpToPx(16), Utils.dpToPx(16), Utils.dpToPx(16), Utils.dpToPx(16));
                    radbtntwo.setPadding(Utils.dpToPx(16), Utils.dpToPx(16), Utils.dpToPx(16), Utils.dpToPx(16));
                } else {

                    radbtntwo.setTextColor(getResources().getColor(R.color.white));
                    radbtntwo.setBackgroundResource(R.drawable.radiobtnblue);
                    radbtnone.setTextColor(getResources().getColor(R.color.LIGHTblue));
                    radbtnone.setBackgroundResource(R.drawable.radiobtn);
                    radbtnone.setPadding(Utils.dpToPx(16), Utils.dpToPx(16), Utils.dpToPx(16), Utils.dpToPx(16));
                    radbtntwo.setPadding(Utils.dpToPx(16), Utils.dpToPx(16), Utils.dpToPx(16), Utils.dpToPx(16));
                }
            }
        });


        attachmentSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFileChooser();
            }
        });


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,type);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        addressDropdown.setAdapter(aa);

    }


    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    FILE_SELECT_CODE);
        } catch (ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file
                    Uri uri = data.getData();
                    System.out.println("File Uri: " + uri.toString());
                    // Get the path
                    try {
                        String path = getPath(this, uri);
                        System.out.println("File Path: " + path);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    // Get the file instance
                    // File file = new File(path);
                    // Initiate the upload
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public static String getPath(Context context, Uri uri) throws URISyntaxException {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = {"_data"};
            Cursor cursor = null;

            try {
                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }
            } catch (Exception e) {
                // Eat it
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }
}

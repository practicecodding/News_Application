package com.hamidul.newsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Locale;

public class NewsView extends AppCompatActivity {
    public static Bitmap image = null;
    public static String TITLE = "";
    public static String DES = "";
    ImageView imageCover;
    TextView tvTitle,tvDes;
    FloatingActionButton fab;
    TextToSpeech textToSpeech;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        getWindow().setStatusBarColor(Color.WHITE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.news_view);
        imageCover = findViewById(R.id.imageCover);
        tvTitle = findViewById(R.id.tvTitle);
        tvDes = findViewById(R.id.tvDes);
        fab = findViewById(R.id.fab);
        textToSpeech = new TextToSpeech(NewsView.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){
                    int result = textToSpeech.setLanguage(Locale.ENGLISH);

                    if (result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("tts","Language Not Supported");
                    } else {
                        fab.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        tvTitle.setText(TITLE);
        tvDes.setText(DES);

        if (image!=null) imageCover.setImageBitmap(image);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvDes.getText().toString();
                textToSpeech.speak(DES,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });

    }

    private void toastMessage (String text){
        if (toast!=null) toast.cancel();
        toast = Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech!=null) textToSpeech.stop();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        if (textToSpeech!=null) textToSpeech.stop();
        super.onPause();
    }
}
package com.example.pianotrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int frameCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void upArrowClick (View view) {
        TextView frameCounter = findViewById(R.id.frameCounter);
        frameCount = frameCount + 1;
        frameCounter.setText(String.valueOf(frameCount));
    }

    public void downArrowClick (View view) {
        TextView frameCounter = findViewById(R.id.frameCounter);
        if (frameCount >= 1) {
            frameCount = frameCount - 1;
        }
        frameCounter.setText(String.valueOf(frameCount));
    }

    public void InPlayMode (View view) {
        Toast.makeText(this, "Entered Play Mode", Toast.LENGTH_SHORT).show();
        TextView titleView = findViewById(R.id.titleView);
        titleView.setVisibility(View.VISIBLE);
    }
}

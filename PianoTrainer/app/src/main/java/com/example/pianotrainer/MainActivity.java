package com.example.pianotrainer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.drawable.ColorDrawable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int frameCount = 1;
    private Spinner editSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editSpeed = findViewById(R.id.editSpeed);

        ArrayList<Double> speedOptions = new ArrayList<>();
        speedOptions.add(0.25);
        speedOptions.add(0.50);
        speedOptions.add(0.75);
        speedOptions.add(1.00);
        speedOptions.add(1.25);
        speedOptions.add(1.50);
        speedOptions.add(1.75);
        speedOptions.add(2.00);
        ArrayAdapter<Double> speedAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                speedOptions
        );

        editSpeed.setAdapter(speedAdapter);
        editSpeed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                double speed = speedOptions.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void ConfirmTitle(View view){
        EditText editTitle = findViewById(R.id.editTitle);
        TextView titleView = findViewById(R.id.titleView);
        titleView.setText("Now Playing: " + editTitle.getText().toString());
    }
    
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _whiteKey (View view) {
        Button key = (Button) findViewById(view.getId());
        ColorDrawable drawable = (ColorDrawable) key.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.light_blue)){
            key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
            key.setBackgroundColor(getResources().getColor(R.color.light_purple));
        }
        else {
            key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
            key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _blackKey (View view) {
        Button key = (Button) findViewById(view.getId());
        ColorDrawable drawable = (ColorDrawable) key.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
            key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
        }
        else {
            key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }

    public void upArrowClick (View view) {
        TextView frameCounter = findViewById(R.id.frameCounter);
        frameCount = frameCount + 1;
        frameCounter.setText(String.valueOf(frameCount));
    }

    public void downArrowClick (View view) {
        TextView frameCounter = findViewById(R.id.frameCounter);
        if (frameCount > 1) {
            frameCount = frameCount - 1;
        }
        frameCounter.setText(String.valueOf(frameCount));
    }

    public void InPlayMode () {
        Toast.makeText(this, "Entered Play Mode", Toast.LENGTH_SHORT).show();
        ImageView pianoLines = findViewById(R.id.pianoLines);
        TextView titleView = findViewById(R.id.titleView);
        TextView editTitle = findViewById(R.id.editTitle);
        Spinner editSpeed = (Spinner) findViewById(R.id.editSpeed);
        TextView speedText = findViewById(R.id.speedText);
        Button confirm_title_button = findViewById(R.id.confirm_title_button);
        Button importButton = findViewById(R.id.importButton);
        Button playButton = findViewById(R.id.playButton);
        pianoLines.setVisibility(View.VISIBLE);
        titleView.setVisibility(View.VISIBLE);
        editTitle.setVisibility(View.INVISIBLE);
        editSpeed.setVisibility(View.VISIBLE);
        speedText.setVisibility(View.VISIBLE);
        confirm_title_button.setVisibility(View.INVISIBLE);
        importButton.setVisibility(View.VISIBLE);
        playButton.setVisibility(View.VISIBLE);
    }

    public void InEditMode () {
        Toast.makeText(this, "Entered Edit Mode", Toast.LENGTH_SHORT).show();
        ImageView pianoLines = findViewById(R.id.pianoLines);
        TextView titleView = findViewById(R.id.titleView);
        TextView editTitle = findViewById(R.id.editTitle);
        Spinner editSpeed = (Spinner) findViewById(R.id.editSpeed);
        TextView speedText = findViewById(R.id.speedText);
        Button confirm_title_button = findViewById(R.id.confirm_title_button);
        Button importButton = findViewById(R.id.importButton);
        Button playButton = findViewById(R.id.playButton);
        pianoLines.setVisibility(View.INVISIBLE);
        titleView.setVisibility(View.INVISIBLE);
        editTitle.setVisibility(View.VISIBLE);
        editSpeed.setVisibility(View.INVISIBLE);
        speedText.setVisibility(View.INVISIBLE);
        confirm_title_button.setVisibility(View.VISIBLE);
        importButton.setVisibility(View.INVISIBLE);
        playButton.setVisibility(View.INVISIBLE);
    }

    //adding this will enable the changes made in main_menu.xml to be visible
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.editMode:
                InEditMode();
                return true;
            case R.id.playMode:
                InPlayMode();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

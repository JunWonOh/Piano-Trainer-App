package com.example.pianotrainer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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
    private ArrayList<ArrayList<Integer>> frame = new ArrayList<ArrayList<Integer>>();


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
        ArrayList<Integer> keyCombinations = new ArrayList<>();
        ViewGroup blackKeyLayout = (ViewGroup)findViewById(R.id.constLayout);
        for (int i = 0; i < blackKeyLayout.getChildCount(); i++){
            View key = blackKeyLayout.getChildAt(i);
            int color = 0;
            ColorDrawable drawable = new ColorDrawable();
            if (key instanceof Button){
                Button button = (Button) key;
                switch(key.getId()){
                    case R.id.upOne:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(1);
                        }
                        break;
                    case R.id.upTwo:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(2);
                        }
                        break;
                    case R.id.upThree:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(3);
                        }
                        break;
                    case R.id.upFour:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(4);
                        }
                        break;
                    case R.id.upFive:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(5);
                        }
                        break;
                    case R.id.upSix:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(6);
                        }
                        break;
                    case R.id.upSeven:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(7);
                        }
                        break;
                    case R.id.upEight:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(8);
                        }
                        break;
                    case R.id.upNine:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(9);
                        }
                        break;
                    case R.id.upTen:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(10);
                        }
                        break;
                    case R.id.upEleven:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(11);
                        }
                        break;
                    case R.id.upTwelve:
                        drawable = (ColorDrawable) button.getBackground();
                        color = drawable.getColor();
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(12);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        ViewGroup whiteKeyLayout = (ViewGroup)findViewById(R.id.const2Layout);
        for (int i = 0; i < whiteKeyLayout.getChildCount(); i++){
            View key = whiteKeyLayout.getChildAt(i);
            int color = 0;
            ColorDrawable drawable = new ColorDrawable();
            if (key instanceof Button) {
                Button button = (Button) key;
                drawable = (ColorDrawable) button.getBackground();
                color = drawable.getColor();
                switch(key.getId()){
                    case R.id.middleC4:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(13);
                        }
                        break;
                    case R.id.D4:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(14);
                        }
                        break;
                    case R.id.E4:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(15);
                        }
                        break;
                    case R.id.F4:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(16);
                        }
                        break;
                    case R.id.G4:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(17);
                        }
                        break;
                    case R.id.A4:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(18);
                        }
                        break;
                    case R.id.B4:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(19);
                        }
                        break;
                    case R.id.C5:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(20);
                        }
                        break;
                    case R.id.D5:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(21);
                        }
                        break;
                    case R.id.E5:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(22);
                        }
                        break;
                    case R.id.F5:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(23);
                        }
                        break;
                    case R.id.G5:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(24);
                        }
                        break;
                    case R.id.A5:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(25);
                        }
                        break;
                    case R.id.B5:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(26);
                        }
                        break;
                    case R.id.C6:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(27);
                        }
                        break;
                    case R.id.D6:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(28);
                        }
                        break;
                    case R.id.E6:
                        if (color == getResources().getColor(R.color.dark_purple)) {
                            keyCombinations.add(29);
                        }
                        break;
                }
            }
        }
        //frame.add(keyCombinations);
        frame.set(frameCount, keyCombinations);
        TextView frameCounter = findViewById(R.id.frameCounter);
        frameCount = frameCount + 1;
        frameCounter.setText(String.valueOf(frameCount));
        for (int i = 0; i < frame.get(frameCount).size(); i++){
            if (frame.get(frameCount).isEmpty()){
                switch(frame.get(frameCount).get(i)){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    case 13:
                        break;
                    case 14:
                        break;
                    case 15:
                        break;
                    case 16:
                        break;
                    case 17:
                        break;
                    case 18:
                        break;
                    case 19:
                        break;
                    case 20:
                        break;
                    case 21:
                        break;
                    case 22:
                        break;
                    case 23:
                        break;
                    case 24:
                        break;
                    case 25:
                        break;
                    case 26:
                        break;
                    case 27:
                        break;
                    case 28:
                        break;
                    case 29:

                        break;
                }
            }
        }
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
        Button saveButton = findViewById(R.id.saveButton);
        Button confirm_title_button = findViewById(R.id.confirm_title_button);
        Button importButton = findViewById(R.id.importButton);
        Button playButton = findViewById(R.id.playButton);
        pianoLines.setVisibility(View.VISIBLE);
        titleView.setVisibility(View.VISIBLE);
        editTitle.setVisibility(View.INVISIBLE);
        editSpeed.setVisibility(View.VISIBLE);
        speedText.setVisibility(View.VISIBLE);
        saveButton.setVisibility(View.INVISIBLE);
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
        Button saveButton = findViewById(R.id.saveButton);
        Button confirm_title_button = findViewById(R.id.confirm_title_button);
        Button importButton = findViewById(R.id.importButton);
        Button playButton = findViewById(R.id.playButton);
        pianoLines.setVisibility(View.INVISIBLE);
        titleView.setVisibility(View.INVISIBLE);
        editTitle.setVisibility(View.VISIBLE);
        editSpeed.setVisibility(View.INVISIBLE);
        speedText.setVisibility(View.INVISIBLE);
        saveButton.setVisibility(View.VISIBLE);
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

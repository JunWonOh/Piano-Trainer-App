package com.example.pianotrainer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private int frameCount = 1;
    private int maxFrame = 0;
    private int m;
    private double playBackSpeed = 1;
    private Spinner editSpeed;
    private ArrayList<Integer>[] frame = new ArrayList[4000];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editSpeed = findViewById(R.id.editSpeed);

        ArrayList<Double> speedOptions = new ArrayList<>();
        speedOptions.add(1.00);
        speedOptions.add(0.25);
        speedOptions.add(0.50);
        speedOptions.add(0.75);
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
                playBackSpeed = speed;
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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void upArrowClick (View view) {
        //keyCombination contains combinations of the integer value of keys
        ArrayList<Integer> keyCombinations = GetElements();
        frame[frameCount-1] = keyCombinations;
        //When button is clicked, increment frameCount. Set frameCounter to the new value.
        TextView frameCounter = findViewById(R.id.frameCounter);
        frameCount = frameCount + 1;
        frameCounter.setText(String.valueOf(frameCount));
        //Turn every key blue instead of purple to "clear the piano"
        ClearPiano();
        if (frameCount > maxFrame){
            maxFrame = frameCount;
        }
        if (frame[frameCount-1] != null){
            DisplayKeys();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void downArrowClick (View view) {
        ArrayList<Integer> keyCombinations = GetElements();
        frame[frameCount-1] = keyCombinations;
        TextView frameCounter = findViewById(R.id.frameCounter);
        if (frameCount > 1) {
            frameCount = frameCount - 1;
        }
        frameCounter.setText(String.valueOf(frameCount));
        ClearPiano();
        if (frame[frameCount-1] != null){
            DisplayKeys();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void PlaySong(View view) throws InterruptedException{
        final Handler handler = new Handler();
        m = 0;

        // code used from user Shaishav at https://stackoverflow.com/questions/39024588/android-postdelayed-handler-inside-a-for-loop
        final Runnable runnable = new Runnable() {
            public void run() {
                // need to do tasks on the UI thread
                ClearPiano();
                if (frame[m] != null) {
                    PlayKeys(m);
                }
                Log.d("CHECKER", "Run test count: " + m);
                if (m++ < 5) {
                    //this keyword calls run once again.
                    handler.postDelayed(this, (long)(1000/playBackSpeed));
                }
            }
        };
        handler.post(runnable);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void PlayKeys(int currentFrame){
        Button key;
        for (int i = 0; i < frame[currentFrame].size(); i++) {
            switch (frame[currentFrame].get(i)) {
                case 1:
                    key = findViewById(R.id.upOne);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 2:
                    key = findViewById(R.id.upTwo);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 3:
                    key = findViewById(R.id.upThree);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 4:
                    key = findViewById(R.id.upFour);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 5:
                    key = findViewById(R.id.upFive);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 6:
                    key = findViewById(R.id.upSix);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 7:
                    key = findViewById(R.id.upSeven);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 8:
                    key = findViewById(R.id.upEight);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 9:
                    key = findViewById(R.id.upNine);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 10:
                    key = findViewById(R.id.upTen);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 11:
                    key = findViewById(R.id.upEleven);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 12:
                    key = findViewById(R.id.upTwelve);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 13:
                    key = findViewById(R.id.middleC4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 14:
                    key = findViewById(R.id.D4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 15:
                    key = findViewById(R.id.E4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 16:
                    key = findViewById(R.id.F4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 17:
                    key = findViewById(R.id.G4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 18:
                    key = findViewById(R.id.A4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 19:
                    key = findViewById(R.id.B4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 20:
                    key = findViewById(R.id.C5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 21:
                    key = findViewById(R.id.D5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 22:
                    key = findViewById(R.id.E5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 23:
                    key = findViewById(R.id.F5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 24:
                    key = findViewById(R.id.G5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 25:
                    key = findViewById(R.id.A5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 26:
                    key = findViewById(R.id.B5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 27:
                    key = findViewById(R.id.C6);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 28:
                    key = findViewById(R.id.D6);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 29:
                    key = findViewById(R.id.E6);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ArrayList<Integer> GetElements(){
        ArrayList<Integer> keyCombinations = new ArrayList<>();
        /**Iterate through every black key to see if any of them are toggled purple.
         * Each black key has its own respective number.
         * If toggled, add that to the keyCombinations arrayList
         */
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
        /**Iterate through every white key to see if any of them are toggled purple.
         * Each white key has its own respective number.
         * If toggled, add that to the keyCombinations arrayList
         */
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
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(13);
                        }
                        break;
                    case R.id.D4:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(14);
                        }
                        break;
                    case R.id.E4:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(15);
                        }
                        break;
                    case R.id.F4:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(16);
                        }
                        break;
                    case R.id.G4:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(17);
                        }
                        break;
                    case R.id.A4:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(18);
                        }
                        break;
                    case R.id.B4:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(19);
                        }
                        break;
                    case R.id.C5:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(20);
                        }
                        break;
                    case R.id.D5:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(21);
                        }
                        break;
                    case R.id.E5:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(22);
                        }
                        break;
                    case R.id.F5:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(23);
                        }
                        break;
                    case R.id.G5:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(24);
                        }
                        break;
                    case R.id.A5:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(25);
                        }
                        break;
                    case R.id.B5:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(26);
                        }
                        break;
                    case R.id.C6:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(27);
                        }
                        break;
                    case R.id.D6:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(28);
                        }
                        break;
                    case R.id.E6:
                        if (color == getResources().getColor(R.color.light_purple)) {
                            keyCombinations.add(29);
                        }
                        break;
                }
            }
        }
        return keyCombinations;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void DisplayKeys(){
        Button key;
        for (int i = 0; i < frame[frameCount-1].size(); i++) {
            switch (frame[frameCount - 1].get(i)) {
                case 1:
                    key = findViewById(R.id.upOne);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 2:
                    key = findViewById(R.id.upTwo);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 3:
                    key = findViewById(R.id.upThree);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 4:
                    key = findViewById(R.id.upFour);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 5:
                    key = findViewById(R.id.upFive);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 6:
                    key = findViewById(R.id.upSix);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 7:
                    key = findViewById(R.id.upSeven);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 8:
                    key = findViewById(R.id.upEight);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 9:
                    key = findViewById(R.id.upNine);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 10:
                    key = findViewById(R.id.upTen);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 11:
                    key = findViewById(R.id.upEleven);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 12:
                    key = findViewById(R.id.upTwelve);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.dark_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.dark_purple));
                    break;
                case 13:
                    key = findViewById(R.id.middleC4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 14:
                    key = findViewById(R.id.D4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 15:
                    key = findViewById(R.id.E4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 16:
                    key = findViewById(R.id.F4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 17:
                    key = findViewById(R.id.G4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 18:
                    key = findViewById(R.id.A4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 19:
                    key = findViewById(R.id.B4);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 20:
                    key = findViewById(R.id.C5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 21:
                    key = findViewById(R.id.D5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 22:
                    key = findViewById(R.id.E5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 23:
                    key = findViewById(R.id.F5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 24:
                    key = findViewById(R.id.G5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 25:
                    key = findViewById(R.id.A5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 26:
                    key = findViewById(R.id.B5);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 27:
                    key = findViewById(R.id.C6);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 28:
                    key = findViewById(R.id.D6);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
                case 29:
                    key = findViewById(R.id.E6);
                    key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_purple)));
                    key.setBackgroundColor(getResources().getColor(R.color.light_purple));
                    break;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void ClearPiano(){
        Button key;
        key = findViewById(R.id.upOne);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upTwo);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upThree);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upFour);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upFive);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upSix);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upSeven);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upEight);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upNine);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upTen);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upEleven);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.upTwelve);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
        key.setBackgroundColor(getResources().getColor(R.color.teal_700));
        key = findViewById(R.id.middleC4);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.D4);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.E4);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.F4);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.G4);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.A4);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.B4);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.C5);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.D5);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.E5);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.F5);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.G5);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.A5);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.B5);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.C6);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.D6);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        key = findViewById(R.id.E6);
        key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
        key.setBackgroundColor(getResources().getColor(R.color.light_blue));
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

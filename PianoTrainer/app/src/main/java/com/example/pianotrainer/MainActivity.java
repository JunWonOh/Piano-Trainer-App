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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.drawable.ColorDrawable;

public class MainActivity extends AppCompatActivity {

    private int frameCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EditText editTitle = findViewById(R.id.editTitle);
//        TextView titleView = findViewById(R.id.titleView);
//        titleView.setText("Now Playing: " + editTitle.getText().toString());
    }

    //TODO: Images need to "wake up" before being pressed
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _whiteKey (View view) {
        Button key = (Button) findViewById(view.getId());
        ColorDrawable drawable = (ColorDrawable) key.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.light_blue)){
            key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            key.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            key.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.light_blue)));
            key.setBackgroundColor(getResources().getColor(R.color.light_blue));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _CSharp_4 (View view) {
        Button upOne = (Button) findViewById(R.id.upOne);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _DSharp_4 (View view) {
        Button upOne = (Button) findViewById(R.id.upTwo);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _FSharp_4 (View view) {
        Button upOne = (Button) findViewById(R.id.upThree);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _GSharp_4 (View view) {
        Button upOne = (Button) findViewById(R.id.upFour);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _ASharp_4 (View view) {
        Button upOne = (Button) findViewById(R.id.upFive);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _CSharp_5 (View view) {
        Button upOne = (Button) findViewById(R.id.upSix);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _DSharp_5 (View view) {
        Button upOne = (Button) findViewById(R.id.upSeven);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _FSharp_5 (View view) {
        Button upOne = (Button) findViewById(R.id.upEight);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _GSharp_5 (View view) {
        Button upOne = (Button) findViewById(R.id.upNine);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _ASharp_5 (View view) {
        Button upOne = (Button) findViewById(R.id.upTen);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _CSharp_6 (View view) {
        Button upOne = (Button) findViewById(R.id.upEleven);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _DSharp_6 (View view) {
        Button upOne = (Button) findViewById(R.id.upTwelve);
        ColorDrawable drawable = (ColorDrawable) upOne.getBackground();
        int color = drawable.getColor();

        if (color == getResources().getColor(R.color.teal_700)){
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
        }
        else {
            upOne.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.teal_700)));
            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
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

    //public void

    public void InPlayMode () {
        Toast.makeText(this, "Entered Play Mode", Toast.LENGTH_SHORT).show();
        TextView titleView = findViewById(R.id.titleView);
        TextView editTitle = findViewById(R.id.editTitle);
        TextView editSpeed = findViewById(R.id.editSpeed);
        Button importButton = findViewById(R.id.importButton);
        Button playButton = findViewById(R.id.playButton);
        titleView.setVisibility(View.VISIBLE);
        editTitle.setVisibility(View.INVISIBLE);
        editSpeed.setVisibility(View.VISIBLE);
        importButton.setVisibility(View.VISIBLE);
        playButton.setVisibility(View.VISIBLE);

    }

    public void InEditMode () {
        Toast.makeText(this, "Entered Edit Mode", Toast.LENGTH_SHORT).show();
        TextView titleView = findViewById(R.id.titleView);
        TextView editTitle = findViewById(R.id.editTitle);
        TextView editSpeed = findViewById(R.id.editSpeed);
        Button importButton = findViewById(R.id.importButton);
        Button playButton = findViewById(R.id.playButton);
        titleView.setVisibility(View.INVISIBLE);
        editTitle.setVisibility(View.VISIBLE);
        editSpeed.setVisibility(View.INVISIBLE);
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

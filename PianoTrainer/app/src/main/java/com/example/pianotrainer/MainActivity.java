package com.example.pianotrainer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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
        //piano.cNote();
    }

    //TODO: Images need to "wake up" before being pressed
    public void _middleC4Note (View view) {
        ImageView keyOne = (ImageView) findViewById(R.id.keyOne);
        Integer integer = (Integer) keyOne.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.one) {
            keyOne.setImageResource(R.mipmap.oneclicked);
            keyOne.setTag(R.mipmap.oneclicked);
        } else {
            keyOne.setImageResource(R.mipmap.one);
            keyOne.setTag(R.mipmap.one);
        }

//        keyOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick (View view) {
//            }
//        });
    }
    public void _D4Note (View view) {
        ImageView keyTwo = (ImageView) findViewById(R.id.keyTwo);
        Integer integer = (Integer) keyTwo.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.two) {
            keyTwo.setImageResource(R.mipmap.twoclicked);
            keyTwo.setTag(R.mipmap.twoclicked);
        } else {
            keyTwo.setImageResource(R.mipmap.two);
            keyTwo.setTag(R.mipmap.two);
        }
    }
    public void _E4Note (View view) {
        ImageView keyThree = (ImageView) findViewById(R.id.keyThree);
        Integer integer = (Integer) keyThree.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.three) {
            keyThree.setImageResource(R.mipmap.threeclicked);
            keyThree.setTag(R.mipmap.threeclicked);
        } else {
            keyThree.setImageResource(R.mipmap.three);
            keyThree.setTag(R.mipmap.three);
        }
    }
    public void _F4Note (View view) {
        ImageView keyFour = (ImageView) findViewById(R.id.keyFour);
        Integer integer = (Integer) keyFour.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.one) {
            keyFour.setImageResource(R.mipmap.oneclicked);
            keyFour.setTag(R.mipmap.oneclicked);
        } else {
            keyFour.setImageResource(R.mipmap.one);
            keyFour.setTag(R.mipmap.one);
        }
    }
    public void _G4Note (View view) {
        ImageView keyFive = (ImageView) findViewById(R.id.keyFive);
        Integer integer = (Integer) keyFive.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.two) {
            keyFive.setImageResource(R.mipmap.twoclicked);
            keyFive.setTag(R.mipmap.twoclicked);
        } else {
            keyFive.setImageResource(R.mipmap.two);
            keyFive.setTag(R.mipmap.two);
        }
    }
    public void _A4Note (View view) {
        ImageView keySix = (ImageView) findViewById(R.id.keySix);
        Integer integer = (Integer) keySix.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.two) {
            keySix.setImageResource(R.mipmap.twoclicked);
            keySix.setTag(R.mipmap.twoclicked);
        } else {
            keySix.setImageResource(R.mipmap.two);
            keySix.setTag(R.mipmap.two);
        }
    }
    public void _B4Note (View view) {
        ImageView keySeven = (ImageView) findViewById(R.id.keySeven);
        Integer integer = (Integer) keySeven.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.three) {
            keySeven.setImageResource(R.mipmap.threeclicked);
            keySeven.setTag(R.mipmap.threeclicked);
        } else {
            keySeven.setImageResource(R.mipmap.three);
            keySeven.setTag(R.mipmap.three);
        }
    }

    public void _C5Note (View view) {
        ImageView key = (ImageView) findViewById(R.id.keyEight);
        Integer integer = (Integer) key.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.one) {
            key.setImageResource(R.mipmap.oneclicked);
            key.setTag(R.mipmap.oneclicked);
        } else {
            key.setImageResource(R.mipmap.one);
            key.setTag(R.mipmap.one);
        }
    }
    public void _D5Note (View view) {
        ImageView key = (ImageView) findViewById(R.id.keyNine);
        Integer integer = (Integer) key.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.two) {
            key.setImageResource(R.mipmap.twoclicked);
            key.setTag(R.mipmap.twoclicked);
        } else {
            key.setImageResource(R.mipmap.two);
            key.setTag(R.mipmap.two);
        }
    }
    public void _E5Note (View view) {
        ImageView key = (ImageView) findViewById(R.id.keyTen);
        Integer integer = (Integer) key.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.three) {
            key.setImageResource(R.mipmap.threeclicked);
            key.setTag(R.mipmap.threeclicked);
        } else {
            key.setImageResource(R.mipmap.three);
            key.setTag(R.mipmap.three);
        }
    }
    public void _F5Note (View view) {
        ImageView key = (ImageView) findViewById(R.id.keyEleven);
        Integer integer = (Integer) key.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.one) {
            key.setImageResource(R.mipmap.oneclicked);
            key.setTag(R.mipmap.oneclicked);
        } else {
            key.setImageResource(R.mipmap.one);
            key.setTag(R.mipmap.one);
        }
    }
    public void _G5Note (View view) {
        ImageView key = (ImageView) findViewById(R.id.keyTwelve);
        Integer integer = (Integer) key.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.two) {
            key.setImageResource(R.mipmap.twoclicked);
            key.setTag(R.mipmap.twoclicked);
        } else {
            key.setImageResource(R.mipmap.two);
            key.setTag(R.mipmap.two);
        }
    }
    public void _A5Note (View view) {
        ImageView key = (ImageView) findViewById(R.id.keyThirteen);
        Integer integer = (Integer) key.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.two) {
            key.setImageResource(R.mipmap.twoclicked);
            key.setTag(R.mipmap.twoclicked);
        } else {
            key.setImageResource(R.mipmap.two);
            key.setTag(R.mipmap.two);
        }
    }
    public void _B5Note (View view) {
        ImageView key = (ImageView) findViewById(R.id.keyFourteen);
        Integer integer = (Integer) key.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.three) {
            key.setImageResource(R.mipmap.threeclicked);
            key.setTag(R.mipmap.threeclicked);
        } else {
            key.setImageResource(R.mipmap.three);
            key.setTag(R.mipmap.three);
        }
    }

    public void _C6Note (View view) {
        ImageView key = (ImageView) findViewById(R.id.keyFifteen);
        Integer integer = (Integer) key.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.one) {
            key.setImageResource(R.mipmap.oneclicked);
            key.setTag(R.mipmap.oneclicked);
        } else {
            key.setImageResource(R.mipmap.one);
            key.setTag(R.mipmap.one);
        }
    }
    public void _D6Note (View view) {
        ImageView key = (ImageView) findViewById(R.id.keySixteen);
        Integer integer = (Integer) key.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.two) {
            key.setImageResource(R.mipmap.twoclicked);
            key.setTag(R.mipmap.twoclicked);
        } else {
            key.setImageResource(R.mipmap.two);
            key.setTag(R.mipmap.two);
        }
    }
    public void _E6Note (View view) {
        ImageView key = (ImageView) findViewById(R.id.keySeventeen);
        Integer integer = (Integer) key.getTag();
        integer = integer == null ? 0 : integer;

        if (integer == R.mipmap.three) {
            key.setImageResource(R.mipmap.threeclicked);
            key.setTag(R.mipmap.threeclicked);
        } else {
            key.setImageResource(R.mipmap.three);
            key.setTag(R.mipmap.three);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void _CSharp_4 (View view) {
        Button upOne = (Button) findViewById(R.id.upOne);

//        upOne.setBackgroundColor(Color.YELLOW);
        PaintDrawable drawable = (PaintDrawable) upOne.getBackground();
//        int color = drawable.getPaint().getColor();
//        System.out.println(color);

        int color = ((ColorDrawable) upOne.getBackground()).getColor();
//        if (upOne.getBackgroundTintList().equals(R.color.teal_700)){
////            Toast.makeText(this, "hii", Toast.LENGTH_SHORT).show();
////            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
//        }
//            upOne.setBackgroundColor(getResources().getColor(R.color.yellow));
//        }
//        else {
//            upOne.setBackgroundColor(getResources().getColor(R.color.teal_700));
//        }
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

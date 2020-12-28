package com.example.pianotrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
        if (frameCount > 1) {
            frameCount = frameCount - 1;
        }
        frameCounter.setText(String.valueOf(frameCount));
    }

    public void InPlayMode () {
        Toast.makeText(this, "Entered Play Mode", Toast.LENGTH_SHORT).show();
        TextView titleView = findViewById(R.id.titleView);
        TextView editTitle = findViewById(R.id.editTitle);
        Button importButton = findViewById(R.id.importButton);
        titleView.setVisibility(View.VISIBLE);
        editTitle.setVisibility(View.INVISIBLE);
        importButton.setVisibility(View.VISIBLE);
    }

    public void InEditMode () {
        Toast.makeText(this, "Entered Edit Mode", Toast.LENGTH_SHORT).show();
        TextView titleView = findViewById(R.id.titleView);
        TextView editTitle = findViewById(R.id.editTitle);
        Button importButton = findViewById(R.id.importButton);
        titleView.setVisibility(View.INVISIBLE);
        editTitle.setVisibility(View.VISIBLE);
        importButton.setVisibility(View.INVISIBLE);
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

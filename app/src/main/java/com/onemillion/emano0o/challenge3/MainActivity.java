package com.onemillion.emano0o.challenge3;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.colorsSkbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                View RV = (View) findViewById(R.id.redV);
                View BV = (View) findViewById(R.id.blueV);
                float[] hsv = new float[3];

                for (int i=1;i<progress;i++ ) {
                    RV.setBackgroundColor((Color.argb(RV.getBackground().getAlpha(),
                            Math.round(Color.RED)+i,
                            Math.round(Color.GREEN)+i,Math.round(Color.BLUE)+i)));

                    BV.setBackgroundColor((Color.argb(BV.getBackground().getAlpha(),
                            Math.round(Color.BLUE)+i,
                            Math.round(Color.BLUE)+i,Math.round(Color.BLUE)+i)));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast start = Toast.makeText(MainActivity.this,
                        "Start Touching",Toast.LENGTH_SHORT);
                start.show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast start = Toast.makeText(MainActivity.this,
                        "Stop Touching",Toast.LENGTH_SHORT);
                start.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.info)
        {
            final AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("For more info about this task plz visit 1OMAC formus!");

            alert.setPositiveButton("Visit Forum", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://macdiscussions.udacity.com/t/topic/99751"));
                    startActivity(intent);
                }
            });

            alert.setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog dialog = alert.create();
            dialog.show();

        }

        return super.onOptionsItemSelected(item);
    }
}





package com.daniel.benke.atlask;

/**
 * Created by Andrea on 06/02/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ToggleButton;

public class Intestino2Activity extends AppCompatActivity {

    private FloatingActionButton fabz;
    private ToggleButton tog1, tog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intestino2);
        fabz = (FloatingActionButton) this.findViewById(R.id.fabzoom);
        setTitle("Intestino2");
        this.findViewById(R.id.tabClean).setVisibility(View.VISIBLE);
        final HorizontalScrollView hs = (HorizontalScrollView) findViewById(R.id.horizontal);
        findViewById(R.id.fabzoom).setVisibility(View.INVISIBLE);

        addListenerOnButton();


        fabz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                TabHost host = (TabHost)findViewById(R.id.tabHost);
                String current = "zoom 1";

                if (current == "zoom 1") {
                    Intent nextScreen = new Intent(getApplicationContext(), IntestinoZ1Activity.class);
                    startActivity(nextScreen);
                }

                if (current == "zoom 2") {
                    Intent nextScreen = new Intent(getApplicationContext(), IntestinozbActivity.class);
                    startActivity(nextScreen);
                }
            }
        });

        ViewTreeObserver vto = hs.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                hs.getViewTreeObserver().removeGlobalOnLayoutListener(this);

            }
        });

        hs.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("ScrollValue", Integer.toString(hs.getScrollX()));
                if (hs.getScrollX() == 0) {
                    findViewById(R.id.previous).setVisibility(View.INVISIBLE);
                } else {
                    findViewById(R.id.previous).setVisibility(View.VISIBLE);
                }

                if (hs.getScrollX() >= hs.getChildAt(0).getMeasuredWidth() - getWindowManager().getDefaultDisplay().getWidth()) {
                    findViewById(R.id.next).setVisibility(View.INVISIBLE);
                } else {
                    findViewById(R.id.next).setVisibility(View.VISIBLE);
                }
                return false;
            }
        });

        /*

        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                findViewById(R.id.tabClean).setVisibility(View.INVISIBLE);


                //TabHost host = (TabHost)findViewById(R.id.tabHost);
                String current = "zoom 1";
                        //host.getCurrentTabTag();
                // Toast.makeText(view.getContext(), "Cliccado em:" + current, Toast.LENGTH_LONG).show();
                if (current=="zoom 1"||current=="zoom 2") {

                    findViewById(R.id.fabzoom).setVisibility(View.VISIBLE);
                }
                else findViewById(R.id.fabzoom).setVisibility(View.INVISIBLE);
            }

        });

        */


    }

    public void addListenerOnButton() {

        tog1 = (ToggleButton) findViewById(R.id.bot1);
        tog2 = (ToggleButton) findViewById(R.id.bot2);

        tog1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    findViewById(R.id.tabepi).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.tabepi).setVisibility(View.INVISIBLE);
                }

            }

        });

        tog2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    findViewById(R.id.tabcon).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.tabcon).setVisibility(View.INVISIBLE);
                }

            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_intestino, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent nextScreen = new Intent(getApplicationContext(), IntestinoTextoActivity.class);
            startActivity(nextScreen);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
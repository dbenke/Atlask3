package com.daniel.benke.atlask;

/**
 * Created by Andrea on 06/02/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

public class IntestinoActivity extends AppCompatActivity {

    private FloatingActionButton fabz;
    private float scale = 1f;
    private ImageView iv2, iv3,iv4,iv5,iv6,iv7;
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intestino);
        fabz = (FloatingActionButton) this.findViewById(R.id.fabzoom);
        setTitle("Intestino");
        this.findViewById(R.id.tabClean).setVisibility (View.VISIBLE);
        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.horizontal);
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        findViewById(R.id.fabzoom).setVisibility(View.INVISIBLE);

        iv2 = (ImageView)findViewById(R.id.itab2);
        iv3 = (ImageView)findViewById(R.id.itab3);
        iv4 = (ImageView)findViewById(R.id.itab4);
        iv5 = (ImageView)findViewById(R.id.itab5);
        iv6 = (ImageView)findViewById(R.id.itabzoom);
        iv7 = (ImageView)findViewById(R.id.itabClean);
        scaleGestureDetector = new ScaleGestureDetector(this,new ScaleListener());




        fabz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TabHost host = (TabHost)findViewById(R.id.tabHost);
                String current = host.getCurrentTabTag();
                if (current=="zoom 1") {
                    Intent nextScreen = new Intent(getApplicationContext(), IntestinoZ1Activity.class);
                    startActivity(nextScreen);}

                if (current=="zoom 2") {
                    Intent nextScreen = new Intent(getApplicationContext(), IntestinozbActivity.class);
                    startActivity(nextScreen);}
            }
        });

        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");


        //Tab 2
        spec = host.newTabSpec("epitélio");
        spec.setContent(R.id.tab2);
        spec.setIndicator("epitélio");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("conjuntivo");
        spec.setContent(R.id.tab3);
        spec.setIndicator("conjuntivo");
        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("muscular");
        spec.setContent(R.id.tab4);
        spec.setIndicator("muscular");
        host.addTab(spec);

        //Tab 5
        spec = host.newTabSpec("vaso");
        spec.setContent(R.id.tab5);
        spec.setIndicator("vaso");
        host.addTab(spec);

        //Tab 6
        spec = host.newTabSpec("zoom 1");
        spec.setContent(R.id.tab6);
        spec.setIndicator("zoom 1");
        host.addTab(spec);

        //Tab 7
        spec = host.newTabSpec("zoom 2");
        spec.setContent(R.id.tab7);
        spec.setIndicator("zoom 2");
        host.addTab(spec);

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

                if (hs.getScrollX()==0) {
                    findViewById(R.id.previous).setVisibility (View.INVISIBLE);
                } else {
                    findViewById(R.id.previous).setVisibility (View.VISIBLE);
                }

                if (hs.getScrollX() >= hs.getChildAt(0).getMeasuredWidth()-getWindowManager().getDefaultDisplay().getWidth()) {
                    findViewById(R.id.next).setVisibility (View.INVISIBLE);
                } else {
                    findViewById(R.id.next).setVisibility (View.VISIBLE);
                }
                return false;
            }
        });


        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                findViewById(R.id.tabClean).setVisibility(View.INVISIBLE);
                TabHost host = (TabHost)findViewById(R.id.tabHost);
                String current = host.getCurrentTabTag();

                if (current=="zoom 1"||current=="zoom 2") {
                    findViewById(R.id.fabzoom).setVisibility(View.VISIBLE);
                }
                else findViewById(R.id.fabzoom).setVisibility(View.INVISIBLE);
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
        if (id == R.id.action_settings) {
            Intent nextScreen = new Intent(getApplicationContext(), IntestinoTextoActivity.class);
            startActivity(nextScreen);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    float prevX, prevY;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {



        //findViewById(R.id.tabClean).setVisibility(View.VISIBLE);

        //imageView.setVisibility(View.VISIBLE);


        scaleGestureDetector.onTouchEvent(ev);




        float currX = ev.getX(), currY = ev.getY();

        //Toast.makeText(this, "Cliccado em:" + count, Toast.LENGTH_LONG).show();
        //if (currX > iv3.getScrollX())


        switch (ev.getAction()){

            //case MotionEvent.ACTION_DOWN:
            //  preX = event.getX();
            //  preY = event.getY();
            //  Log.i("D ON TOUCH EVENT", "DOWN + X: " + preX + " Y " + preY);

            //  break;

            case MotionEvent.ACTION_MOVE:
                //    Log.i("M ON TOUCH EVENT", "DOWN + X: " + preX + " Y " + preY);
                //   currentX = event.getX();
                //   currentY = event.getY();


/*
                if (iv3.getScrollX()+(prevX - currX)<1) currX=prevX;
                if (iv3.getScrollY()+(prevY - currY)<1) currY=prevY;
                //if (iv3.getScrollX()+(prevX - currX)>760*scale/2) currX=prevX;
                //if (iv3.getScrollX()+(prevY - currY)>760/scale) currY=prevY;
                iv2.scrollBy((int) (prevX - currX), (int) (prevY - currY));
                iv3.scrollBy((int) (prevX - currX), (int) (prevY - currY));
                iv4.scrollBy((int) (prevX - currX), (int) (prevY - currY));
                iv5.scrollBy((int) (prevX - currX), (int) (prevY - currY));
                iv6.scrollBy((int) (prevX - currX), (int) (prevY - currY));
                iv7.scrollBy((int) (prevX - currX), (int) (prevY - currY));
*/
                //  preX = currentX;
                //  preY = currentY;
                break;
            case MotionEvent.ACTION_UP:
                //   Log.i("U ON TOUCH EVENT", "DOWN + X: " + preX + " Y " + preY);
                //   currentX = event.getX();
                //   currentY = event.getY();
                //   iv3.scrollBy((int) (preX - currentX-10), (int) (preY - currentY));
                break;
        }
        prevX = currX;
        prevY = currY;
        //iv3.invalidate();



return true;



    }




    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {

            scale *= detector.getScaleFactor();
            scale = Math.max(0.65f, Math.min(scale, 3.0f));
            matrix.setScale(scale, scale);

            //float scaleFactor = detector.getScaleFactor();
            //scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
            //matrix.setScale(scaleFactor, scaleFactor);

            //this.findViewById(R.id.tabClean).setImageMatrix(matrix);

            iv2.setImageMatrix(matrix);
            iv3.setImageMatrix(matrix);
            iv4.setImageMatrix(matrix);
            iv5.setImageMatrix(matrix);
            iv6.setImageMatrix(matrix);
            iv7.setImageMatrix(matrix);
            return true;
        }
    }


}
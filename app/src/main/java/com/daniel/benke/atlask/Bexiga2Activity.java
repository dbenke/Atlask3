package com.daniel.benke.atlask;

/**
 * Created by Andrea on 06/02/2017.
 */

import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TabHost;

public class Bexiga2Activity extends AppCompatActivity {
    private FloatingActionButton fabz;
    private float scale = 1f;
    private ImageView iv2, iv3, iv4, iv5, iv6, iv7;
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bexiga2);

        iv2 = (ImageView) findViewById(R.id.itab2);
        iv3 = (ImageView) findViewById(R.id.itab3);
        iv4 = (ImageView) findViewById(R.id.itab4);
        iv5 = (ImageView) findViewById(R.id.itab5);
        iv6 = (ImageView) findViewById(R.id.itab6);
        iv7 = (ImageView) findViewById(R.id.itab7);
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        setTitle("Bexiga2");
        fabz = (FloatingActionButton) this.findViewById(R.id.fabzoom);
        this.findViewById(R.id.tabClean).setVisibility(View.VISIBLE);
        final HorizontalScrollView hs = (HorizontalScrollView) findViewById(R.id.horizontal);
        TabHost host = (TabHost) findViewById(R.id.tabHost);
        String current = host.getCurrentTabTag();

        if (current == "zoom") {
            findViewById(R.id.fabzoom).setVisibility(View.VISIBLE);
        } else findViewById(R.id.fabzoom).setVisibility(View.INVISIBLE);

        fabz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TabHost host = (TabHost) findViewById(R.id.tabHost);
                String current = host.getCurrentTabTag();
                if (current == "zoom") {
                    Intent nextScreen = new Intent(getApplicationContext(), BexigaZActivity.class);
                    startActivity(nextScreen);
                }
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
        spec = host.newTabSpec("vaso sanguíneo");
        spec.setContent(R.id.tab5);
        spec.setIndicator("vaso sanguíneo");
        host.addTab(spec);

        //Tab 6
        spec = host.newTabSpec("zoom");
        spec.setContent(R.id.tab6);
        spec.setIndicator("zoom");
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

        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {
                findViewById(R.id.tabClean).setVisibility(View.INVISIBLE);
                TabHost host = (TabHost) findViewById(R.id.tabHost);
                String current = host.getCurrentTabTag();

                if (current == "zoom") {
                    findViewById(R.id.fabzoom).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.fabzoom).setVisibility(View.INVISIBLE);
                }
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bexiga, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_settings:
                // Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT).show();
                Intent nextScreen = new Intent(getApplicationContext(), BexigaTextoActivity.class);
                startActivity(nextScreen);
                break;
            default:
                break;
        }

        return true;
    }

    float prevX, prevY;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        scaleGestureDetector.onTouchEvent(ev);
        //findViewById(R.id.tabClean).setVisibility(View.VISIBLE);

        //imageView.setVisibility(View.VISIBLE);
        float currX = ev.getX(), currY = ev.getY();
        switch (ev.getAction()) {

            //case MotionEvent.ACTION_DOWN:
            //  preX = event.getX();
            //  preY = event.getY();
            //  Log.i("D ON TOUCH EVENT", "DOWN + X: " + preX + " Y " + preY);

            //  break;

            case MotionEvent.ACTION_MOVE:
                //    Log.i("M ON TOUCH EVENT", "DOWN + X: " + preX + " Y " + preY);
                //   currentX = event.getX();
                //   currentY = event.getY();


                if (iv3.getScrollX() + (prevX - currX) < 1) currX = prevX;
                if (iv3.getScrollY() + (prevY - currY) < 1) currY = prevY;
                //if (iv3.getScrollX()+(prevX - currX)>760*scale/2) currX=prevX;
                //if (iv3.getScrollX()+(prevY - currY)>760/scale) currY=prevY;
                iv2.scrollBy((int) (prevX - currX), (int) (prevY - currY));
                iv3.scrollBy((int) (prevX - currX), (int) (prevY - currY));
                iv4.scrollBy((int) (prevX - currX), (int) (prevY - currY));
                iv5.scrollBy((int) (prevX - currX), (int) (prevY - currY));
                iv6.scrollBy((int) (prevX - currX), (int) (prevY - currY));
                iv7.scrollBy((int) (prevX - currX), (int) (prevY - currY));

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
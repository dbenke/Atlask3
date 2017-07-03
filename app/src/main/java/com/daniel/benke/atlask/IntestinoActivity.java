package com.daniel.benke.atlask;

/**
 * Created by Andrea on 06/02/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.Toast;

public class IntestinoActivity extends Activity {
    ReclickableTabHost tabHost;
    private FloatingActionButton fab, fabc,fabz;
    //  LinearLayout esofagoLayout = (LinearLayout) this.findViewById( R.id.esofagos);
    private TabLayout tabsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intestino);

        fab = (FloatingActionButton) this.findViewById(R.id.fabtexto);
        fabc = (FloatingActionButton) this.findViewById(R.id.fabclean);
        fabz = (FloatingActionButton) this.findViewById(R.id.fabzoom);

        this.findViewById(R.id.tabText).setVisibility (View.INVISIBLE);
        this.findViewById(R.id.tabClean).setVisibility (View.VISIBLE);

        //tabsa = (TabLayout)findViewById(R.id.tabHost);
        //tabsa.setTabMode(TabLayout.MODE_SCROLLABLE);

        //tabsa = (TabLayout)findViewById(R.id.tabHost);


        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.horizontal);


        TabHost host = (TabHost)findViewById(R.id.tabHost);
 //       String current = host.getCurrentTabTag();
         //Toast.makeText(host.getContext(), "Cliccado em:" + current, Toast.LENGTH_LONG).show();
//        if (current=="zoom 1"||current=="zoom 2") {
//            findViewById(R.id.fabz).setVisibility(View.VISIBLE);
//        }
//        else
        findViewById(R.id.fabzoom).setVisibility(View.INVISIBLE);



        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                findViewById(R.id.tabText).setVisibility(findViewById(R.id.tabText).getVisibility() == View.INVISIBLE ? View.VISIBLE
                        : View.INVISIBLE);

//                Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
//                startActivity(intent);
            }
        });


        fabc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //             findViewById(R.id.tabC).setVisibility(View.VISIBLE);
                findViewById(R.id.tabClean).setVisibility(findViewById(R.id.tabClean).getVisibility() == View.INVISIBLE ? View.VISIBLE
                        : View.INVISIBLE);
//                Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
//                startActivity(intent);
            }
        });


        fabz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TabHost host = (TabHost)findViewById(R.id.tabHost);
                String current = host.getCurrentTabTag();

                Toast.makeText(view.getContext(),  current, Toast.LENGTH_LONG).show();
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




        // final int maxscrollx = hs.getChildAt(0).getMeasuredWidth()-getWindowManager().getDefaultDisplay().getWidth();
                               //hs.getChildAt(0).getMeasuredWidth()-getWindowManager().getDefaultDisplay().getWidth()
        hs.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("ScrollValue", Integer.toString(hs.getScrollX()));
         //       if(hs.getScrollX() == maxscrollx){
         //           Log.e("MaxRight", "MaxRight");
         //       }

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
                // Toast.makeText(view.getContext(), "Cliccado em:" + current, Toast.LENGTH_LONG).show();
                if (current=="zoom 1"||current=="zoom 2") {

                    findViewById(R.id.fabzoom).setVisibility(View.VISIBLE);
                }
                else findViewById(R.id.fabzoom).setVisibility(View.INVISIBLE);

                //HorizontalScrollView horizontalScrollview;
                //horizontalScrollview = (HorizontalScrollView) findViewById(R.id.horizontal);

//                if (hs.getScrollX()==0) {
//                    findViewById(R.id.previous).setVisibility (View.INVISIBLE);
//                } else {
//                    findViewById(R.id.previous).setVisibility (View.VISIBLE);
//                }
//
//                if (hs.getScrollX() == hs.getChildAt(0).getMeasuredWidth()-getWindowManager().getDefaultDisplay().getWidth()) {
//                    findViewById(R.id.next).setVisibility (View.INVISIBLE);
//                } else {
//                    findViewById(R.id.next).setVisibility (View.VISIBLE);
//                }


            }

        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
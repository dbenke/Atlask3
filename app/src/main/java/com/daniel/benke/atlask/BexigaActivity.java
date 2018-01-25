package com.daniel.benke.atlask;

/**
 * Created by Andrea on 06/02/2017.
 */

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.Toast;


public class BexigaActivity extends AppCompatActivity {
    ReclickableTabHost tabHost;
    private FloatingActionButton fabtexto, fabc,fabz;
    //  LinearLayout esofagoLayout = (LinearLayout) this.findViewById( R.id.esofagos);
    private TabLayout tabsa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bexiga);



        setTitle("Bexiga");


        fabtexto = (FloatingActionButton) this.findViewById(R.id.fabtexto);
        fabc = (FloatingActionButton) this.findViewById(R.id.fabclean);
        fabz = (FloatingActionButton) this.findViewById(R.id.fabzoom);


        findViewById(R.id.fabclean).setVisibility(View.INVISIBLE);
        findViewById(R.id.fabtexto).setVisibility(View.INVISIBLE);

        this.findViewById(R.id.tabText).setVisibility (View.INVISIBLE);
        this.findViewById(R.id.tabClean).setVisibility (View.VISIBLE);

        //tabsa = (TabLayout)findViewById(R.id.tabHost);
        //tabsa.setTabMode(TabLayout.MODE_SCROLLABLE);

        //tabsa = (TabLayout)findViewById(R.id.tabHost);

        final HorizontalScrollView hs = (HorizontalScrollView)findViewById(R.id.horizontal);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        String current = host.getCurrentTabTag();
        // Toast.makeText(host.getContext(), "Cliccasdfado em:" + current, Toast.LENGTH_LONG).show();
        if (current=="zoom") {
            findViewById(R.id.fabzoom).setVisibility(View.VISIBLE);
        }
        else findViewById(R.id.fabzoom).setVisibility(View.INVISIBLE);



        fabtexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  findViewById(R.id.tabText).setVisibility(findViewById(R.id.tabText).getVisibility() == View.INVISIBLE ? View.VISIBLE: View.INVISIBLE);

                Intent nextScreen = new Intent(getApplicationContext(), BexigaTextoActivity.class);
                startActivity(nextScreen);

//                Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
//                startActivity(intent);
            }
        });


        fabc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //             findViewById(R.id.tabC).setVisibility(View.VISIBLE);
               // findViewById(R.id.tabClean).setVisibility(findViewById(R.id.tabClean).getVisibility() == View.INVISIBLE ? View.VISIBLE: View.INVISIBLE);
//                Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
//                startActivity(intent);
            }
        });


        fabz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                TabHost host = (TabHost)findViewById(R.id.tabHost);
                String current = host.getCurrentTabTag();

              //  Toast.makeText(view.getContext(), current, Toast.LENGTH_LONG).show();
                if (current=="zoom") {

                    Intent nextScreen = new Intent(getApplicationContext(), BexigaZActivity.class);
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








       // host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String s) {

                findViewById(R.id.tabClean).setVisibility(View.INVISIBLE);

                TabHost host = (TabHost)findViewById(R.id.tabHost);
                String current = host.getCurrentTabTag();

                // Toast.makeText(host.getContext(), "Cliccasdfado em:" + current, Toast.LENGTH_LONG).show();
                if (current=="zoom") {
                    findViewById(R.id.fabzoom).setVisibility(View.VISIBLE);
                }

                else findViewById(R.id.fabzoom).setVisibility(View.INVISIBLE);




                    //host.setVisibility(findViewById(R.id.tabHost).getVisibility() == View.INVISIBLE ? View.VISIBLE
                     //       : View.INVISIBLE);
                    //Toast.makeText(host.getContext(), "Cliccasdfado em:" + current, Toast.LENGTH_LONG).show();


               // host.setVisibility(host.getVisibility() == View.INVISIBLE ? View.VISIBLE
                //        : View.INVISIBLE);

                //current = host.getVisibility();
/*
                if (host.getVisibility() == View.INVISIBLE) {
                    host.setVisibility(View.VISIBLE);
                }
                    else {
                    findViewById(R.id.tabC).setVisibility(View.VISIBLE);
                    host.setVisibility(View.INVISIBLE);
                }
*/



                //Toast.makeText(host.getContext(), "Cliccasdfado em:" + current, Toast.LENGTH_LONG).show();


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
}
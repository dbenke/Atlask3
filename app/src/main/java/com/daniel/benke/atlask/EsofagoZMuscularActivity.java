package com.daniel.benke.atlask;

/**
 * Created by Andrea on 06/02/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;

public class EsofagoZMuscularActivity extends Activity {
    ReclickableTabHost tabHost;
    private FloatingActionButton fab, fabc,fabz;
  //  LinearLayout esofagoLayout = (LinearLayout) this.findViewById( R.id.esofagos);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esofagozmuscular);

        fab = (FloatingActionButton) this.findViewById(R.id.fab);
        fabc = (FloatingActionButton) this.findViewById(R.id.fabc);
        fabz = (FloatingActionButton) this.findViewById(R.id.fabz);

        this.findViewById(R.id.tabT).setVisibility (View.INVISIBLE);
        this.findViewById(R.id.tabC).setVisibility (View.VISIBLE);

        findViewById(R.id.fabz).setVisibility(View.INVISIBLE);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                findViewById(R.id.tabT).setVisibility(findViewById(R.id.tabT).getVisibility() == View.INVISIBLE ? View.VISIBLE
                        : View.INVISIBLE);

//                Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
//                startActivity(intent);
            }
        });


        fabc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

   //             findViewById(R.id.tabC).setVisibility(View.VISIBLE);
                findViewById(R.id.tabC).setVisibility(findViewById(R.id.tabC).getVisibility() == View.INVISIBLE ? View.VISIBLE
                        : View.INVISIBLE);
//                Intent intent = new Intent(MainActivity.this, NewMessageActivity.class);
//                startActivity(intent);
            }
        });


        fabz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //             findViewById(R.id.tabC).setVisibility(View.VISIBLE);
                //findViewById(R.id.tabC).setVisibility(findViewById(R.id.tabC).getVisibility() == View.INVISIBLE ? View.VISIBLE
                //        : View.INVISIBLE);
                Intent nextScreen = new Intent(getApplicationContext(), EsofagoZMuscularActivity.class);
                startActivity(nextScreen);
            }
        });





        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");


        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("epitélio");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("conjuntivo");
        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("Tab 4");
        spec.setContent(R.id.tab4);
        spec.setIndicator("muscular");
        host.addTab(spec);



        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {


            @Override
            public void onTabChanged(String s) {
                findViewById(R.id.tabC).setVisibility(View.INVISIBLE);

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
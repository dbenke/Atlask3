package com.daniel.benke.atlask;

/**
 * Created by Andrea on 06/02/2017.
 */

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.TabHost;
        import android.support.design.widget.FloatingActionButton;
        import android.widget.Toast;

public class EsofagoActivity extends Activity {
    ReclickableTabHost tabHost;
    private FloatingActionButton fab, fabc,fabz;
  //  LinearLayout esofagoLayout = (LinearLayout) this.findViewById( R.id.esofagos);







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esofago);

        fab = (FloatingActionButton) this.findViewById(R.id.fab);
        fabc = (FloatingActionButton) this.findViewById(R.id.fabc);
        fabz = (FloatingActionButton) this.findViewById(R.id.fabz);

        this.findViewById(R.id.tabT).setVisibility (View.INVISIBLE);
        this.findViewById(R.id.tabC).setVisibility (View.VISIBLE);
        this.findViewById(R.id.fabz).setVisibility(View.INVISIBLE);



        TabHost host = (TabHost)findViewById(R.id.tabHost);
        String current = host.getCurrentTabTag();
        // Toast.makeText(view.getContext(), "Cliccado em:" + current, Toast.LENGTH_LONG).show();
        if (current=="zoom 1"||current=="zoom 2") {
            findViewById(R.id.fabz).setVisibility(View.VISIBLE);
        }
        else findViewById(R.id.fabz).setVisibility(View.INVISIBLE);

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


                TabHost host = (TabHost)findViewById(R.id.tabHost);
                String current = host.getCurrentTabTag();

                Toast.makeText(view.getContext(),  current, Toast.LENGTH_LONG).show();
                if (current=="zoom 1") {

                    Intent nextScreen = new Intent(getApplicationContext(), EsofagozaActivity.class);
                    startActivity(nextScreen);}

                if (current=="zoom 2") {

                    Intent nextScreen = new Intent(getApplicationContext(), EsofagoZMuscularActivity.class);
                    startActivity(nextScreen);}


            }
        });





//        TabHost host = (TabHost)findViewById(R.id.tabHost);
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
        spec = host.newTabSpec("zoom 1");
        spec.setContent(R.id.tab5);
        spec.setIndicator("zoom 1");
        host.addTab(spec);

        //Tab 6
        spec = host.newTabSpec("zoom 2");
        spec.setContent(R.id.tab6);
        spec.setIndicator("zoom 2");
        host.addTab(spec);







        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {


            @Override
            public void onTabChanged(String s) {
                findViewById(R.id.tabC).setVisibility(View.INVISIBLE);


                TabHost host = (TabHost)findViewById(R.id.tabHost);
                String current = host.getCurrentTabTag();

                // Toast.makeText(view.getContext(), "Cliccado em:" + current, Toast.LENGTH_LONG).show();
                if (current=="zoom 1"|| current=="zoom 2") {
                    findViewById(R.id.fabz).setVisibility(View.VISIBLE);
                }
                else findViewById(R.id.fabz).setVisibility(View.INVISIBLE);
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
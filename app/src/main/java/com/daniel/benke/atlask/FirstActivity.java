package com.daniel.benke.atlask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen1);

        final List<ItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(FirstActivity.this);

        final RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        final RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(FirstActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);

        rView.addOnItemTouchListener(new RecyclerItemClickListener(this, rView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               // Toast.makeText(view.getContext(), "Clicked Country Position = " + findViewById(R.id.country_name).toString(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(view.getContext(), "Clicked Country Position = " + position*100, Toast.LENGTH_SHORT).show();
                Toast.makeText(view.getContext(), rowListItem.get(position).getName(), Toast.LENGTH_SHORT).show();
                //handle click events here


                Intent nextScreen = new Intent(getApplicationContext(), EsofagoActivity.class);
                switch(rowListItem.get(position).getName()) {

                    case "Esôfago" :
                        //Toast.makeText(view.getContext(), "Clicked Country Position = " + "this.countryName.getText()" , Toast.LENGTH_SHORT).show();

                        startActivity(nextScreen);

                        break;
                    case "Língua" :
                        //Toast.makeText(view.getContext(), "clicou na lingua]" , Toast.LENGTH_SHORT).show();
                        nextScreen = new Intent(getApplicationContext(), LinguaActivity.class);
                        startActivity(nextScreen);

                        break;
                    case "Bexiga" :
                        //Toast.makeText(view.getContext(), "clicou na lingua]" , Toast.LENGTH_SHORT).show();
                        nextScreen = new Intent(getApplicationContext(), BexigaActivity.class);
                        startActivity(nextScreen);

                        break;
                    case "Intestino" :
                        //Toast.makeText(view.getContext(), "clicou na lingua]" , Toast.LENGTH_SHORT).show();
                        nextScreen = new Intent(getApplicationContext(), IntestinoActivity.class);
                        startActivity(nextScreen);

                        break;
                    case "Medula" :
                        //Toast.makeText(view.getContext(), "clicou na lingua]" , Toast.LENGTH_SHORT).show();
                        nextScreen = new Intent(getApplicationContext(), MedulaActivity.class);
                        startActivity(nextScreen);

                        break;
                    case "Pele" :
                        //Toast.makeText(view.getContext(), "clicou na lingua]" , Toast.LENGTH_SHORT).show();
                        nextScreen = new Intent(getApplicationContext(), PeleActivity.class);
                        startActivity(nextScreen);

                        break;

                }




            }

            @Override
            public void onItemLongClick(View view, int position) {
                //handle longClick if any
            }
        }));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_settings:
               // Toast.makeText(this, "Refresh selected", Toast.LENGTH_SHORT).show();
                Intent nextScreen = new Intent(getApplicationContext(), SobreActivity.class);
                startActivity(nextScreen);
                break;
            default:
                break;
        }

        return true;
    }

    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Língua", R.drawable.lingua));
        allItems.add(new ItemObject("Pele", R.drawable.pele));
        allItems.add(new ItemObject("Bexiga", R.drawable.bexiga));
        allItems.add(new ItemObject("Intestino", R.drawable.intestino));
        allItems.add(new ItemObject("Medula", R.drawable.medula));
        allItems.add(new ItemObject("Esôfago", R.drawable.esofago));

        return allItems;
    }

}

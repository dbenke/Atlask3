package com.daniel.benke.atlask;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;

public class ReclickableTabHost extends TabHost {

    public ReclickableTabHost(Context context) {
        super(context);
    }

    public ReclickableTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setCurrentTab(int index) {
       // Toast.makeText(this.getContext(), "dfgdfgdfg", Toast.LENGTH_SHORT).show();
        if (index == getCurrentTab()) {

         //   Toast.makeText(this.getContext(), "dfgdfgdfg", Toast.LENGTH_SHORT).show();

            findViewById(R.id.tabC).setVisibility(View.INVISIBLE);
          //  super.setCurrentTab(index+1);
          //  super.setCurrentTab(index);

        } else {
            super.setCurrentTab(index);
        }
    }
}
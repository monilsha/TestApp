package com.monil.testapp.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.monil.testapp.R;

/* Class for the second Activity to show the results */
public class result extends ActionBarActivity {

    /* OnCreate for second activity */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        Double monthlypayment = intent.getDoubleExtra("monthlypayment", 0);
        String payoff = intent.getStringExtra("payoff");
        Double totalpay = intent.getDoubleExtra("totalpay", 0);
        TextView showmonthlypayment = (TextView) findViewById(R.id.showmonthlypayment);
        TextView xml_payoff = (TextView) findViewById(R.id.payoff);
        TextView totalpayment = (TextView) findViewById(R.id.totalpay);

        showmonthlypayment.setText(Double.toString(monthlypayment));
        xml_payoff.setText(payoff);
        totalpayment.setText(Double.toString(totalpay));
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

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

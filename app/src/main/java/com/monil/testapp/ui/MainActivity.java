package com.monil.testapp.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.monil.testapp.exception.InputException;
import com.monil.testapp.model.LoanParameters;
import com.monil.testapp.R;
import com.monil.testapp.util.DBHelper;

/* Class for the Main Activity inflated on the launch of Application */
public class MainActivity extends ActionBarActivity {
    /* Instance variables for usage with XML */
    Button calculate;
    int position;
    Spinner monthspinner;
    Spinner yearspinner;
    /* Object to store all the UI values passed */
    LoanParameters UIinput = new LoanParameters();

    /* Function to calculate the monthly payment */
    public static double calculateMonthlyPayment(
            double loanAmount, double termInYears, double interestRate) {
        // Convert interest rate into a decimal
        interestRate /= 100.0;
        // Monthly interest rate
        double monthlyRate = interestRate / 12.0;
        // The length of the term in months
        double termInMonths = termInYears * 12;
        // Calculate the monthly payment
        return (loanAmount * monthlyRate) /
                (1 - Math.pow(1 + monthlyRate, -termInMonths));
    }

    /* Funcition to get all the Form content entered */
    public void getFormContent() throws InputException {
        try {
            UIinput.setPurchaseprice(Double.parseDouble(((EditText) findViewById(R.id.value1)).
                    getText().toString()));
            UIinput.setDownpayment(Double.parseDouble(((EditText) findViewById(R.id.value2)).
                    getText().toString()));
            UIinput.setMortgageterm(Double.parseDouble(((EditText) findViewById(R.id.value3)).
                    getText().toString()));
            UIinput.setInterestrate(Double.parseDouble(((EditText) findViewById(R.id.value4)).
                    getText().toString()));
            UIinput.setPropertytax(Double.parseDouble(((EditText) findViewById(R.id.value5)).
                    getText().toString()));
            UIinput.setPropertyinsurance(Double.parseDouble(((EditText) findViewById(R.id.value6)).
                    getText().toString()));
            UIinput.setPmi(Double.parseDouble(((EditText) findViewById(R.id.value7)).
                    getText().toString()));
            UIinput.setZipcode(Integer.parseInt(((EditText) findViewById(R.id.value8)).
                    getText().toString()));
        }
        catch(Exception e){
            throw new InputException();
        }
        /* Get the position of the month spinner */
        position = monthspinner.getSelectedItemPosition();
        if (position == 0)
            position = 11;
        else
            position = position - 1;
        UIinput.setMonth(monthspinner.getSelectedItem().toString());
        UIinput.setYear(yearspinner.getSelectedItem().toString());
        /* Calculate the loan amount */
        UIinput.setLoanamount(UIinput.getPurchaseprice() -
                (UIinput.getDownpayment() * (UIinput.getPurchaseprice() / 100)));
    }

    /* Funciton to do all the calculations */
    public void docalculations() {
        /* Calculate monthly payment */
        double rawmonthly = calculateMonthlyPayment(UIinput.getLoanamount(),
                UIinput.getMortgageterm(), UIinput.getInterestrate());
        rawmonthly += (UIinput.getPropertyinsurance() / 12);
        rawmonthly += (UIinput.getPropertytax() / 12);
        /* Set all the three results in the object */
        UIinput.setMonthlypayment(rawmonthly);
        UIinput.setTotalpayment(UIinput.getMonthlypayment() * 12 * UIinput.getMortgageterm());
        UIinput.setPayoffdate(monthspinner.getItemAtPosition(position).toString()
                + ", " + (Double.toString((Double.parseDouble(UIinput.getYear()))
                + UIinput.getMortgageterm())));
    }

    /* Perform functions on create of the activity */
    protected void onCreate(Bundle savedInstanceState) {
        /* Inflate XML layout */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* Set buttons, spinners and its adapters */
        calculate = (Button) findViewById(R.id.calculate);
        monthspinner = (Spinner) findViewById(R.id.month);
        yearspinner = (Spinner) findViewById(R.id.year);
        final ArrayAdapter<CharSequence> monthadapter = ArrayAdapter.createFromResource(this,
                R.array.months_array, android.R.layout.simple_spinner_item);
        monthadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        monthspinner.setAdapter(monthadapter);
        ArrayAdapter<CharSequence> yearadapter = ArrayAdapter.createFromResource(this,
                R.array.years_array, android.R.layout.simple_spinner_item);
        yearadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearspinner.setAdapter(yearadapter);
        /* Set onclick listener for button click */
        calculate.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        /* Check for Exception handling  */
                        try {
                            /* get the form content and do calculations */
                            getFormContent();
                            docalculations();
                            /* Instantiate dbhelper and input one row */
                            DBHelper dbHelper = new DBHelper(MainActivity.this);
                            dbHelper.insertRow(UIinput);
                            /* Set intent to navigate to other screen */
                            Intent intent = new Intent(MainActivity.this, result.class);
                            /* Put values to be passed */
                            intent.putExtra("monthlypayment", UIinput.getMonthlypayment());
                            intent.putExtra("payoff", UIinput.getPayoffdate());
                            intent.putExtra("totalpay", UIinput.getTotalpayment());
                            startActivity(intent);
                            /* Catch Input exception and fix it */
                        } catch (InputException e) {
                            e.fixException(getApplicationContext());
                        }
                    }
                });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
package com.monil.testapp.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.monil.testapp.model.LoanParameters;

/* Class to help communication with the Database */
public class DBHelper extends SQLiteOpenHelper {
    //version number.
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "MortgageCalc.db";

    /* Constructor which calls the parent constructor */
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /* Create Table in Oncreate */
    public void onCreate(SQLiteDatabase db) {
        /* Make Query String */
        String CREATE_TABLE_Mortgage = "CREATE TABLE " + LoanParameters.TABLE + "("
                + LoanParameters.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + LoanParameters.KEY_purchaseprice + " INTEGER, "
                + LoanParameters.KEY_downpayment + " INTEGER, "
                + LoanParameters.KEY_mortgageterm + " INTEGER, "
                + LoanParameters.KEY_interestrate + " INTEGER, "
                + LoanParameters.KEY_propertyinsurance + " INTEGER, "
                + LoanParameters.KEY_propertytax + " INTEGER, "
                + LoanParameters.KEY_pmi + " INTEGER, "
                + LoanParameters.KEY_zipcode + " INTEGER, "
                + LoanParameters.KEY_month + " TEXT, "
                + LoanParameters.KEY_year + " TEXT, "
                + LoanParameters.KEY_monthlypayment + " INTEGER, "
                + LoanParameters.KEY_totalpayment + " INTEGER, "
                + LoanParameters.KEY_payoffdate + " TEXT )";

        db.execSQL(CREATE_TABLE_Mortgage);

    }

    public int insertRow(LoanParameters insertparam) {
        //Open connection to write data
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        /* Put all the values */
        values.put(LoanParameters.KEY_monthlypayment, insertparam.getMonthlypayment());
        values.put(LoanParameters.KEY_totalpayment, insertparam.getTotalpayment());
        values.put(LoanParameters.KEY_payoffdate, insertparam.getPayoffdate());
        values.put(LoanParameters.KEY_purchaseprice, insertparam.getPurchaseprice());
        values.put(LoanParameters.KEY_downpayment, insertparam.getDownpayment());
        values.put(LoanParameters.KEY_mortgageterm, insertparam.getMortgageterm());
        values.put(LoanParameters.KEY_interestrate, insertparam.getInterestrate());
        values.put(LoanParameters.KEY_propertyinsurance, insertparam.getPropertyinsurance());
        values.put(LoanParameters.KEY_propertytax, insertparam.getPropertytax());
        values.put(LoanParameters.KEY_pmi, insertparam.getPmi());
        values.put(LoanParameters.KEY_zipcode, insertparam.getZipcode());
        values.put(LoanParameters.KEY_month, insertparam.getMonth());
        values.put(LoanParameters.KEY_year, insertparam.getYear());

        // Inserting Row
        long loanID = db.insert(LoanParameters.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) loanID;

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + LoanParameters.TABLE);
        // Create tables again
        onCreate(db);
    }
}

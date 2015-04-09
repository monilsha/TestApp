package com.monil.testapp.exception;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
/* Custom exception class to represent Input Exceptions */
public class InputException extends Exception {
    /* Function to fix exceptions */
    public void fixException(Context context) {
        /* Display toast if some invalid input given */
        String msg = "Invalid Input";
        Toast.makeText(context,
                msg, Toast.LENGTH_LONG).show();
         /* Log any exceptions found */
        Log.e("InputException", msg);
    }
}

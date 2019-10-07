package com.example.android_callactivity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_callactivity.R;

public class SecondActivity extends AppCompatActivity {

    private TextView txPutExtra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        InitializeComponent();

        Intent i = getIntent();
        Bundle extras = i.getExtras();
        if (extras == null) {
            txPutExtra.setText(getString(R.string.no_extras));
            return;
        } else {
            StringBuilder sbExtras = new StringBuilder();
            sbExtras.append("");
            if (extras.containsKey(getString(R.string.EXTRA_STRING))
                    &&
                    extras.containsKey(getString(R.string.EXTRA_INT)) &&
                    extras.containsKey(getString(R.string.EXTRA_LONG)) &&
                    extras.containsKey(getString(R.string.EXTRA_BOOLEAN)) &&
                    extras.containsKey(getString(R.string.EXTRA_MODEL))
            ) {
                //TODO - Check has extras;
                sbExtras.append("String: " + extras.getString(getString(R.string.EXTRA_STRING)) + "\n");
                sbExtras.append("Int: " + extras.getInt(getString(R.string.EXTRA_INT)) + "\n");
                sbExtras.append("Long: " + extras.getLong(getString(R.string.EXTRA_LONG)) + "\n");
                sbExtras.append("Boolean: " + extras.getBoolean(getString(R.string.EXTRA_BOOLEAN)) + "\n");
                sbExtras.append("ClassModel: " + extras.getSerializable(getString(R.string.EXTRA_MODEL)).toString() + "\n");
            }
            txPutExtra.setText(sbExtras.toString());
        }
    }


    @Override
    public void onBackPressed() {

        Intent i = new Intent();
        i.putExtra(getString(R.string.EXTRA_STRING), "THIS VALUE RETURN ACTIVITY FOR RESULT");
        setResult(RESULT_OK);
        finish();
    }

    private void InitializeComponent() {
        /**
         * TextView
         */
        txPutExtra = findViewById(R.id.second_textViewPutExtra);
    }
}

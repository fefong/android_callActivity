package com.example.android_callactivity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_callactivity.R;
import com.example.android_callactivity.model.Person;

/**
 * Android - Call Activity;
 *
 * @author Felipe Fong
 * @version 1.0
 * @see <a href="https://github.com/fefong">GitHub</a>
 * @see <a href="https://www.linkedin.com/in/felipesu">Linkedin</a>
 */
public class MainActivity extends AppCompatActivity {

    private Button buttonStartActivity, buttonStartActivityPutExtra, buttonStartActivityForResult;
    private TextView txResult;

    private void msg(String value) {
        Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeComponent();
    }

    /**
     * Button: Start Activity ;
     */
    public void btStartActivity(View view) {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
    }

    /**
     * Button: Start Activity with Put Extra ;
     */
    public void btStartActivityPutExtra(View view) {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra(getString(R.string.EXTRA_STRING), "StringValueExtra");
        i.putExtra(getString(R.string.EXTRA_INT), 1);
        i.putExtra(getString(R.string.EXTRA_LONG), 1L);
        i.putExtra(getString(R.string.EXTRA_BOOLEAN), true);
        i.putExtra(getString(R.string.EXTRA_DRAWABLE), R.drawable.ic_android);
        i.putExtra(getString(R.string.EXTRA_MODEL), new Person("NamePerson", "AnyPersonValue"));
        startActivity(i);
    }

    /**
     * Button: Start Activity For Result ;
     */
    public void btStartActivityForResult(View view) {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        startActivityForResult(i, getApplicationContext().getResources().getInteger(R.integer.CODE_ANY));
    }

    /**
     * Method: onActivityResult ;
     */
    @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        /**
         * CHECK [ resultCode ]
         * GET EXTRAS
         */

        if( requestCode ==  getApplicationContext().getResources().getInteger(R.integer.CODE_ANY)) {
            if (resultCode == RESULT_OK) {
                //TODO
                msg("RESULT_OK");
                if (data != null) {
                    if (data.getExtras().containsKey(getString(R.string.EXTRA_STRING))) {
                        txResult.setText(data.getStringExtra(getString(R.string.EXTRA_STRING)));
                    }
                } else {
                    txResult.setText(getString(R.string.no_extras_activityforresult));
                }

            } else {
                //TODO
                msg("RESULT_CANCELED");

            }
        }
    }

    /**
     * Method: InitializeComponent();
     */
    private void InitializeComponent() {
        /**
         * TextView
         */
        txResult = findViewById(R.id.main_textViewResult);

        /**
         * Button
         */
        buttonStartActivity = findViewById(R.id.main_buttonStartActivity);
        buttonStartActivityPutExtra = findViewById(R.id.main_buttonStartActivityPutExtra);
        buttonStartActivityForResult = findViewById(R.id.main_buttonStartActivityForResult);
    }


}

package com.metacat.buttonclickertest;

import android.os.Bundle;s
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button ourButton;
    private TextView ourMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ourButton = (Button) findViewById(R.id.button);
        ourMessage = (TextView) findViewById(R.id.textView);

        View.OnClickListener ourClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ourMessage.setText("The button got tapped");
            }
        };
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
            Toast toastMessage = Toast.makeText(this, "This settings menu options got tapped", Toast.LENGTH_LONG);
            toastMessage.show();

            return true;
        }

        return super.onOptionsItemSelected(item);

    }
}

package torunski.com.inclassexamples_f18;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText et = (EditText)findViewById(R.id.editText);


        Button b1 = (Button)findViewById(R.id.button1);

        Button b2 = (Button)findViewById(R.id.button2);

        final TextView greeting = (TextView)findViewById(R.id.greeting);


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String input = et.getText().toString();

                    Intent nextScreen = new Intent(MainActivity.this, InformationActivity.class);
                    nextScreen.putExtra("InputText", input);
                    startActivityForResult(nextScreen, 12345); //performs transition
                }
            });

        b2.setOnClickListener( vw ->
        {
            greeting.setText("You clicked button 2");
            Intent nextScreen = new Intent(MainActivity.this, ListActivity.class);



            startActivityForResult(nextScreen, 54321);
        });

    }


    @Override
    public void onActivityResult(int request, int result, Intent data)
    {
        if(result == 75)
        {
            String res= data.getStringExtra("RESPONSE");
            Log.d("RESPONSE", res);
        }
    }
}

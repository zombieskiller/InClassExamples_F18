package torunski.com.inclassexamples_f18;

import android.app.Activity;
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

        Button b1 = (Button)findViewById(R.id.button1);

        setContentView(R.layout.activity_main);


        Button b2 = (Button)findViewById(R.id.button2);

        final TextView greeting = (TextView)findViewById(R.id.greeting);

        try {
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    greeting.setText("You clicked button 1");
                }
            });
        } catch (NullPointerException npe)
        {

        }
        b2.setOnClickListener( vw -> greeting.setText("You clicked button 2"));
    }

}

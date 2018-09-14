package torunski.com.inclassexamples_f18;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final EditText input =  (EditText)findViewById(R.id.editText);
        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);

            b1.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          input.setText("You clicked button1");
                                      }});

        b2.setOnClickListener( e -> input.setText("You clicked button 2") );
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}

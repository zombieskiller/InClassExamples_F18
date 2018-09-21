package torunski.com.inclassexamples_f18;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
        final Context ctx = this;



        Button b1 = (Button)findViewById(R.id.button1);
        Button b2 = (Button)findViewById(R.id.button2);

        EditText et = (EditText)findViewById(R.id.editText);

        SharedPreferences prefs = getSharedPreferences("MySavedData", Context.MODE_PRIVATE);
        String savedName = prefs.getString("UserName", "Welcome to my application");

        et.setText(savedName);

        final TextView greeting = (TextView)findViewById(R.id.greeting);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("UserName", et.getText().toString());

                edit.commit(); //this writes to disk


                greeting.setText("You clicked button 1");
                Intent nextScreen = new Intent(ctx, ListScreen.class  );
                nextScreen.putExtra("text", et.getText().toString());
                startActivityForResult( nextScreen , 123);
            }
        });

        b2.setOnClickListener( vw -> {
            greeting.setText("You clicked button 2");


        });
    }


    @Override
    public void onActivityResult(int request, int result, Intent data)
    {
        if(request == 123) //coming from ListScreen
        {
            if(data != null)
            {
                String returned = data.getStringExtra("Hello");
                Log.i("Main", returned);
            }
            if(result == 0)
            {
                Log.i("Main", "User pushed back button");
            }
        }
    }
}

package torunski.com.inclassexamples_f18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class InformationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Intent transition = getIntent();
        String inputText = transition.getStringExtra("InputText");

        TextView tv = (TextView)findViewById(R.id.textView);

        tv.setText(inputText);

        Button back = (Button)findViewById(R.id.finishedButton);
        back.setOnClickListener( click ->
        {
            Intent response = new Intent();
            response.putExtra("RESPONSE", "Thanks");
            setResult(75, response);
            finish();
        });
    }
}

package torunski.com.inclassexamples_f18;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ListScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_screen);

        TextView tv = (TextView)findViewById(R.id.textAtTop);
        Button finishButton = (Button)findViewById(R.id.finishButton);

        Intent from = getIntent();
        String sentText = from.getStringExtra("text");
        tv.setText(sentText);

        finishButton.setOnClickListener( click -> {
            Intent sendBack = new Intent();
            sendBack.putExtra("Hello", "World");

            setResult(50937258, sendBack);
            finish();
        });
    }
}

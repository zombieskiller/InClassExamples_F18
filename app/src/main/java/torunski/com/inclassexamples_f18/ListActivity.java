package torunski.com.inclassexamples_f18;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class ListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Button back = (Button)findViewById(R.id.back_button);
        back.setOnClickListener( click ->
        {
            setResult(4);
            finish();

        });
    }
}

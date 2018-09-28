package torunski.com.inclassexamples_f18;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends Activity {

    int numElements = 2000;

    MyListAdapter listAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Button back = (Button)findViewById(R.id.back_button);
        back.setOnClickListener( click ->
        {
            /*setResult(4);
            finish();
            */
            numElements++;
            listAdapter.notifyDataSetChanged(); // data has changed
        });

        ListView myList = (ListView) findViewById(R.id.myList);
        myList.setAdapter( listAdapter = new MyListAdapter() /*some listAdapter object*/ );
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Clicked", " position " + position + " id: " + id);
            }
        });
    }

    class MyListAdapter extends BaseAdapter {

        public String getItem(int position)
        {
                return "Name " + position ;
        }

        public long getItemId(int i){
            return i;
        }

        public int getCount(){
            return numElements;
        }

        public View getView(int position, View oldView, ViewGroup parent ){
            LayoutInflater inflater = getLayoutInflater();

            View root = oldView;
            if(oldView == null)
                root = inflater.inflate(R.layout.every_row, null);

            TextView nameView = (TextView) root.findViewById(R.id.name_text);

            TextView ageView = (TextView) root.findViewById(R.id.age_field);

            ImageView xView = (ImageView) root.findViewById(R.id.x_image);

            nameView.setText(getItem(position));
            ageView.setText(" Age:" + (int) (Math.random() * 10 + 20)); //some random age

            return root;
        }
    }

}

package data.forbes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonAdapter adapter = new PersonAdapter(this, addPersons());
        ListView lv = (ListView) findViewById(R.id.list);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name =  ((Person)parent.getItemAtPosition(position)).name;
                String url = "https://www.google.ru/search?q=" + name.replace(" ", "+");
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        lv.setAdapter(adapter);
    }

    Person[] addPersons() {
        Person[] arr = new Person[15];

        arr[0] = new Person("Bill Gates", "$86 B", R.drawable.flag_united_states);
        arr[1] = new Person("Warren Buffett", "$75.6 B", R.drawable.flag_united_states);
        arr[2] = new Person("Jeff Bezos", "$72.8 B", R.drawable.flag_united_states);
        arr[3] = new Person("Amancio Ortega", "$71.3 B", R.drawable.flag_spain);
        arr[4] = new Person("Mark Zuckerberg", "$56 B", R.drawable.flag_united_states);
        arr[5] = new Person("Carlos Slim Helu", "$54.5 B", R.drawable.flag_mexico);
        arr[6] = new Person("Larry Ellison", "$52.2 B", R.drawable.flag_united_states);
        arr[7] = new Person("Charles Koch", "$48.3 B", R.drawable.flag_united_states);
        arr[8] = new Person("David Koch", "$48.3 B", R.drawable.flag_united_states);
        arr[9] = new Person("Michael Bloomberg", "$47.5 B", R.drawable.flag_united_states);
        arr[10] = new Person("Bernard Arnault", "$41.5 B", R.drawable.flag_france);
        arr[11] = new Person("Larry Page", "$40.7 B", R.drawable.flag_united_states);
        arr[12] = new Person("Sergey Brin", "$39.8 B", R.drawable.flag_united_states);
        arr[13] = new Person("Liliane Bettencourt", "$39.5 B", R.drawable.flag_france);
        arr[14] = new Person("S. Robson Walton", "$34.1 B", R.drawable.flag_united_states);
        return arr;
    }
}

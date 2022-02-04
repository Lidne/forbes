package data.forbes;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonAdapter extends ArrayAdapter<Person> {

    public PersonAdapter(Context context, Person[] arr) {
        super(context, R.layout.adapter_item, arr);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Person person = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

        ((TextView) convertView.findViewById(R.id.name)).setText(person.name);
        ((TextView) convertView.findViewById(R.id.money)).setText(String.valueOf(person.money));

        ImageView img = (ImageView) convertView.findViewById(R.id.flag);
        img.setImageResource(person.flag_res);

        return convertView;
    }
}

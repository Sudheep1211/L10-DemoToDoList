package sg.edu.rp.c346.id20024402.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> ItemList;

    public CustomAdapter (Context context, int resource, ArrayList<ToDoItem> objects){
        super (context, resource, objects);

        parent_context = context;
        layout_id = resource;
        ItemList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvToDo = rowView.findViewById(R.id.textViewToDo);
        TextView tvDate = rowView.findViewById(R.id.textViewDate);

        // Obtain the Android Version information based on the position
        ToDoItem currentItem = ItemList.get(position);

        // Set values to the TextView to display the corresponding information
        tvToDo.setText(currentItem.getTitle());
        tvDate.setText(currentItem.toString());

        return rowView;
    }
}

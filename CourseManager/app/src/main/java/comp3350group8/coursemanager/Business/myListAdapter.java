package comp3350group8.coursemanager.Business;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350group8.coursemanager.Business.Course;
import comp3350group8.coursemanager.Business.ListItem;
import comp3350group8.coursemanager.R;


public class myListAdapter extends BaseAdapter {

    private static ArrayList<Course> arrayList;

    private LayoutInflater mInflater;

    public myListAdapter(Context context, ArrayList<Course> results) {
        arrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return arrayList.size();
    }

    public Object getItem(int position) {
        return arrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.customview, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.cname);
            holder.txtLoc = (TextView) convertView.findViewById(R.id.loc);
            holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Course course = arrayList.get(position);

        holder.txtName.setText(course.getName().trim());
        holder.txtLoc.setText(course.getLocation().trim());
        holder.txtDesc.setText(course.getDescription().trim());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtLoc;
        TextView txtDesc;
    }
}


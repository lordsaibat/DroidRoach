/*
 * This file is part of the Droid Roach project
 * Copyright 2013 Stefano Gabryel
 * Author: Stefano Gabryel
 * License: GPL v3 - http://www.gnu.org/licenses/gpl-3.0.html
 * Author website: http://www.stefano-workshop.com
 * Project website: http://droid-roach.stefano-workshop.com
 * 
 */

package esse.droidroach;

import java.util.ArrayList;
import java.util.HashMap;

import esse.pentest.droidroach.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class MainAdapter extends BaseAdapter {
 
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    private static LayoutInflater inflater=null;
    
    public static String KEY_TITLE="key_title1";
    public static String KEY_DESCRIPTION="key_description1";
    public static String KEY_ICON="key_icon1";
    public static String KEY_ACTION="key_action1";
 
    public MainAdapter (Activity activity, ArrayList<HashMap<String, String>> data) {
        this.activity = activity;
        this.data=data;
        inflater = (LayoutInflater)this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
 
    public int getCount() {
        return data.size();
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.activity_main_row, null);
 
        TextView title = (TextView)vi.findViewById(R.id.title); // title
        TextView artist = (TextView)vi.findViewById(R.id.description); // description
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image
 
        HashMap<String, String> actions = new HashMap<String, String>();
        actions = data.get(position);
 
        // Setting all values in listview
        title.setText(actions.get(KEY_TITLE));
        artist.setText(actions.get(KEY_DESCRIPTION));
        int resource=Integer.parseInt(actions.get(KEY_ICON));
        thumb_image.setImageResource(resource);

        return vi;
    }
}


package com.example.nipuxo.stickynotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Shanta on 1/24/2017.
 */

public class GridAdapter extends BaseAdapter {

    private int icons[];
    private String texts[];
    private Context context;
    private LayoutInflater inflater;

    public GridAdapter(Context context, int icons[], String text[])
    {
        this.context=context;
        this.icons=icons;
        this.texts=text;
    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public Object getItem(int position) {
        return texts[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        if(convertView == null) {

            inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.customlayout,null);
        }

        ImageView icon= (ImageView)gridView.findViewById(R.id.imageview);
        TextView text = (TextView)gridView.findViewById(R.id.textview);

        icon.setImageResource(icons[position]);
        text.setText(texts[position]);
        return gridView;
    }
}

package com.merlin.bright.cory.golfscorecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by cory on 9/29/17.
 */

public class HoleAdapter extends BaseAdapter {
    private Hole[] mHoles;
    private Context mContext;

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            holder  = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.score_list_item,null);
            holder.holeNumberTextView = (TextView) convertView.findViewById(R.id.holeNumberTextView);
            holder.scoreTextView= (TextView) convertView.findViewById(R.id.stokesScore);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Hole hole = mHoles[position];

        return convertView;
    }

    private class ViewHolder {
        TextView holeNumberTextView;
        TextView scoreTextView;
    }
}

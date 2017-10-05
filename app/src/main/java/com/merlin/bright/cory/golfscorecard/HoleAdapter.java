package com.merlin.bright.cory.golfscorecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by cory on 9/29/17.
 */

public class HoleAdapter extends BaseAdapter {
    private Hole[] mHoles;
    private Context mContext;

    public HoleAdapter(Context context, Hole[] holes) {
        mHoles = holes;
        mContext = context;
    }

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.score_list_item, null);
            holder.holeNumberTextView = (TextView) convertView.findViewById(R.id.holeNumberTextView);
            holder.scoreTextView = (TextView) convertView.findViewById(R.id.stokesScore);
            holder.addStroke = (Button) convertView.findViewById(R.id.addStrokeButton);
            holder.subtactStroke = (Button) convertView.findViewById(R.id.subtactStrokeButton);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.holeNumberTextView.setText(mHoles[position].getHoleName());
        holder.scoreTextView.setText(mHoles[position].getScore() + "");
        holder.addStroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updateStroke = mHoles[position].getScore() + 1;
                mHoles[position].setScore(updateStroke);
                holder.scoreTextView.setText(updateStroke + "");
            }
        });
        holder.subtactStroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updateStroke = (mHoles[position].getScore() - 1 < 0) ? 0 : mHoles[position].getScore() - 1;
                mHoles[position].setScore(updateStroke);
                holder.scoreTextView.setText(updateStroke+"");
            }
        });

        return convertView;
    }

    private class ViewHolder {
        TextView holeNumberTextView;
        TextView scoreTextView;
        Button addStroke;
        Button subtactStroke;
    }
}

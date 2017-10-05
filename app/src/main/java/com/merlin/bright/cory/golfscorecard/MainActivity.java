package com.merlin.bright.cory.golfscorecard;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ListActivity {
    private static final String PREF_FILE = "com.merlin.bright.cory.golfscorecard.prefences";
    private static final String KEYSTROKESCORE = "key_stroke_count";
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private Hole[] mHoles = new Hole[18];
    private HoleAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSharedPreferences = getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        int strokes = 0;
        for (int i = 0; i < mHoles.length; i++) {
            strokes = mSharedPreferences.getInt(KEYSTROKESCORE + i, 0);
            mHoles[i] = new Hole(i + 1, strokes);
        }

        mListAdapter = new HoleAdapter(this, mHoles);
        setListAdapter(mListAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        for (Hole hole :
                mHoles) {
            mEditor.putInt(KEYSTROKESCORE + (hole.getHole()-1), mHoles[hole.getHole()-1].getScore());
        }
        mEditor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_clear_stroke) {
            mEditor.clear();
            mEditor.apply();
            for (Hole hole:
                 mHoles) {
                hole.setScore(0);
            }
            mListAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

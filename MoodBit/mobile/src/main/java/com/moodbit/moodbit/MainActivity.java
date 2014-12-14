package com.moodbit.moodbit;

// Main activity for Mobile device

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView mTestText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addGraphFragment();
        addMenuFragment();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendTestNotification(View notused)
    {
        Intent intent = new Intent(this, Notification.class);
        startActivity(intent);
    }

    public void addGraphFragment()
    {
        // Create new fragment and transaction
        Fragment newFragment = new Graph();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.topFragment1, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
        Log.d("moodbit", "new fragment committed");
    }
    public void addMenuFragment()
    {
        // Create new fragment and transaction
        Fragment newFragment = new MoodBitMenu();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.topFragment2, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
        Log.d("moodbit", "new fragment committed");
    }
}

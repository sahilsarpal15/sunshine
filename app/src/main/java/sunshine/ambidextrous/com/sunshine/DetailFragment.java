package sunshine.ambidextrous.com.sunshine;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.widget.TextView;

/**
 * Created by sahil on 28/2/16.
 */
public class DetailFragment extends Fragment {

    private static final String LOG_TAG = DetailFragment.class.getSimpleName();
    private static final String FORCAST_SHARE_HASHTAG = " #Sunshine App";
    private String mForcastStr;

    public DetailFragment() {
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_detail, container);
        Log.i("inside", "inside click");
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String mForcastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
            Log.i("inside", "inside click forcast "+ mForcastStr);
            ((TextView) rootView.findViewById(R.id.detail_text)).setText(mForcastStr);
        }

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.detailedfragment, menu);


        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.action_share);


        // Fetch and store ShareActionProvider
        ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);


        if(mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(createShareForcastIntent());
        } else {
            Log.d(LOG_TAG, "Share Action Provider is null? :/");
        }
    }


    private Intent createShareForcastIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, mForcastStr+FORCAST_SHARE_HASHTAG);
        return shareIntent;
    }


}

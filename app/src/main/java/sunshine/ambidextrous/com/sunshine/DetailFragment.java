package sunshine.ambidextrous.com.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sahil on 28/2/16.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        View rootView = inflater.inflate(R.layout.fragment_detail, container);
        Log.i("inside", "inside click");
        if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String forcastStr = intent.getStringExtra(Intent.EXTRA_TEXT);
            Log.i("inside", "inside click forcast "+ forcastStr);
            ((TextView) rootView.findViewById(R.id.detail_text)).setText(forcastStr);
        }
        return rootView;
    }
}

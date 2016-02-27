package sunshine.ambidextrous.com.sunshine;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sahil on 27/2/16.
 */
public class PlaceholderFragment extends Fragment {
    public PlaceholderFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container);
        ArrayAdapter mForcastAdapter;

        String[] forcastArray = {
                "Today - Sunny - 88/63",
                "Tommorow - Foggy - 70/40",
                "Weds - Cloudy - 72/63",
                "Thus - Aestroids - 75/65",
                "Fri - Heavy Rain - 65/56",
                "Sat - Trapped in Weather Station - 60/51",
                "Sun - Sunny - 80/68"
        };

        List<String> weekForcast = new ArrayList<String>(
                Arrays.asList(forcastArray));

        mForcastAdapter = new ArrayAdapter<String>(
                getActivity(),
                R.layout.list_item_forcast,
                R.id.list_item_forcast_textview,
                weekForcast
        );

        ListView listView = (ListView) rootView.findViewById(R.id.listview_forcast);

        listView.setAdapter(mForcastAdapter);
        return  rootView;
    }

}

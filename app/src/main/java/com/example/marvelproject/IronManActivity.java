package com.example.marvelproject;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of Accommodation venues.
 */
public class IronManActivity extends Fragment {

    public ArrayList<Hero> HerosDatabase = new ArrayList<>();
    RecyclerView recyclerView;

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public IronManActivity() {
        // Required empty public constructor

    }

    // Initialise context from onAttach()
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.venue_list, container, false);

        //Create the ArrayList data
        HerosDatabase.add(new Hero(
                getString(R.string.venue_6_title),
                getString(R.string.venue_6_intro),
                R.drawable.tab_icon_iron_man));

        HerosDatabase.add(new Hero(
                getString(R.string.venue_7_title),
                getString(R.string.venue_7_intro),
                R.drawable.tab_icon_iron_man));

        HerosDatabase.add(new Hero(
                getString(R.string.venue_8_title),
                getString(R.string.venue_8_intro),
                R.drawable.tab_icon_iron_man));

        //Create a standard LinearLayout Manager to control how the recycler works
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //Create an adapter based on the custom class you created
        HeroAdapter venueAdapter = new HeroAdapter(mContext, HerosDatabase);

        //Find your Recycler and set your layoutManger and adapter to it
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(venueAdapter);

        return rootView;
    }
}
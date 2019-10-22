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
 * {@link Fragment} that displays a list of Restaurant venues.
 */
public class GuardiansActivity extends Fragment {

    public ArrayList<Hero> HeroesDatabase = new ArrayList<>();
    RecyclerView recyclerView;

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public GuardiansActivity() {
        // Required empty public constructor
    }

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
        HeroesDatabase.add(new Hero(
                getString(R.string.venue_9_title),
                getString(R.string.venue_9_intro),

                R.drawable.tab_icon_guardians));

        HeroesDatabase.add(new Hero(
                getString(R.string.venue_10_title),
                getString(R.string.venue_10_intro),

                R.drawable.tab_icon_guardians));

        HeroesDatabase.add(new Hero(
                getString(R.string.venue_11_title),
                getString(R.string.venue_11_intro),

                R.drawable.tab_icon_guardians));

        HeroesDatabase.add(new Hero(
                getString(R.string.venue_12_title),
                getString(R.string.venue_12_intro),

                R.drawable.tab_icon_guardians));

        HeroesDatabase.add(new Hero(
                getString(R.string.venue_13_title),
                getString(R.string.venue_13_intro),

                R.drawable.tab_icon_guardians));

        HeroesDatabase.add(new Hero(
                getString(R.string.venue_14_title),
                getString(R.string.venue_14_intro),

                R.drawable.tab_icon_guardians));

        //Create a standard LinearLayout Manager to control how the recycler works
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //Create an adapter based on the custom class you created
        HeroAdapter venueAdapter = new HeroAdapter(mContext,HeroesDatabase);

        //Find your Recycler and set your layoutManger and adapter to it
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(venueAdapter);

        return rootView;
    }
}
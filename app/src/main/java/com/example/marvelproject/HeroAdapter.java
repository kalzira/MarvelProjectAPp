package com.example.marvelproject;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.VenueHolder> {
    private LayoutInflater layoutInflater;
    private ArrayList<Hero> venuesDatabase;


    //Creates the actual method of performing the recycler
    public HeroAdapter(Context context, ArrayList<Hero> venuesDatabase) {
        this.layoutInflater = LayoutInflater.from(context);
        this.venuesDatabase = venuesDatabase;
    }

    @NonNull
    @Override
    public VenueHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new VenueHolder(view);
    }

    //Binds your Array data to the particular layout views
    @Override
    public void onBindViewHolder(@NonNull VenueHolder holder, int position) {
        final Hero currentHero = venuesDatabase.get(position);

        //Assign the values of your ArrayList to the assigned holder views
        holder.venueTitle.setText(currentHero.getVenueTitle());

        holder.venuePhotoId.setImageResource(currentHero.getVenuePhotoId());

        //On Click Listener that goes to the chosen Hero's ActivityDetail page
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent venueDetailsIntent = new Intent(v.getContext(), DetailActivity.class);

                // Add the venue details BUNDLE to be sent to DetailActivity
                venueDetailsIntent.putExtra("VENUE_TITLE", currentHero.getVenueTitle());
                venueDetailsIntent.putExtra("VENUE_INTRO", currentHero.getVenueIntro());
                v.getContext().startActivity(venueDetailsIntent);
            }
        });
    }

    //Returns your Array size
    @Override
    public int getItemCount() {
        return venuesDatabase.size();
    }

    //This is a custom holder which is how your data binding occurs, this is where the ids are assigned.
    class VenueHolder extends RecyclerView.ViewHolder {
        private TextView venueTitle;

        private ImageView venuePhotoId;

        private VenueHolder(View venueView) {
            super(venueView);
            venueTitle = venueView.findViewById(R.id.venue_title);

            venuePhotoId = venueView.findViewById(R.id.venue_photo);
        }
    }
}
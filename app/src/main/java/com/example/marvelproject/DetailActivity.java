/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.marvelproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Venue details BUNDLE from MainActivity
        final String venueTitle = getIntent().getStringExtra("VENUE_TITLE");
        final String venueIntro = getIntent().getStringExtra("VENUE_INTRO");

        final int venueImage = getIntent().getIntExtra("VENUE_IMAGE", 0);


        // Find the views for selected Venue
        TextView selectedVenueTitleTextView = findViewById(R.id.toolbar_title);
        TextView selectedVenueIntroTextView = findViewById(R.id.venue_intro);
        TextView selectedVenueVillageTextView = findViewById(R.id.venue_village);

        ImageView selectedVenueImageView = findViewById(R.id.backdrop);


        // Set the TextViews to the BUNDLE values for the selected Venue
        if (venueTitle.equals("") || venueTitle.equals("N/A")) {
            selectedVenueTitleTextView.setVisibility(View.GONE);
        } else {
            selectedVenueTitleTextView.setText(venueTitle);
        }

        if (venueIntro.equals("") || venueIntro.equals("N/A")) {
            selectedVenueIntroTextView.setVisibility(View.GONE);
        } else {
            selectedVenueIntroTextView.setText(venueIntro);
        }


        // Display the venue image
        selectedVenueImageView.setImageResource(venueImage);

        // Set up the custom toolbar and back button
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    // Make the Up Button behave like a Back Button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return(super.onOptionsItemSelected(item));
    }
}

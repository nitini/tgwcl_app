package com.tgwcl.divnitini.twgcl_v1;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.Serializable;

public class ViewOutfit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_outfit);

        Intent intent = getIntent();
        Outfit outfit = (Outfit) intent.getSerializableExtra("Outfit");
        TextView largePostDate = (TextView) findViewById(R.id.largePostDate);
        ImageView collageView = (ImageView) findViewById(R.id.bigCollagePicture);
        TextView vibeText = (TextView) findViewById(R.id.vibeText);
        TextView dosText = (TextView) findViewById(R.id.dosText);
        TextView dontText = (TextView) findViewById(R.id.dontText);


        Glide.with(collageView.getContext())
                .load(outfit.getCollageLink())
                .into(collageView);

        largePostDate.setText(outfit.getPostDate());

        vibeText.setText(outfit.getVibe());
        dosText.setText(outfit.getDos());
        dontText.setText(outfit.getDonts());

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);

    }



}

package com.tgwcl.divnitini.twgcl_v1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;

    FirebaseDatabase mFirebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = mFirebaseDatabase.getReference("outfits");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recyclerview);

        mLayoutManager = new LinearLayoutManager(this);

        if (mRecyclerView != null) {
            mRecyclerView.setHasFixedSize(true);
        }

        Log.i("ALALLALALALALA", "HELLOOOOOOO");
        final FirebaseRecyclerAdapter<Outfit,
                OutfitItemViewHolder> adapter = new FirebaseRecyclerAdapter<Outfit,
                OutfitItemViewHolder> (
                Outfit.class,
                R.layout.outfit_item,
                OutfitItemViewHolder.class,
                mDatabaseReference.getRef()
        ) {
            @Override
            protected void populateViewHolder(final OutfitItemViewHolder viewHolder,
                                              Outfit model,
                                              final int position) {



                final String key = this.getRef(position).getKey();

                mDatabaseReference.child(key).addListenerForSingleValueEvent(
                        new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        Outfit outfit = dataSnapshot.getValue(Outfit.class);

                        viewHolder.outfitShortDesc.setText(outfit.getVibe());
                        viewHolder.outfitPostDate.setText(outfit.getPostDate());
                        viewHolder.outfitThumbnail.setVisibility(View.VISIBLE);
                        Glide.with(viewHolder.outfitThumbnail.getContext())
                                .load(outfit.getCollageLink())
                                .into(viewHolder.outfitThumbnail);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                viewHolder.mView.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Log.i("ARE WE REALLLLL RERE", new Integer(position).toString());

                        mDatabaseReference.child(key).addListenerForSingleValueEvent(
                                new ValueEventListener() {

                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                Outfit outfit = dataSnapshot.getValue(Outfit.class);


                                Intent startViewOutfitActivity = new Intent(getApplicationContext(),
                                        ViewOutfit.class);
                                startViewOutfitActivity.putExtra("Outfit", outfit);
                                startActivity(startViewOutfitActivity);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                        //Start activity here


                    }
                });

            }
        };



        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);





    }



        public static class OutfitItemViewHolder extends RecyclerView.ViewHolder {

        TextView outfitPostDate;
        TextView outfitShortDesc;
        ImageView outfitThumbnail;
        View mView;


        public OutfitItemViewHolder(View v) {
            super(v);
            mView = v;
            outfitPostDate = (TextView) v.findViewById(R.id.outfit_post_date);
            outfitShortDesc = (TextView) v.findViewById(R.id.outfit_short_desc);
            outfitThumbnail = (ImageView) v.findViewById(R.id.outfit_thumbnail);

        }

        public View getmView() {
            return mView;
        }



    }



}

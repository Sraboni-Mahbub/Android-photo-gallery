package com.example.photogallery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class customImageAdapter extends BaseAdapter{
    Context context;
    ArrayList<imagesArrayList> arrayList;
    String imageURL, description;
    public customImageAdapter(Context context, ArrayList<imagesArrayList> arrayList){
        this.context = context;
        this.arrayList = arrayList;

    }
    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.imageview, parent, false);

        ImageView coursename = rowView.findViewById(R.id.imgView);



        imagesArrayList imagesArrayList = arrayList.get(position);


        imageURL = imagesArrayList.getImageID();
        description = imagesArrayList.getDescription();
        String url = "https://muthosoft.com/univ/photos/";
        Picasso.get().load(url+imagesArrayList.getImageID()).into(coursename);

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ImageDescription.class);
                intent.putExtra("imageID", imagesArrayList.getImageID());
                intent.putExtra("imageDes", imagesArrayList.getDescription());
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}

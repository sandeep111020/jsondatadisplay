package com.example.eventsjson.Adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.eventsjson.ImageDownloaderTask;
import com.example.eventsjson.Models.placesmodel;
import com.example.eventsjson.R;

import java.util.List;


public class MyAdapter extends ArrayAdapter<placesmodel> {
    //the tutorial list that will be displayed
    private List<placesmodel> tutorialList;
    private Bitmap bitmap;
    private Context mCtx;
    //here we are getting the tutoriallist and context
    //so while creating the object of this adapter class we need to give tutoriallist and context
    public MyAdapter(List<placesmodel> tutorialList, Context mCtx) {
        super(mCtx, R.layout.item_listview, tutorialList);
        this.tutorialList = tutorialList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getting the layoutinflater
        ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        convertView = inflater.inflate(R.layout.item_listview, null, true);
        holder = new ViewHolder();
        //getting text views
        holder.textViewName = convertView.findViewById(R.id.textViewName);

        holder.imageView = convertView.findViewById(R.id.imageView);

        convertView.setTag(holder);
        //Getting the tutorial for the specified position
        placesmodel tutorial = tutorialList.get(position);
        String imageUrl = tutorial.getImage();

        String tutorialTitle = tutorial.getBook_title();

        holder.textViewName.setText(tutorialTitle);
        Glide.with(getContext()).load(tutorial.getImage()).into(holder.imageView);

        if (holder.imageView != null) {
            /*-------------fatching image------------*/;
            new ImageDownloaderTask(holder.imageView).execute(imageUrl);
        }
        holder.imageView.setImageBitmap(bitmap);
        return convertView;
    }
    static class ViewHolder {
        TextView textViewName;
        TextView textDescription;
        ImageView imageView;
    }
}
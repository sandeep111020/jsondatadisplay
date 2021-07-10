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
import com.example.eventsjson.Models.eventsmodel;

import com.example.eventsjson.R;

import java.util.List;


public class eventsAdapter extends ArrayAdapter<eventsmodel> {
    //the tutorial list that will be displayed
    private List<eventsmodel> tutorialList;

    private Context mCtx;

    public eventsAdapter(List<eventsmodel> tutorialList, Context mCtx) {
        super(mCtx, R.layout.eventslayout, tutorialList);
        this.tutorialList = tutorialList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        convertView = inflater.inflate(R.layout.eventslayout, null, true);
        holder = new ViewHolder();
        holder.textViewName = convertView.findViewById(R.id.textViewName);

        holder.imageView = convertView.findViewById(R.id.imageView);

        holder.date=convertView.findViewById(R.id.date);
        holder.fee=convertView.findViewById(R.id.ticket);
        holder.place=convertView.findViewById(R.id.city);
        convertView.setTag(holder);
        eventsmodel tutorial = tutorialList.get(position);
        String imageUrl = tutorial.getImage();

        holder.date.setText(tutorial.getDate());
        holder.place.setText(tutorial.getPlace());
        holder.fee.setText(tutorial.getFee());

        String tutorialTitle = tutorial.getName();

        holder.textViewName.setText(tutorialTitle);
        Glide.with(getContext()).load(tutorial.getImage()).into(holder.imageView);


        return convertView;
    }
    static class ViewHolder {
        TextView textViewName;
        TextView date,place,fee;
        ImageView imageView;
    }
}
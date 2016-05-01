package com.example.android.landonhotels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HotelAdapter extends ArrayAdapter<Hotel> {

    private List<Hotel> hotels;

    public HotelAdapter(Context context, int resource, List<Hotel> objects) {
        super(context, resource, objects);
        hotels = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item_location, parent, false);
        }

        Hotel location = hotels.get(position);

        TextView cityText = (TextView) convertView.findViewById(R.id.cityText);
        cityText.setText(location.getCity());

        TextView neighborhoodText = (TextView) convertView.findViewById(R.id.neighborhoodText);
        neighborhoodText.setText(location.getNeighborhood());

        int imageResource = getContext().getResources().getIdentifier(
                location.getImage(), "drawable", getContext().getPackageName());

        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView);
        iv.setImageResource(imageResource);

        return convertView;
    }
}

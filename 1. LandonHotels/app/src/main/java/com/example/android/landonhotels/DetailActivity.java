package com.example.android.landonhotels;

import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private Hotel hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String city = getIntent().getStringExtra("city");
        setTitle(getString(R.string.landon_hotel) + ", " + city);
        hotel = DataProvider.hotelMap.get(city);

        if (hotel == null) {
            Toast.makeText(this, getString(R.string.error_find_hotel) + ": "
                    + city, Toast.LENGTH_SHORT).show();
        } else {
            displayHotelDetails();
        }
    }

    private void displayHotelDetails() {
        TextView cityText = (TextView) findViewById(R.id.cityText);
        cityText.setText(hotel.getCity());

        TextView neighborhoodText = (TextView) findViewById(R.id.neighborhoodText);
        neighborhoodText.setText(hotel.getNeighborhood());

        TextView descText = (TextView) findViewById(R.id.descriptionText);
        descText.setText(hotel.getDescription() + "\n");

        int imageResource = getResources().getIdentifier(
                hotel.getImage(), "drawable", getPackageName());

        ImageView iv = (ImageView) findViewById(R.id.imageView);
        iv.setImageResource(imageResource);
    }

    public void sendNotification(View view) {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle(getText(R.string.app_name))
                .setContentText("Your room will be ready for check in at 3pm")
                .setSmallIcon(R.drawable.ic_notify);
        int notificationId = 0;
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, builder.build());
    }
}

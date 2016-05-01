package com.example.android.landonhotels;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
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

        String text = "Visit Landon hotel in " + hotel.getCity() + "!\n\n" +
                hotel.getDescription();

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(text);

        int backgroundId = getResources().getIdentifier(
                hotel.getImage(), "drawable", getPackageName()
        );
        Bitmap background = BitmapFactory.decodeResource(getResources(), backgroundId);
        NotificationCompat.WearableExtender extender = new NotificationCompat.WearableExtender()
                .setBackground(background);

        Uri uri = Uri.parse("geo:0,0?q=" + hotel.getCity());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(uri);

        PendingIntent mapPI = PendingIntent.getActivity(this, 0, mapIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle(getText(R.string.app_name))
                .setStyle(bigTextStyle)
                .setSmallIcon(R.drawable.ic_notify)
                .extend(extender)
                .addAction(R.drawable.ic_action_map, "Map", mapPI);
        int notificationId = 0;
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, builder.build());
    }
}

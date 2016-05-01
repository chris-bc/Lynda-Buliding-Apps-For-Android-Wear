package com.example.android.landonhotels;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Hotel> hotels = DataProvider.hotelList;
    private NotificationManagerCompat mgr;
    private final String GROUP_KEY = "Notification_Group";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(android.R.id.list);
        ArrayAdapter<Hotel> adapter =
                new HotelAdapter(this, R.layout.list_item_location, hotels);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                Hotel location = hotels.get(position);
                intent.putExtra("city", location.getCity());
                startActivity(intent);
            }

        });

        mgr = NotificationManagerCompat.from(this);

        for (int i = 0; i < hotels.size(); i++) {
            sendHotelNotification(hotels.get(i), i);
        }

    }

    private void sendHotelNotification(Hotel hotel, int notificationId) {

        String text = "Visit Landon Hotel in " + hotel.getCity() +
                "!\n\n" + hotel.getDescription();
        NotificationCompat.BigTextStyle bigTextStyle =
                new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(text);

        Uri uri = Uri.parse("geo:0,0?q=" + hotel.getCity());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(uri);

        PendingIntent mapPendingIntent =
                PendingIntent.getActivity(this, 0, mapIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setContentTitle(getText(R.string.app_name))
                        .setStyle(bigTextStyle)
                        .setSmallIcon(R.drawable.ic_notify)
                        .setGroup(GROUP_KEY)
                        .addAction(R.drawable.ic_action_map, "Map", mapPendingIntent);

        mgr.notify(notificationId, builder.build());

    }

}

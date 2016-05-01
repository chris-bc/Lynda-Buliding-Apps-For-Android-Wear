package com.example.android.landonhotels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataProvider {

    public static List<Hotel> hotelList = new ArrayList<>();
    public static Map<String, Hotel> hotelMap = new HashMap<>();

    static {

        saveLocation("London",
                "West End",
                "The original Landon still perseveres after over 50 years, although it has since had a facelift to  improve infrastructure. The West End neighborhood has something for everyone - from theater to dining to historic sights. That said, the West End Landon is far from being solely a tourist’s hotel. The community doesn’t just ebb and flow around the hotel - the community pours into the hotel, making The Landon an important venue for community activities and meetings. And the not-to-miss rooftop cafe is a great place for travelers and locals to engage over drinks, food, and good conversation.",
                "london_photo",
                "123 Oxford Street London W1S 2YF England");

        saveLocation("Hong Kong",
                "Kwun Tong",
                "With floor to ceiling windows and a breathtaking view of the city lights, the Landon Hotel located in the Kwun Tong neighborhood of Hong Kong, is the choice of many business travelers and vacationers, alike. Savvy and sophisticated, the Kwun Tong Landon provides a place to slow down and relax amid the fast-paced tempo of Hong Kong, while also allowing easy access to the awe-inspiring natural beauty of the region, and such manmade feats in engineering as Millennium City and the Manulife Financial Centre. And don’t miss a ride in our glass elevators, the fastest in the city.",
                "hongkong_photo",
                "1177 How Ming St, Kwun Tong, Kowloon, Hong Kong");

        saveLocation("San Francisco",
                "Bernal Heights",
                "Nestled between a yoga studio and a bakery, on a quaint street in this community-centered, Bernal Heights neighborhood, is the 40-room, modern-themed, Landon Hotel. While the primary purpose of the hotel is to house visitors from around the world, a secondary, almost mandated purpose, is as a gathering place for many of the community’s activities and calls to activism. No one can leave the hotel untouched by the sense of community. Our new modern conference room at the Bernal Heights Landon is the talk of the town, as far as meeting rooms are concerned, but reserve soon, as availability is filling up.",
                "sf_photo",
                "288 Coleridge Street San Francisco, CA 94110");

        saveLocation("Paris",
                "Latin Quarter",
                "Since the Middle Ages, the Latin Quarter has been a neighborhood of artists, writers, and intellects, and the Landon exudes this in every brick of its building. It’s a common experience that a tourist finds himself derailed from an ordinary day of tourism, to sit in the vintage reading room of the Landon and debate politics, discuss literature, or recite poetry with natives, while sipping coffee amongst the hotel’s sizable book stacks.",
                "paris_photo",
                "261 Rue Saint-Severin, 75005 Paris, France"
        );

    }

    private static void saveLocation(String city, String neighborhood, String description, String image, String address) {
        Hotel hotel = new Hotel(city, neighborhood, description, image, address);
        hotelList.add(hotel);
        hotelMap.put(city, hotel);
    }

}

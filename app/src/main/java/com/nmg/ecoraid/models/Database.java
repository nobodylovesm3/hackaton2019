package com.nmg.ecoraid.models;

import com.nmg.ecoraid.data.Raid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
    private static List<Raid> database;
    private static ArrayList<Raid> likedCities;

    public static List<Raid> getDatabase() {
        if (database == null) {
            database = generateDatabase();
            likedCities = new ArrayList<>();
        }
        return database;
    }

    private static List<Raid> generateDatabase() {
        return Arrays.asList(
                new Raid("Cleaning the IT Center", "•When: 15.04.2019 10:00 AM\n•Where: 14 “Kokiche“ str., Vratsa\n•Time required: approximately 30 minutes for 10 people.\n•Addition information:\n- Make sure you bring your own gloves.", "https://www.kmeta.bg/wp-content/uploads/2013/12/06/52a161e585873.jpg", "10"),
                new Raid("“The wrong neighbourhood“", "•When: 16.04.2019 03:00 AM\n•Where: 2 “Glyharche“ str., Vratsa\n•Time required: approximately 14 minutes for 7 people.\n•Addition information:\n- No equipment required. Just make sure you are well dressed.", "https://m3.netinfo.bg/media/images/32663/32663318/896-504-bokluci-otpadyci-snimki-galeriia.jpg", "7"),
                new Raid("Feelings - cleaning", "•When: 16.04.2019 10:00 PM\n•Where: 71 “Lebed“ str., Vratsa\n•Time required: approximately 7 minutes for 2 people.\n•Addition information:\n- None.", "https://i.cbc.ca/1.4058552.1491497095!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_780/519407452-man-happy-to-be-vacuuming.jpg", "2")
        );
    }

    public static void addLikedCity(Raid raid) {
        likedCities.add(raid);
    }

    public static void removeLikedCity(Raid raid) {
        likedCities.remove(raid);
    }

    public static List<Raid> getLikedCities() {
        return likedCities;
    }

    public static void setLikedCities(List<Raid> cities) {
        likedCities = (ArrayList<Raid>) cities;
    }

    public static boolean isLikedCity(String name) {
        for (int i = 0; i < likedCities.size(); i++) {
            if (likedCities.get(i).getCityName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}

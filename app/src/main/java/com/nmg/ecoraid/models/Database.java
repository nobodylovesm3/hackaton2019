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
                new Raid("Враца", "Description for Vratsa", "https://i.pinimg.com/originals/60/12/e7/6012e72ad4548100daaf8b5bfbc456d8.jpg", "1"),
                new Raid("Варна", "Description for Vratsa", "https://d1bvpoagx8hqbg.cloudfront.net/originals/experience-varna-bulgaria-monika-2318456a10f5320b89f8ad6a22127b4c.jpg", "10"),
                new Raid("Монтана", "Description for Vratsa", "https://cdn.britannica.com/81/75681-004-041060FC.jpg", "9")
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

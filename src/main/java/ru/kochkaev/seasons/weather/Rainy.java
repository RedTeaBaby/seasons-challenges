package ru.kochkaev.seasons.weather;

import ru.kochkaev.api.seasons.config.Config;
import ru.kochkaev.api.seasons.object.WeatherObject;
import ru.kochkaev.api.seasons.service.Season;

import java.util.Arrays;

public class Rainy extends WeatherObject {

    public Rainy() {
        super("RAINY",
                Config.getModConfig("Seasons Challenges").getLang().getString("lang.weather.rainy.name"),
                Config.getModConfig("Seasons Challenges").getLang().getString("lang.weather.rainy.message"),
                true, false,
                Config.getModConfig("Seasons Challenges").getConfig().getInt("conf.weather.rainy.chance"),
                Arrays.asList(Season.getSeasonByID("SPRING"), Season.getSeasonByID("FALL")), false);
    }

    @Override
    public void onWeatherSet() {

    }

    @Override
    public void onWeatherRemove() {

    }
}

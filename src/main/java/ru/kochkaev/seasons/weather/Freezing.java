package ru.kochkaev.seasons.weather;

import ru.kochkaev.seasons.config.Config;
import ru.kochkaev.seasons.object.WeatherObject;
import ru.kochkaev.seasons.service.Season;

import java.util.Collections;

public class Freezing extends WeatherObject {

    public Freezing() {
        super("FREEZING",
                Config.getLang().getString("lang.weather.freezing.name"),
                Config.getLang().getString("lang.weather.freezing.message"),
                false, false,
                Config.getConfig().getInt("conf.weather.freezing.chance"),
                Collections.singletonList(Season.getSeasonByID("WINTER")), false);
    }

    @Override
    public void onWeatherSet() {

    }

    @Override
    public void onWeatherRemove() {

    }
}

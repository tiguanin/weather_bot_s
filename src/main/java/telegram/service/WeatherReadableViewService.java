package telegram.service;

import weather.mapping.FactualWeather;

public interface WeatherReadableViewService {

    String getConvertedForecastAsString(FactualWeather factualWeather);
}

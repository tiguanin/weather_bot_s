package weather.service;


import weather.mapping.FactualWeather;

/**
 * Сервис получения данных о погоде
 */
public interface GetWeatherService {

    /**
     * Текущая погода
     */
    FactualWeather getFactualWeather();

    /**
     * Погода на следующий день
     */
//    FactualWeather getWeatherByNextDay();
}

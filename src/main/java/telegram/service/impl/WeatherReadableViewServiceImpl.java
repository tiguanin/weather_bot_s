package telegram.service.impl;

import org.springframework.stereotype.Service;
import telegram.service.WeatherReadableViewService;
import weather.mapping.FactualWeather;

@Service
public class WeatherReadableViewServiceImpl implements WeatherReadableViewService {

    @Override
    public String getConvertedForecastAsString(FactualWeather factualWeather) {
        String data = "Доброе утро, Александр! \uD83D\uDE0E \n" +
                "На данный момент температура на улице: " +
                (factualWeather.getTemp() >= 10 ? "терпимо" : "ХОЛОДНО! \uD83C\uDF85\uD83C\uDFFB, ") +
                "а именно " + factualWeather.getTemp() + " градусов,\n " +
                "ощущается как " + factualWeather.getFeelsLike() +
                (factualWeather.getFeelsLike() >= 3 ? ", можно надеть шарф \uD83E\uDDE3" : ", надевай теплую куртку! \uD83D\uDC36") ;
        return data;
    }
}

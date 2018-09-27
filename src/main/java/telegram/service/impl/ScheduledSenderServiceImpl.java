package telegram.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import telegram.config.Bot;
import telegram.service.ForecastSenderService;
import telegram.service.ScheduledSenderService;
import weather.service.GetWeatherService;

@Service
public class ScheduledSenderServiceImpl implements ScheduledSenderService {

    @Autowired
    GetWeatherService getWeatherService;

    @Autowired
    ForecastSenderService forecastSenderService;

    @Autowired
    Bot bot;

    @Override
    @Scheduled(cron = "${api.yandex.weather.schedule.cron}")
    public void sendScheduledMessage() {
        System.out.println(bot.getChatId());
        forecastSenderService.sendMessageToInitiator(bot.getChatId(), getWeatherService.getFactualWeather());
    }
}

package telegram.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram.config.Bot;
import telegram.service.ForecastSenderService;
import telegram.service.WeatherReadableViewService;
import weather.mapping.FactualWeather;

@Service
public class ForecastSenderServiceImpl implements ForecastSenderService {

    @Autowired
    WeatherReadableViewService weatherReadableViewService;

    @Autowired
    Bot bot;

    @Override
    public void sendMessageToInitiator(Long chatId, Object apiMessage) {
        if (apiMessage != null & chatId != null) {
            if (apiMessage instanceof FactualWeather) {
                SendMessage message = new SendMessage()
                        .setChatId(chatId)
                        .setText(weatherReadableViewService.getConvertedForecastAsString((FactualWeather) apiMessage));
                try {
                    bot.execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (apiMessage instanceof String) {
                SendMessage message = new SendMessage()
                        .setChatId(chatId)
                        .setText((String) apiMessage);
                try {
                    bot.execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

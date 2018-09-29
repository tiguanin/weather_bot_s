package telegram.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import telegram.service.ForecastSenderService;
import telegram.service.ScheduledSenderService;
import weather.service.GetWeatherService;


public class Bot extends TelegramLongPollingBot {

    private final static Logger LOGGER = LoggerFactory.getLogger(Bot.class);

    @Value("${api.telegram.lutalsnoticebot.name}")
    private String botUsername;

    @Value("${api.telegram.lutalsnoticebot.token}")
    private String token;

    @Autowired
    GetWeatherService getWeatherService;

    @Autowired
    ForecastSenderService forecastSenderService;

    @Autowired
    ScheduledSenderService scheduledSenderService;

    Long chatId;


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            System.out.println(update.getMessage().getChat().getFirstName());
            if (!"/start".equals(update.getMessage().getText())) {
//                forecastSenderService.sendMessageToInitiator(this.chatId, getWeatherService.getFactualWeather());
                if (this.chatId != null) {
                    scheduledSenderService.sendScheduledMessage();
                } else {
                    LOGGER.error("None user doesn't send \"/start\" command!");
                    forecastSenderService.sendMessageToInitiator(
                            update.getMessage().getChatId(),
                            "Кроме команды /start я ничего делать не буду! \uD83D\uDE1D");
                }
            } else {
                this.chatId = update.getMessage().getChatId();
                forecastSenderService.sendMessageToInitiator(
                        this.chatId,
                        "Привет! Я буду уведомлять тебя о текущей погоде каждый день в 23:55!");
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public long getChatId() {
        return this.chatId;
    }

}

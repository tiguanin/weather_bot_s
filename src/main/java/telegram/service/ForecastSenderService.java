package telegram.service;

public interface ForecastSenderService {

    void sendMessageToInitiator(Long chatId, Object message);

}

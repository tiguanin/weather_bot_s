package weather.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weather.mapping.FactualWeather;
import weather.service.GetWeatherService;

@Service
@EnableScheduling
public class GetWeatherServiceImpl implements GetWeatherService {

    private final static Logger LOGGER = LoggerFactory.getLogger(GetWeatherServiceImpl.class);

    @Value("${api.yandex.weather.test.url}")
    private String url;

    @Value("${api.yandex.weather.token}")
    private String weatherToken;

    @Override
    @Scheduled(fixedRate = 2000)
    public FactualWeather getFactualWeather() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Yandex-API-Key", weatherToken);

        HttpEntity<JsonNode> response = new RestTemplate()
                .exchange(
                        url,
                        HttpMethod.GET,
                        new HttpEntity<>(headers),
                        JsonNode.class);

        if (response.getBody() != null) {
            JsonNode root = response.getBody();
            FactualWeather fact = new ObjectMapper()
                    .convertValue(root.findValue("fact"), FactualWeather.class);
            LOGGER.info(fact.toString());
            return fact;
        } else {
            //TODO: Костыль. Нужно посмотреть как принудительно остановит выполнение!
            LOGGER.error("Response from Yandex.Weather is null!");
            return null;
        }

    }
}

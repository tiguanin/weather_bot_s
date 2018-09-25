package weather.mapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class DayWeather {

    @JsonProperty("temp_min")
    private int tempMin;

    @JsonProperty("temp_max")
    private int tempMax;

    @JsonProperty("temp_avg")
    private float tempAvg;

    @JsonProperty("feels_like")
    private int feelsLike;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("condition")
    private String condition;


}

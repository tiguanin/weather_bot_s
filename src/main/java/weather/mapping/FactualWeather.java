package weather.mapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Информация о погоде на данный момент.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class FactualWeather {

    @JsonProperty("temp")
    private long temp;

    @JsonProperty("feels_like")
    private long feelsLike;

    /**
     * Параметр возвращается для населенных пунктов, где данная информация актуальна.
     * По умолчанию = 0, не придумал как скрыть его, если он не приходит в ответе.
     */
    @JsonProperty("temp_water")
    private long tempWater;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("condition")
    private String condition;

    @JsonProperty("wind_speed")
    private float windSpeed;

    @JsonProperty("wind_gust")
    private float windGust;

    @JsonProperty("wind_dir")
    private String windDir;

    @JsonProperty("pressure_mm")
    private int pressureMm;

    @JsonProperty("pressure_pa")
    private int pressurePa;

    @JsonProperty("humidity")
    private int humidity;

    @JsonProperty("daytime")
    private String dayTime;

    @JsonProperty("polar")
    private boolean polar;

    @JsonProperty("season")
    private String season;

    @JsonProperty("obs_time")
    private int obsTime;

    @JsonProperty("prec_type")
    private int precType;

    @JsonProperty("prec_strength")
    private float precStrength;

    @JsonProperty("cloudness")
    private float cloudnes;



    public long getTemp() {
        return temp;
    }

    public long getFeelsLike() {
        return feelsLike;
    }

    public long getTempWater() {
        return tempWater;
    }

    public String getIcon() {
        return icon;
    }

    public String getCondition() {
        return condition;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public float getWindGust() {
        return windGust;
    }

    public String getWindDir() {
        return windDir;
    }

    public int getPressureMm() {
        return pressureMm;
    }

    public int getPressurePa() {
        return pressurePa;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getDayTime() {
        return dayTime;
    }

    public boolean isPolar() {
        return polar;
    }

    public String getSeason() {
        return season;
    }

    public int getObsTime() {
        return obsTime;
    }

    public int getPrecType() {
        return precType;
    }

    public float getPrecStrength() {
        return precStrength;
    }

    public float getCloudnes() {
        return cloudnes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

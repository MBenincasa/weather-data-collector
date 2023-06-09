package io.github.mbenincasa.weatherdatacollector.client;

import io.github.mbenincasa.weatherdatacollector.dto.CityDTO;
import io.github.mbenincasa.weatherdatacollector.dto.response.CurrentWeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class OpenWeatherClient {

    private final WebClient webClient;

    @Value("${openweathermap.apikey}")
    private String apiKey;

    @Value("${openweathermap.url}")
    private String url;

    public CurrentWeatherResponse getCurrentWeather(CityDTO cityDto) {
        return webClient.get()
                .uri(url, cityDto.getLat(), cityDto.getLon(), apiKey)
                .retrieve()
                .bodyToMono(CurrentWeatherResponse.class)
                .block();
    }
}

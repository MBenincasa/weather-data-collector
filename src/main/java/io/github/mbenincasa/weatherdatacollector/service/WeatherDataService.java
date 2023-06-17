package io.github.mbenincasa.weatherdatacollector.service;

import io.github.mbenincasa.weatherdatacollector.dto.WeatherDataDTO;
import io.github.mbenincasa.weatherdatacollector.mapper.Mapper;
import io.github.mbenincasa.weatherdatacollector.repo.WeatherDataRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherDataService {

    private final WeatherDataRepo weatherDataRepo;
    private final Mapper mapper;

    public Page<WeatherDataDTO> getWeatherDataFiltered(Pageable pageable, String city) {
        var data = weatherDataRepo.findByFilter(pageable, city);
        return data.map(mapper::toWeatherDataDTO);
    }
}

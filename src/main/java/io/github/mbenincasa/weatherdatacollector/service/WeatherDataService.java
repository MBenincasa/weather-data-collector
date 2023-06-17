package io.github.mbenincasa.weatherdatacollector.service;

import io.github.mbenincasa.javaexcelutils.enums.Extension;
import io.github.mbenincasa.javaexcelutils.model.converter.ObjectToExcel;
import io.github.mbenincasa.javaexcelutils.tools.Converter;
import io.github.mbenincasa.weatherdatacollector.dto.WeatherDataDTO;
import io.github.mbenincasa.weatherdatacollector.dto.WeatherDataReportDTO;
import io.github.mbenincasa.weatherdatacollector.mapper.Mapper;
import io.github.mbenincasa.weatherdatacollector.repo.WeatherDataRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @SneakyThrows
    public byte[] getReportWeatherDataFiltered(Pageable pageable, String city) {
        var data = weatherDataRepo.findByFilter(pageable, city);
        List<ObjectToExcel<?>> list = new ArrayList<>();
        list.add(new ObjectToExcel<>("Weather Data", WeatherDataReportDTO.class, data.map(mapper::toWeatherDataReportDTO).stream()));
        return Converter.objectsToExcelByte(list, Extension.XLSX, true);
    }
}

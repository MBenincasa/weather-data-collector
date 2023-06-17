package io.github.mbenincasa.weatherdatacollector.dto;

import io.github.mbenincasa.javaexcelutils.annotations.ExcelBodyStyle;
import io.github.mbenincasa.javaexcelutils.annotations.ExcelField;
import io.github.mbenincasa.javaexcelutils.annotations.ExcelHeaderStyle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@ToString
@ExcelHeaderStyle(cellColor = IndexedColors.ORANGE, horizontal = HorizontalAlignment.RIGHT, vertical = VerticalAlignment.BOTTOM, autoSize = true)
@ExcelBodyStyle(cellColor = IndexedColors.LIGHT_ORANGE, horizontal = HorizontalAlignment.RIGHT, vertical = VerticalAlignment.BOTTOM)
public class WeatherDataReportDTO {

    @ExcelField(name = "ID")
    private Long id;
    @ExcelField(name = "DATE")
    private LocalDateTime date;
    @ExcelField(name = "WEATHER")
    private String weather;
    @ExcelField(name = "TEMPERATURE (°C)")
    private Double temp; // °C
    @ExcelField(name = "HUMIDITY (%)")
    private Integer humidity; // %
    @ExcelField(name = "PRESSURE (hPa)")
    private Integer pressure; // hPa
    @ExcelField(name = "WIND")
    private String wind;
    @ExcelField(name = "RAIN (mm)")
    private Double rain; // mm
    @ExcelField(name = "SNOW (mm)")
    private Double snow; // mm
    @ExcelField(name = "CITY")
    private String city;
}

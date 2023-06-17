package io.github.mbenincasa.weatherdatacollector.repo;

import io.github.mbenincasa.weatherdatacollector.domain.WeatherData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WeatherDataRepo extends JpaRepository<WeatherData, Long> {

    @Query(value = """
        SELECT wd
        FROM WeatherData wd
        WHERE wd.city.name = ?1
    """)
    Page<WeatherData> findByFilter(Pageable pageable, String city);
}

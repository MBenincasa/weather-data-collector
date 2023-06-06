package io.github.mbenincasa.weatherdatacollector.repo;

import io.github.mbenincasa.weatherdatacollector.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepo extends JpaRepository<City, Long> {
}

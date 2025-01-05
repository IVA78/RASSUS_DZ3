package hr.fer.tel.rassus.server.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * This class represents a reading data transfer object (DTO)
 * It contains reading-related information and provides
 * methods for sensor operations.
 */
@Entity
public class ReadingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double temperature;
    private Integer pressure;
    private Double humidity;
    private Integer co;
    private Integer no2;
    private Integer so2;

    public ReadingDTO() {
    }

    public ReadingDTO( Double temperature, Integer pressure, Double humidity, Integer co, Integer no2, Integer so2) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.co = co;
        this.no2 = no2;
        this.so2 = so2;
    }



    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Integer getCo() {
        return co;
    }

    public void setCo(Integer co) {
        this.co = co;
    }

    public Integer getNo2() {
        return no2;
    }

    public void setNo2(Integer no2) {
        this.no2 = no2;
    }

    public Integer getSo2() {
        return so2;
    }

    public void setSo2(Integer so2) {
        this.so2 = so2;
    }
}

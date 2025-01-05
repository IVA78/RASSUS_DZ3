package hr.fer.tel.rassus.server.beans;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * This class represents a reading data transfer object (DTO)
 * It contains reading-related information and provides
 * methods for sensor operations.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReadingReceivedDTO {

    private String name;
    private String unit;
    private Double value;


    public ReadingReceivedDTO() {
    }

    public ReadingReceivedDTO(String name, String unit, Double value) {
        this.name = name;
        this.unit = unit;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

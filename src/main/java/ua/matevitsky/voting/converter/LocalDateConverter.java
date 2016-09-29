package ua.matevitsky.voting.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by Sergey on 29.09.16.
 */

@Converter(autoApply = true)
public class LocalDateConverter implements
        AttributeConverter<LocalDate, Date> {
    @Override
    public java.sql.Date convertToDatabaseColumn(LocalDate entityValue) {
        return java.sql.Date.valueOf(entityValue);
    }

    @Override
    public LocalDate convertToEntityAttribute(java.sql.Date databaseValue) {
        return databaseValue.toLocalDate();
    }
}
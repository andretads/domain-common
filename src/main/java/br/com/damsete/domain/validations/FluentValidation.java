package br.com.damsete.domain.validations;

import br.com.damsete.domain.notifications.Notifiable;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.GenericValidator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FluentValidation extends Notifiable {

    public FluentValidation isTrue(boolean value, String code, Object... args) {
        if (!value) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isFalse(boolean value, String code, Object... args) {
        if (value) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNull(Object value, String code, Object... args) {
        if (value != null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNotNull(Object value, String code, Object... args) {
        if (value == null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNull(String value, String code, Object... args) {
        if (value != null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNotNull(String value, String code, Object... args) {
        if (value == null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isEmpty(String value, String code, Object... args) {
        if (StringUtils.isNotEmpty(value)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNotEmpty(String value, String code, Object... args) {
        if (StringUtils.isEmpty(value)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areEquals(String value, String text, String code, Object... args) {
        if (!value.equalsIgnoreCase(text)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areNotEquals(String value, String text, String code, Object... args) {
        if (value.equalsIgnoreCase(text)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation hasMinLen(String value, int min, String code, Object... args) {
        if (value == null) {
            value = "";
        }

        if (value.length() < min) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation hasMaxLen(String value, int max, String code, Object... args) {
        if (value == null) {
            value = "";
        }

        if (value.length() > max) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation hasLen(String value, int len, String code, Object... args) {
        if (value == null) {
            value = "";
        }

        if (value.length() != len) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation contains(String value, String text, String code, Object... args) {
        if (value == null) {
            value = "";
        }

        if (!value.contains(text)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isEmail(String value, String code, Object... args) {
        if (value == null) {
            value = "";
        }

        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(value);

        if (!matcher.matches()) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isUsername(String value, String code, Object... args) {
        if (value == null) {
            value = "";
        }

        Pattern pattern = Pattern.compile("^([a-zA-Z])+([\\w]{2,})+$");
        Matcher matcher = pattern.matcher(value);

        if (!matcher.matches()) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBoolean(String value, String code, Object... args) {
        if (value == null) {
            value = "";
        }

        if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNumber(String value, String code, Object... args) {
        if (value == null) {
            value = "";
        }

        if (!StringUtils.isNumeric(value)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isDate(String value, String pattern, String code, Object... args) {
        if (value == null) {
            value = "";
        }

        if (!GenericValidator.isDate(value, pattern, true)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNull(Long value, String code, Object... args) {
        if (value != null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNotNull(Long value, String code, Object... args) {
        if (value == null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isGreaterThan(Long value, Long comparer, String code, Object... args) {
        if (value == null) {
            value = 0L;
        }

        if (value <= comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isGreaterOrEqualsThan(Long value, Long comparer, String code, Object... args) {
        if (value == null) {
            value = 0L;
        }

        if (value < comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isLowerThan(Long value, Long comparer, String code, Object... args) {
        if (value == null) {
            value = 0L;
        }

        if (value >= comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isLowerOrEqualsThan(Long value, Long comparer, String code, Object... args) {
        if (value == null) {
            value = 0L;
        }

        if (value > comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areEquals(Long value, Long comparer, String code, Object... args) {
        if (value == null) {
            value = 0L;
        }

        if (!value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areNotEquals(Long value, Long comparer, String code, Object... args) {
        if (value == null) {
            value = 0L;
        }

        if (value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBetween(Long value, Long from, Long to, String code, Object... args) {
        if (value == null) {
            value = 0L;
        }

        if (!(value > from && value < to)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNull(Integer value, String code, Object... args) {
        if (value != null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNotNull(Integer value, String code, Object... args) {
        if (value == null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isGreaterThan(Integer value, Integer comparer, String code, Object... args) {
        if (value == null) {
            value = 0;
        }

        if (value <= comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isGreaterOrEqualsThan(Integer value, Integer comparer, String code, Object... args) {
        if (value == null) {
            value = 0;
        }

        if (value < comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isLowerThan(Integer value, Integer comparer, String code, Object... args) {
        if (value == null) {
            value = 0;
        }

        if (value >= comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isLowerOrEqualsThan(Integer value, Integer comparer, String code, Object... args) {
        if (value == null) {
            value = 0;
        }

        if (value > comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areEquals(Integer value, Integer comparer, String code, Object... args) {
        if (value == null) {
            value = 0;
        }

        if (!value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areNotEquals(Integer value, Integer comparer, String code, Object... args) {
        if (value == null) {
            value = 0;
        }

        if (value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBetween(Integer value, Integer from, Integer to, String code, Object... args) {
        if (value == null) {
            value = 0;
        }

        if (!(value > from && value < to)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNull(Float value, String code, Object... args) {
        if (value != null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNotNull(Float value, String code, Object... args) {
        if (value == null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isGreaterThan(Float value, Float comparer, String code, Object... args) {
        if (value == null) {
            value = 0F;
        }

        if (value <= comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isGreaterOrEqualsThan(Float value, Float comparer, String code, Object... args) {
        if (value == null) {
            value = 0F;
        }

        if (value < comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isLowerThan(Float value, Float comparer, String code, Object... args) {
        if (value == null) {
            value = 0F;
        }

        if (value >= comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isLowerOrEqualsThan(Float value, Float comparer, String code, Object... args) {
        if (value == null) {
            value = 0F;
        }

        if (value > comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areEquals(Float value, Float comparer, String code, Object... args) {
        if (value == null) {
            value = 0F;
        }

        if (!value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areNotEquals(Float value, Float comparer, String code, Object... args) {
        if (value == null) {
            value = 0F;
        }

        if (value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBetween(Float value, Float from, Float to, String code, Object... args) {
        if (value == null) {
            value = 0F;
        }

        if (!(value > from && value < to)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNull(Double value, String code, Object... args) {
        if (value != null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNotNull(Double value, String code, Object... args) {
        if (value == null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isGreaterThan(Double value, Double comparer, String code, Object... args) {
        if (value <= comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isGreaterOrEqualsThan(Double value, Double comparer, String code, Object... args) {
        if (value < comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isLowerThan(Double value, Double comparer, String code, Object... args) {
        if (value >= comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isLowerOrEqualsThan(Double value, Double comparer, String code, Object... args) {
        if (value > comparer) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areEquals(Double value, Double comparer, String code, Object... args) {
        if (!value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areNotEquals(Double value, Double comparer, String code, Object... args) {
        if (value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBetween(Double value, Double from, Double to, String code, Object... args) {
        if (!(value > from && value < to)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNull(BigDecimal value, String code, Object... args) {
        if (value != null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isNotNull(BigDecimal value, String code, Object... args) {
        if (value == null) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isGreaterThan(BigDecimal value, BigDecimal comparer, String code, Object... args) {
        if (value.compareTo(comparer) <= 0) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isGreaterOrEqualsThan(BigDecimal value, BigDecimal comparer, String code, Object... args) {
        if (value.compareTo(comparer) < 0) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isLowerThan(BigDecimal value, BigDecimal comparer, String code, Object... args) {
        if (value.compareTo(comparer) >= 0) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isLowerOrEqualsThan(BigDecimal value, BigDecimal comparer, String code, Object... args) {
        if (value.compareTo(comparer) > 0) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areEquals(BigDecimal value, BigDecimal comparer, String code, Object... args) {
        if (!value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areNotEquals(BigDecimal value, BigDecimal comparer, String code, Object... args) {
        if (value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBetween(BigDecimal value, BigDecimal from, BigDecimal to, String code, Object... args) {
        if (!(value.compareTo(from) < 0 && value.compareTo(to) > 0)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isAfter(LocalDate value, LocalDate comparer, String code, Object... args) {
        if (value != null && comparer != null && !value.isAfter(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isAfterOrEquals(LocalDate value, LocalDate comparer, String code, Object... args) {
        if (value != null && comparer != null && !(value.isAfter(comparer) || value.equals(comparer))) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBefore(LocalDate value, LocalDate comparer, String code, Object... args) {
        if (value != null && comparer != null && !value.isBefore(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBeforeOrEquals(LocalDate value, LocalDate comparer, String code, Object... args) {
        if (value != null && comparer != null && !(value.isBefore(comparer) || value.equals(comparer))) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areEquals(LocalDate value, LocalDate comparer, String code, Object... args) {
        if (value != null && comparer != null && !value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areNotEquals(LocalDate value, LocalDate comparer, String code, Object... args) {
        if (value != null && value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isAfter(LocalTime value, LocalTime comparer, String code, Object... args) {
        if (value != null && comparer != null && !value.isAfter(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isAfterOrEquals(LocalTime value, LocalTime comparer, String code, Object... args) {
        if (value != null && comparer != null && !(value.isAfter(comparer) || value.equals(comparer))) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBefore(LocalTime value, LocalTime comparer, String code, Object... args) {
        if (value != null && comparer != null && !value.isBefore(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBeforeOrEquals(LocalTime value, LocalTime comparer, String code, Object... args) {
        if (value != null && comparer != null && !(value.isBefore(comparer) || value.equals(comparer))) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areEquals(LocalTime value, LocalTime comparer, String code, Object... args) {
        if (value != null && comparer != null && !value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areNotEquals(LocalTime value, LocalTime comparer, String code, Object... args) {
        if (value != null && value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isAfter(LocalDateTime value, LocalDateTime comparer, String code, Object... args) {
        if (value != null && comparer != null && !value.isAfter(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isAfterOrEquals(LocalDateTime value, LocalDateTime comparer, String code, Object... args) {
        if (value != null && comparer != null && !(value.isAfter(comparer) || value.equals(comparer))) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBefore(LocalDateTime value, LocalDateTime comparer, String code, Object... args) {
        if (value != null && comparer != null && !value.isBefore(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation isBeforeOrEquals(LocalDateTime value, LocalDateTime comparer, String code, Object... args) {
        if (value != null && comparer != null && !(value.isBefore(comparer) || value.equals(comparer))) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areEquals(LocalDateTime value, LocalDateTime comparer, String code, Object... args) {
        if (value != null && comparer != null && !value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }

    public FluentValidation areNotEquals(LocalDateTime value, LocalDateTime comparer, String code, Object... args) {
        if (value != null && value.equals(comparer)) {
            addNotification(code, args);
        }

        return this;
    }
}

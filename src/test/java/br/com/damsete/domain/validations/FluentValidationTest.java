package br.com.damsete.domain.validations;

import br.com.damsete.domain.NullObject;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FluentValidationTest {

    private static final String CODE = "code";
    private static final String ARGS = "args";

    @Test
    void testIsTrue() {
        var result = new FluentValidation().isTrue(false, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsFalse() {
        var result = new FluentValidation().isFalse(true, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNull() {
        Object object = new Object();

        var result = new FluentValidation().isNull(object, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNotNull() {
        var object = new NullObject();

        var result = new FluentValidation().isNotNull(object.getObject(), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNull1() {
        var result = new FluentValidation().isNull("value", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNotNull1() {
        var object = new NullObject();

        var result = new FluentValidation().isNotNull(object.getString(), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsEmpty() {
        var result = new FluentValidation().isEmpty("value", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNotEmpty() {
        var result = new FluentValidation().isNotEmpty("", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreEquals() {
        var result = new FluentValidation().areEquals("value", "text", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreNotEquals() {
        var result = new FluentValidation().areNotEquals("value", "value", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testHasMinLen() {
        var result = new FluentValidation().hasMinLen("value", 6, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testHasMaxLen() {
        var result = new FluentValidation().hasMaxLen("value", 1, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testHasLen() {
        var result = new FluentValidation().hasLen("value", 6, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testContains() {
        var result = new FluentValidation().contains("value", "text", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsEmail() {
        var result = new FluentValidation().isEmail("value", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsUsername() {
        var result = new FluentValidation().isUsername("#va+-90&*%$", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBoolean() {
        var result = new FluentValidation().isBoolean("value", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNumber() {
        var result = new FluentValidation().isNumber("value", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsDate() {
        var result = new FluentValidation().isDate("value", "dd/MM/yyyy", CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNullLong() {
        var result = new FluentValidation().isNull(0L, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNotNullLong() {
        Long object = null;

        var result = new FluentValidation().isNotNull(object, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsGreaterThanLong() {
        var result = new FluentValidation().isGreaterThan(0L, 1L, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsGreaterOrEqualsThanLong() {
        var result = new FluentValidation().isGreaterOrEqualsThan(0L, 1L, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsLowerThanLong() {
        var result = new FluentValidation().isLowerThan(1L, 0L, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsLowerOrEqualsThanLong() {
        var result = new FluentValidation().isLowerOrEqualsThan(1L, 0L, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreEqualsLong() {
        var result = new FluentValidation().areEquals(0L, 1L, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreNotEqualsLong() {
        var result = new FluentValidation().areNotEquals(0L, 0L, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBetweenLong() {
        var result = new FluentValidation().isBetween(11L, 0L, 10L, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNullInteger() {
        var result = new FluentValidation().isNull(0, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNotNullInteger() {
        Integer object = null;

        var result = new FluentValidation().isNotNull(object, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsGreaterThanInteger() {
        var result = new FluentValidation().isGreaterThan(0, 1, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsGreaterOrEqualsThanInteger() {
        var result = new FluentValidation().isGreaterOrEqualsThan(0, 1, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsLowerThanInteger() {
        var result = new FluentValidation().isLowerThan(1, 0, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsLowerOrEqualsThanInteger() {
        var result = new FluentValidation().isLowerOrEqualsThan(1, 0, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreEqualsInteger() {
        var result = new FluentValidation().areEquals(0, 1, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreNotEqualsInteger() {
        var result = new FluentValidation().areNotEquals(0, 0, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBetweenInteger() {
        var result = new FluentValidation().isBetween(11, 0, 10, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNullFloat() {
        var result = new FluentValidation().isNull(0f, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNotNullFloat() {
        Float object = null;

        var result = new FluentValidation().isNotNull(object, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsGreaterThanFloat() {
        var result = new FluentValidation().isGreaterThan(0f, 1f, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsGreaterOrEqualsThanFloat() {
        var result = new FluentValidation().isGreaterOrEqualsThan(0f, 1f, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsLowerThanFloat() {
        var result = new FluentValidation().isLowerThan(1f, 0f, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsLowerOrEqualsThanFloat() {
        var result = new FluentValidation().isLowerOrEqualsThan(1f, 0f, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreEqualsFloat() {
        var result = new FluentValidation().areEquals(0f, 1f, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreNotEqualsFloat() {
        var result = new FluentValidation().areNotEquals(0f, 0f, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBetweenFloat() {
        var result = new FluentValidation().isBetween(11f, 0f, 10f, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNullDouble() {
        var result = new FluentValidation().isNull(0D, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNotNullDouble() {
        Double object = null;

        var result = new FluentValidation().isNotNull(object, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsGreaterThanDouble() {
        var result = new FluentValidation().isGreaterThan(0D, 1D, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsGreaterOrEqualsThanDouble() {
        var result = new FluentValidation().isGreaterOrEqualsThan(0D, 1D, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsLowerThanDouble() {
        var result = new FluentValidation().isLowerThan(1D, 0D, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsLowerOrEqualsThanDouble() {
        var result = new FluentValidation().isLowerOrEqualsThan(1D, 0D, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreEqualsDouble() {
        var result = new FluentValidation().areEquals(0D, 1D, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreNotEqualsDouble() {
        var result = new FluentValidation().areNotEquals(0D, 0D, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBetweenDouble() {
        var result = new FluentValidation().isBetween(11D, 0D, 10D, CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNullBigDecimal() {
        var result = new FluentValidation().isNull(new BigDecimal("0.00"), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsNotNullBigDecimal() {
        var object = new NullObject();

        var result = new FluentValidation().isNotNull(object.getBigDecimal(), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsGreaterThanBigDecimal() {
        var result = new FluentValidation().isGreaterThan(new BigDecimal("0.00"), new BigDecimal("1.00"), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsGreaterOrEqualsThanBigDecimal() {
        var result = new FluentValidation().isGreaterOrEqualsThan(new BigDecimal("0.00"), new BigDecimal("1.00"), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsLowerThanBigDecimal() {
        var result = new FluentValidation().isLowerThan(new BigDecimal("1.00"), new BigDecimal("0.00"), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsLowerOrEqualsThanBigDecimal() {
        var result = new FluentValidation().isLowerOrEqualsThan(new BigDecimal("1.00"), new BigDecimal("0.00"), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreEqualsBigDecimal() {
        var result = new FluentValidation().areEquals(new BigDecimal("0.00"), new BigDecimal("1.00"), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreNotEqualsBigDecimal() {
        var result = new FluentValidation().areNotEquals(new BigDecimal("0.00"), new BigDecimal("0.00"), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBetweenBigDecimal() {
        var result = new FluentValidation().isBetween(new BigDecimal("11.00"), new BigDecimal("0.00"), new BigDecimal("10.00"), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsAfterLocalDate() {
        var result = new FluentValidation().isAfter(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 1, 2), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsAfterOrEqualsLocalDate() {
        var result = new FluentValidation().isAfterOrEquals(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 1, 2), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBeforeLocalDate() {
        var result = new FluentValidation().isBefore(LocalDate.of(2017, 1, 2), LocalDate.of(2017, 1, 1), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBeforeOrEqualsLocalDate() {
        var result = new FluentValidation().isBeforeOrEquals(LocalDate.of(2017, 1, 2), LocalDate.of(2017, 1, 1), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreEqualsLocalDate() {
        var result = new FluentValidation().areEquals(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 1, 2), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreNotEqualsLocalDate() {
        var result = new FluentValidation().areNotEquals(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 1, 1), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsAfterLocalTime() {
        var result = new FluentValidation().isAfter(LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 1), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsAfterOrEqualsLocalTime() {
        var result = new FluentValidation().isAfterOrEquals(LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 1), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBeforeLocalTime() {
        var result = new FluentValidation().isBefore(LocalTime.of(12, 0, 1), LocalTime.of(12, 0, 0), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBeforeOrEqualsLocalTime() {
        var result = new FluentValidation().isBeforeOrEquals(LocalTime.of(12, 0, 1), LocalTime.of(12, 0, 0), CODE, ARGS);
        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);

    }

    @Test
    void testAreEqualsLocalTime() {
        var result = new FluentValidation().areEquals(LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 1), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreNotEqualsLocalTime() {
        var result = new FluentValidation().areNotEquals(LocalTime.of(12, 0, 0), LocalTime.of(12, 0, 0), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsAfterLocalDateTime() {
        var result = new FluentValidation().isAfter(LocalDateTime.of(2017, 1, 1, 12, 0, 0), LocalDateTime.of(2017, 1, 1, 12, 0, 1), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsAfterOrEqualsLocalDateTime() {
        var result = new FluentValidation().isAfterOrEquals(LocalDateTime.of(2017, 1, 1, 12, 0, 0), LocalDateTime.of(2017, 1, 1, 12, 0, 1), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBeforeLocalDateTime() {
        var result = new FluentValidation().isBefore(LocalDateTime.of(2017, 1, 1, 12, 0, 1), LocalDateTime.of(2017, 1, 1, 12, 0, 0), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testIsBeforeOrEqualsLocalDateTime() {
        var result = new FluentValidation().isBeforeOrEquals(LocalDateTime.of(2017, 1, 1, 12, 0, 1), LocalDateTime.of(2017, 1, 1, 12, 0, 0), CODE, ARGS);
        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);

    }

    @Test
    void testAreEqualsLocalDateTime() {
        var result = new FluentValidation().areEquals(LocalDateTime.of(2017, 1, 1, 12, 0, 0), LocalDateTime.of(2017, 1, 1, 12, 0, 1), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }

    @Test
    void testAreNotEqualsLocalDateTime() {
        var result = new FluentValidation().areNotEquals(LocalDateTime.of(2017, 1, 1, 12, 0, 0), LocalDateTime.of(2017, 1, 1, 12, 0, 0), CODE, ARGS);

        assertTrue(result.invalid());
        assertThat(result.getNotifications()).hasSize(1);
    }
}

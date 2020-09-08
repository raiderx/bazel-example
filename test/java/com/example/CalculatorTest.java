package com.example;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CalculatorTest {

    private static final Logger log = LoggerFactory.getLogger(CalculatorTest.class);

    private Calculator calculator;
    private Clock clock;

    @Before
    public void setUp() {
        calculator = new Calculator();
        clock = Clock.tick(Clock.systemUTC(), Duration.ofMillis(1L));
    }

    @Test
    public void testSum() {
        int result = calculator.sum(2, 3);
        assertThat(result, is(5));
    }

    @Test
    public void testRuntime() {
        calculator.runtime();
        String now = Instant.now().toString();
        log.info("Now: {}", now);
    }

    @Test
    public void testInstant() {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendInstant(3).toFormatter();
        //DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        Instant now = clock.instant();
        String text = formatter.format(now);
        Instant result = Instant.parse(text);
        assertThat(result, is(now));
    }

    private static final String TEXT =
            "Man is distinguished, not only by his reason, but by this singular passion from other animals, " +
                    "which is a lust of the mind, that by a perseverance of delight in the continued and indefatigable " +
                    "generation of knowledge, exceeds the short vehemence of any carnal pleasure.";

    private static final String BASE64 =
            "TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlz" +
                    "IHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2Yg" +
                    "dGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGlu" +
                    "dWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRo" +
                    "ZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4=";

    @Test
    public void testBase64() {
        String result = DatatypeConverter.printBase64Binary(TEXT.getBytes());

        assertThat(result, is(BASE64));
    }

    @Test
    public void testBase64_2() {
        String result = new String(Base64.encodeBase64((TEXT).getBytes()));

        assertThat(result, is(BASE64));
    }

    private static final byte[] BYTES = "0123456789ABCDEFGHIJKLMNOPQRSTU".getBytes();
    private static final String HEX = "303132333435363738394142434445464748494A4B4C4D4E4F505152535455";

    @Test
    public void testHex() {
        String result = DatatypeConverter.printHexBinary(BYTES);
        assertThat(result, is(HEX));
    }

    @Test
    public void testHex2() {
        String result = new String(Hex.encodeHex(BYTES, false));
        assertThat(result, is(HEX));
    }
}

package time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00", "05:15:15", "05:59:59" })
	void testGetTotalHours(String candidate) {
		int hours = Time.getTotalHours(candidate);
		assertEquals(5, hours, "The hours were not calculated properly");
	}

	@Test
	void testGetTotalHoursBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			Time.getTotalHours("0");
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "12:05:00", "00:05:30", "23:05:59" })
	void testGetTotalMinutes(String candidate) {
		int minutes = Time.getTotalMinutes(candidate);
		assertEquals(5, minutes, "The minutes were not calculated properly");
	}

	@Test
	void testGetTotalMinutesBad() {
		assertThrows(NumberFormatException.class, () -> {
			Time.getTotalMinutes("12:05:00:10");
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "10:00:05", "00:15:05", "23:59:05" })
	void testGetSeconds(String candidate) {
		int seconds = Time.getSeconds(candidate);
		assertEquals(5, seconds, "The seconds were not calculated properly");
	}

	@Test
	void testGetSecondsBad() {
		assertThrows(NumberFormatException.class, () -> {
			Time.getSeconds("10:00:xx");
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "05:00:00:15", "10:15:30:15" })
	void testGetMilliseconds(String candidate) {
		int ms = Time.getMilliseconds(candidate);
		assertEquals(15, ms, "The milliseconds were not calculated properly");
	}

	@Test
	void testGetMillisecondsBad() {
		assertThrows(NumberFormatException.class, () -> {
			Time.getMilliseconds("05:00:00:15:999");
		});
	}

	@ParameterizedTest
	@ValueSource(strings = { "05:05:05" })
	void testGetTotalSeconds(String candidate) {
		int totalSeconds = Time.getTotalSeconds(candidate);
		assertEquals(18305, totalSeconds, "Total seconds were not calculated properly");
	}

	@Test
	void testGetTotalSecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, () -> {
			Time.getTotalSeconds("05:05");
		});
	}

	@Test
	void testGetAllMillisecondsGood() {
		int ms = Time.getAllMilliseconds("12:05:05:05");
		assertEquals(43505005, ms, "The total milliseconds were not calculated properly");
	}

}
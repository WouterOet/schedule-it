package oetw.scheduleit;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.List.of;

public class Main {

	public static void main(String[] args) {
		List<Scheduled> generated = new Generator(new Schedule("Schedule", false, YearMonth.of(2019, Month.JANUARY)), of(
				new Person("Pietje", of(LocalDate.of(2019, 1, 17	)), of(DayOfWeek.FRIDAY)),
				new Person("Henkje", emptyList(), emptyList())
		)).generate();

		generated
				.stream()
				.map(s -> s.getDate().toString() + ": " + s.getName())
				.forEach(System.out::println);
	}
}

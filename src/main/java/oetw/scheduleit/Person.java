package oetw.scheduleit;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Person {

	private final String name;
	private final List<DayOfWeek> excludedWeekDays;
	private final List<LocalDate> excludedDays;

	public Person(String name, List<LocalDate> excludedDays, List<DayOfWeek> excludedWeekDays) {
		this.name = name;
		this.excludedDays = excludedDays;
		this.excludedWeekDays = excludedWeekDays;
	}

	public String getName() {
		return name;
	}

	public List<DayOfWeek> getExcludedWeekDays() {
		return excludedWeekDays;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				'}';
	}

	public List<LocalDate> getExcludedDays() {
		return excludedDays;
	}
}

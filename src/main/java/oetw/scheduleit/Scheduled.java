package oetw.scheduleit;

import java.time.LocalDate;

public class Scheduled {

	private final LocalDate date;
	private final String name;

	public Scheduled(LocalDate date, String name) {
		this.date = date;
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getName() {
		return name;
	}
}

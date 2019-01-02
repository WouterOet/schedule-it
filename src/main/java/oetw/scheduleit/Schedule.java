package oetw.scheduleit;

import java.time.YearMonth;

public class Schedule {

	private final String name;
	private final boolean includeWeekends;
	private final YearMonth targetMonth;

	public Schedule(String name, boolean includeWeekends, YearMonth targetMonth) {
		this.name = name;
		this.includeWeekends = includeWeekends;
		this.targetMonth = targetMonth;
	}

	public String getName() {
		return name;
	}

	public boolean isIncludeWeekends() {
		return includeWeekends;
	}

	public YearMonth getTargetMonth() {
		return targetMonth;
	}

}

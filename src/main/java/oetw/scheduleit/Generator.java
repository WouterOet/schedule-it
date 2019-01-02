package oetw.scheduleit;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Generator {

	private final Schedule schedule;
	private final List<Person> persons;

	public Generator(Schedule schedule, List<Person> persons) {
		this.schedule = schedule;
		this.persons = persons;
	}

	private static class PersonWrapper implements Comparable<PersonWrapper>{
		private final Person person;
		private int count;

		private PersonWrapper(Person person) {
			this.person = person;
		}

		@Override
		public int compareTo(PersonWrapper o) {
			return comparingInt(PersonWrapper::getCount).thenComparing(pw -> pw.getPerson().getName()).compare(this, o);
		}

		private int getCount() {
			return count;
		}

		public Person getPerson() {
			return person;
		}
	}

	public List<Scheduled> generate() {
		List<Scheduled> selected = new ArrayList<>();

		List<PersonWrapper> counted = persons.stream().map(PersonWrapper::new).collect(toList());

		int days = schedule.getTargetMonth().lengthOfMonth();
		for (int i = 1; i <= days; i++) {
			final int j = i;

			LocalDate toScheduleDay = schedule.getTargetMonth().atDay(i);
			if(!schedule.isIncludeWeekends()) {
				DayOfWeek dayOfWeek = toScheduleDay.getDayOfWeek();
				if(dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
					continue;
				}
			}

			Collections.sort(counted);

			PersonWrapper personWrapper = counted
					.stream()
					.filter(pw -> notExcluded(pw, toScheduleDay))
					.findFirst()
					.orElseThrow();

			selected.add(new Scheduled(toScheduleDay, personWrapper.getPerson().getName()));
			personWrapper.count++;
		}

		return selected;
	}

	private boolean notExcluded(PersonWrapper personWrapper, LocalDate day) {
		return !(personWrapper.getPerson().getExcludedWeekDays().contains(day.getDayOfWeek())
				|| personWrapper.getPerson().getExcludedDays().contains(day));
	}
}

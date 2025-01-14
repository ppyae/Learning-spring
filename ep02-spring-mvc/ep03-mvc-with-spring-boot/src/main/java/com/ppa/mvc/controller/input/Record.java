package com.ppa.mvc.controller.input;

import java.time.DayOfWeek;
import java.time.LocalDate;

public record Record(
		DayOfWeek day,
		Integer value,
		LocalDate date) {

}
package com.example.DataBase.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DataBase.Repository.DefectInstanceRepository;
import com.example.DataBase.domain.SeverityAppPercent;
import com.example.DataBase.domain.WeeklyView;

@RestController
@RequestMapping("/WeeklyView")
public class WeeklyViewController {

	@Autowired
	private DefectInstanceRepository repository;

	@RequestMapping(value="1")
	public ArrayList<WeeklyView> getWeeklyView1() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Calendar.getInstance().getTime());
		calendar.add(Calendar.DATE, -7);
		return repository.getWeeklyView(dateformat.format(Calendar.getInstance().getTime()),
				dateformat.format(calendar.getTime()));

	}
	@RequestMapping(value="2")
	public ArrayList<WeeklyView> getWeeklyView2() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();

		calendar.setTime(Calendar.getInstance().getTime());
		calendar.add(Calendar.DATE, -7);
		calendar2.setTime(Calendar.getInstance().getTime());
		calendar2.add(Calendar.DATE, -14);
		return repository.getWeeklyView(dateformat.format(calendar.getTime()),dateformat.format(calendar2.getTime()));

	}
	@RequestMapping(value="3")
	public ArrayList<WeeklyView> getWeeklyView3() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();

		calendar.setTime(Calendar.getInstance().getTime());
		calendar.add(Calendar.DATE, -14);
		calendar2.setTime(Calendar.getInstance().getTime());
		calendar2.add(Calendar.DATE, -21);
		return repository.getWeeklyView(dateformat.format(calendar.getTime()),dateformat.format(calendar2.getTime()));

	}
	@GetMapping(value ="1/{app}")
	public ArrayList<WeeklyView> getTwoWeeklyView1(@PathVariable final String app) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(Calendar.getInstance().getTime());
		calendar.add(Calendar.DATE, -7);
		return repository.getTwoWeeklyView(dateformat.format(Calendar.getInstance().getTime()),
				dateformat.format(calendar.getTime()),app);
	}
	
	@GetMapping(value ="2/{app}")
	public ArrayList<WeeklyView> getTwoWeeklyView2(@PathVariable final String app) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();

		calendar.setTime(Calendar.getInstance().getTime());
		calendar.add(Calendar.DATE, -7);
		calendar2.setTime(Calendar.getInstance().getTime());
		calendar2.add(Calendar.DATE, -14);
		return repository.getTwoWeeklyView(dateformat.format(calendar.getTime()),
				dateformat.format(calendar2.getTime()),app);
	}
	
	@GetMapping(value ="3/{app}")
	public ArrayList<WeeklyView> getTwoWeeklyView3(@PathVariable final String app) {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();

		calendar.setTime(Calendar.getInstance().getTime());
		calendar.add(Calendar.DATE, -14);
		calendar2.setTime(Calendar.getInstance().getTime());
		calendar2.add(Calendar.DATE, -21);
		return repository.getTwoWeeklyView(dateformat.format(calendar.getTime()),
				dateformat.format(calendar2.getTime()),app);
	}
	
	

}
package com.comp301project.tableService;

import java.util.ArrayList;
import java.util.List;
import com.comp301project.AboutTime.TimeHandler;
import com.comp301project.Entity.table;

public class tableService {
	
	private List<table> alltables;
	private List<table> availabletables;
	private static tableService tableServiceSingleton;
	private tableService() {
		alltables=new ArrayList<table>();
		availabletables=new ArrayList<table>();
	}
	
	public static tableService gettableServiceInstance() {
		if(tableServiceSingleton==null) {
			tableServiceSingleton=new tableService();
		}
		return tableServiceSingleton;
	}
	
	public void addNewtable(table newtable) {
		alltables.add(newtable);
	}
	
	public List<table> getAlltables(){
		return alltables;
	}
	
	public List<table> getAvailabletables(){
		this.availabletables.clear();
		int currentTime=TimeHandler.getTimeHandlerObject().getCurrentHour();
		System.out.println("current h:"+currentTime);
		for(int i=0;i<alltables.size();i++) {
			if(this.alltables.get(i).isAvailableAtThisTime(currentTime)) {
				this.availabletables.add(alltables.get(i));
			}
		}
		return this.availabletables;
	}
	
	public table gettableById(String Id) {
		table table = null;
		for(int i=0;i<this.alltables.size();i++){
			if(alltables.get(i).gettableID().equals(Id)) {
				table=alltables.get(i);
			}
		}
		return table;
	}
	
}
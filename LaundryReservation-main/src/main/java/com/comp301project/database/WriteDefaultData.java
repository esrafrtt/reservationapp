package com.comp301project.database;

import java.util.ArrayList;
import java.util.Arrays;
import com.comp301project.Entity.table;
import com.comp301project.tableService.tableService;

public class WriteDefaultData {

	private static WriteDefaultData writeDefaultData;
	
	public static WriteDefaultData getInstance() {
		if(writeDefaultData==null) {
			writeDefaultData=new WriteDefaultData();
		}
		return writeDefaultData;
	}
	
	public void returnToDefaults() {
		try {
			tableService service=tableService.gettableServiceInstance();
			service.getAlltables().clear();
			Integer rh1[] = {4, 5, 8, 11, 12, 13, 17, 19, 20};
			Integer rh2[] = {0, 1, 3, 4, 7, 10, 12, 13, 14, 16, 17};
			Integer rh3[] = {4, 6, 7, 12, 13, 14, 18, 19, 23};
			Integer rh4[] = {1, 3, 5, 6, 9, 12, 13, 16, 19};
			Integer rh5[] = {3, 10, 12, 14, 16, 18, 20};
			Integer rh6[] = {0, 4, 12, 13, 21, 22, 23};
			Integer rh7[] = {3, 7, 12, 13, 15, 16, 17, 21};
			Integer rh8[] = {0, 6, 10, 11, 12, 14, 17, 19};
			table wm1=new table("1",5,new ArrayList<>(Arrays.asList(rh1)));
			table wm2=new table("2",7,new ArrayList<>(Arrays.asList(rh2)));
			table wm3=new table("3",9,new ArrayList<>(Arrays.asList(rh3)));
			table wm4=new table("4",3,new ArrayList<>(Arrays.asList(rh4)));
			table wm5=new table("5",10,new ArrayList<>(Arrays.asList(rh5)));
			table wm6=new table("6",8,new ArrayList<>(Arrays.asList(rh6)));
			table wm7=new table("7",2,new ArrayList<>(Arrays.asList(rh7)));
			table wm8=new table("8",5,new ArrayList<>(Arrays.asList(rh8)));
			service.addNewtable(wm1);
			service.addNewtable(wm2);
			service.addNewtable(wm3);
			service.addNewtable(wm4);
			service.addNewtable(wm5);
			service.addNewtable(wm6);
			service.addNewtable(wm7);
			service.addNewtable(wm8);
			/*service.addNewtable(wm1);
			service.addNewtable(wm2);
			service.addNewtable(wm3);
			service.addNewtable(wm4);
			service.addNewtable(wm5);
			service.addNewtable(wm6);
			service.addNewtable(wm7);
			service.addNewtable(wm8);*/
			WriteData.getWriter().save();
		}
		catch(Exception e){
			System.out.println("An error occurred at writing defaults!");
		}
	}
	
}
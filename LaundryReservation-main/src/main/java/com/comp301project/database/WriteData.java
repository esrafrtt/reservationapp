package com.comp301project.database;

import java.io.FileWriter;
import java.util.List;

import com.comp301project.tableService.tableService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.comp301project.Entity.table;

public class WriteData {

	private static FileWriter file;
	private static WriteData writer;
	
	public static WriteData getWriter() {
		if(writer==null) {
			writer=new WriteData();
		}
		return writer;
	}
	

	public void save() {
		List<table> alltables= tableService.gettableServiceInstance().getAlltables();
		JSONArray alltablesArray=new JSONArray();
		for(int i=0;i<alltables.size();i++) {
			JSONObject table = new JSONObject();
			table.put("tableID", alltables.get(i).gettableID());
			table.put("pricePerHour", alltables.get(i).getPricePerHour());
			List<Integer> reservedHours=alltables.get(i).getReservedHours();
			JSONArray reservedHoursArray = new JSONArray();
			for(int j=0;j<reservedHours.size();j++) {
				reservedHoursArray.add(reservedHours.get(j));
			}
			table.put("reservedHours", reservedHoursArray);
			alltablesArray.add(table);
		}
		handleSavingToFile(alltablesArray);
    }

	private void handleSavingToFile(JSONArray allMachines) {
		try {
			file = new FileWriter("LaundryDataset.json");
	        file.write(allMachines.toJSONString());
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		finally {
			try {
				file.flush();
		        file.close();
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
    }
	
}
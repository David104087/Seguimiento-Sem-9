package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.text.ParseException;


public class Project{
	
	private String projectName;
	private String clientName;
	private Calendar startDate;
	private Calendar endDate;
	private double budget;
	private String typeProject;

	private DateFormat formatter;

	public Project(String projectName, String clientName, double budget, String typeProject){
		
		this.formatter = new SimpleDateFormat("dd/M/yy");

		this.projectName = projectName;	
		this.clientName = clientName;
		this.typeProject = typeProject;
		this.budget = budget;
	}

	public String getProjectName(){
		return projectName;
	}
	
	public String getClientName(){
		return clientName;
	}

	public String getTypeProject(){
		return typeProject;
	}

	public Calendar getStartDate(){
		return startDate;
	}

    public double getBudget() {
        return budget;
    }
    
    public Calendar getEndDate() {
        return endDate;
    }

	public void setStartDate() {
        this.startDate = Calendar.getInstance();
    }
    
    public void setEndDate(int projectDuration) {
        this.endDate = (Calendar) this.startDate.clone();
        this.endDate.add(Calendar.MONTH, projectDuration);
    }
}



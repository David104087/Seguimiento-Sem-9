package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Controller {

	private Project[] projects;

	public Controller() {

		projects = new Project[10];
	
	}
	
	//Incomplete
	public String registerProject(String projectName, String clientName, int projectType, double budget, int projectDuration) {
		String msg = " fue creado exitosamente!!!";
		String typeProject = "";
		if (projectType == 1) {
			typeProject = "Desarrollo";
		}
		if (projectType == 2) {
			typeProject = "Mantenimiento";
		}
		if (projectType == 3) {
			typeProject = "Despliegue";
		}
        Project project = new Project(projectName, clientName, budget, typeProject);
        int pos = getFirstValidPosition();
		if(pos != -1){
			projects[pos] = project; 
			projects[pos].setStartDate();
            projects[pos].setEndDate(projectDuration);
		} 

		return msg;
	}

	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsAfterDate() {

		String msg = "";

		return msg;

	}
	
	//Incomplete
	// Date class also has their own before() and after() method
	public String searchProjectsBeforeDate() {

		String msg = "";

		return msg;

	}

	public int getFirstValidPosition(){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < 10 && !isFound; i++){
			if(projects[i] == null){
				pos = i; 
				isFound = true;
			}
		}
		return pos; 
	}

	public Project[] getProject(){
		return projects;
	}


}

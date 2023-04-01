package model;

import java.text.*;
import java.util.*;

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

	public String[] searchProjectsAfterDate(String dateCompare) throws ParseException {
		Calendar fecha = convertString(dateCompare);
		int sizeArray = getFirstValidPosition();
		if (sizeArray == -1){
			sizeArray = 10;
		}
	
		String[] proyectos = new String[sizeArray];
		int index = 0;
		for (int i = 0; i < sizeArray; i++) {
			if (projects[i].getStartDate().compareTo(fecha) > 0) {
				proyectos[index++] = projects[i].getProjectName();
			}
		}
	
		if (index == 0) {
			proyectos = new String[] {"Proyectos no encontrados"};
		} else if (index < sizeArray) {
			proyectos = Arrays.copyOf(proyectos, index);
		}
	
		return proyectos;
	}
	
	

	public Calendar convertString(String fechaProyecto) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar newDate = Calendar.getInstance();
		newDate.setTime(format.parse(fechaProyecto));

		return newDate;
	}
	
	

	public String[] searchProjectsBeforeDate(String dateCompare) throws ParseException {
		String[] projectNames = new String[10];
		Calendar fecha = convertString(dateCompare);
		int validProjects = getFirstValidPosition();
		int count = 0;
		if (validProjects == -1) {
			validProjects = 10;
		}
		for (int i = 0; i < validProjects; i++) {
			if (projects[i].getStartDate().compareTo(fecha) < 0) {
				projectNames[count] = projects[i].getProjectName();
				count++;
			}
		}
		if (count > 0) {
			String[] result = new String[count];
			for (int i = 0; i < count; i++) {
				result[i] = projectNames[i];
			}
			return result;
		} else {
			return new String[]{"No se encontraron proyectos antes de la fecha indicada."};
		}
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

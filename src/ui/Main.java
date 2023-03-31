package ui;

import java.util.*;
import model.Controller;
import java.text.*;


public class Main{

	private Scanner reader;
	private Controller controller;

	public Main() {

		this.reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {

		Main exe = new Main();
		int option = 0; 
		
        do{
            exe.menu(); 
            option = exe.validateIntegerInput(); //set exe. pa all methods as they need to be executed for that object
            exe.executeOption(option);

        }while(option != 0);


        exe.reader.close();

	}

	public void executeOption(int option){
        switch (option) {
            case 1:
            registerProject();
                break; 
            case 2:
			searchProjectsAfterDate();
                break; 
            case 0:
                System.out.println("See you soon!"); 
                break;
            case -1: 
                System.out.println("Invalid Option!"); 
                break; 

        }
    }

	// Incomplete
	public void menu() {
		System.out.println("                       -------------MENU------------");
        System.out.println("0. Exit"); 
        System.out.println("1. Create a project");
        System.out.println("2. Search a project after a date");
        System.out.println("3. Search a project before a date");
	}

	//Incomplete
	public void registerProject() {
		String projectName = ""; 
        String clientName = ""; 
		int projectType;
        double budget = 0;   
        int numProjects = 0;// counter with the number of projects, permite mostrar la informacion una vez se creo el proyecto
		int projectDuration = 0;
        System.out.println("                       -------------Welcome to the project management system------------");
        if (controller.getFirstValidPosition() != -1){
            System.out.println("Please provide the following information to create a new project:");        
            System.out.println("Enter the project name: "); 
            projectName = reader.nextLine(); 
            System.out.println("Enter the client name: "); 
            clientName = reader.next(); 
            reader.nextLine();
            System.out.println("Enter the project type: "); 
			System.out.println("1. Desarrollo"); 
			System.out.println("2. Mantenimiento "); 
			System.out.println("3. Despliegue"); 
            projectType = reader.nextInt(); 
            reader.nextLine();
            System.out.println("Enter the project budget: "); 
            budget = reader.nextDouble(); 
            reader.nextLine();
			System.out.println("Enter the project duration in months: "); 
            projectDuration = reader.nextInt(); 
            reader.nextLine();
            String msg = controller.registerProject(projectName, clientName, projectType, budget, projectDuration);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            
            System.out.println("****    Project " + projectName + msg + "    ****");
            System.out.println("------Project Details------");
			System.out.println("Project Name: " + controller.getProject()[numProjects].getProjectName());
            System.out.println("Project start planned date: " + dateFormat.format(controller.getProject()[numProjects].getStartDate().getTime())); 
            System.out.println("Project final planned date: " + dateFormat.format(controller.getProject()[numProjects].getEndDate().getTime()));
            System.out.println("Client Name: " + controller.getProject()[numProjects].getClientName());
            System.out.println("Client project type: " + controller.getProject()[numProjects].getTypeProject());
            System.out.println("Budget: $" + (int) controller.getProject()[numProjects].getBudget());


			numProjects++;
        } else {
            System.out.println("Límite de proyectos alcanzado :(");
        }


	}

	//Incomplete
	public void searchProjectsAfterDate() {
		Calendar dateProjectAfter;
		System.out.println("Enter the date: "); 
		dateProjectAfter = reader.next(); 
		reader.nextLine();
		String[] msg = controller.searchProjectsAfterDate(dateProjectAfter);
		System.out.println("Projects after the date:");




	}
	
	//Incomplete
	public void searchProjectsBeforeDate() {

	}

	public int validateIntegerInput(){
        int option = 0; 
        if(reader.hasNextInt()){
            option = reader.nextInt(); 
            reader.nextLine();
        }
        else{
            reader.nextLine();// clear the scanner 
            option = -1; 
            System.out.println("Enter an integer value"); 
        }
        return option; 
    }
}

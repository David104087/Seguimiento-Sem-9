package ui;

import java.util.*;
import model.Controller;
import java.text.*;


public class Main{

	private Scanner reader;
	private Controller controller;
    private int numProjects;// counter with the number of projects, permite mostrar la informacion una vez se creo el proyecto


	public Main() {

		this.reader = new Scanner(System.in);
		controller = new Controller();
        numProjects = 0;
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
            case 3:
            searchProjectsBeforeDate();
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
            if (projectType < 1 || projectType > 3) {
                System.out.println("Please enter a valid project type (1-3): ");
                projectType = reader.nextInt();
            }            
            
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
            System.out.println("Project limit reached :(");
        }


	}

	//Incomplete
    public void searchProjectsAfterDate() {
        String dateProjectAfter;
        System.out.println("Enter the date(dd/mm/yyyy): "); 
        dateProjectAfter = reader.next(); 
        reader.nextLine();
        try {
            String[] projectNames = controller.searchProjectsAfterDate(dateProjectAfter);
            System.out.println("Projects after the date: ");
            for (int i = 0; i < projectNames.length; i++) {
                System.out.println("Project " + (i+1) + ": " + projectNames[i]);
            }
        } catch (ParseException e) {
            System.out.println("Invalid format");
        }
    }    
	
	//Incomplete
	public void searchProjectsBeforeDate() {
        String dateProjectAfter;
        System.out.println("Enter the date(dd/mm/yyyy): "); 
        dateProjectAfter = reader.next(); 
        reader.nextLine();
        try {
            String[] projectNames = controller.searchProjectsBeforeDate(dateProjectAfter);
            System.out.println("Projects after the date: ");
            for (int i = 0; i < projectNames.length; i++) {
                System.out.println("Project " + (i+1) + ": " + projectNames[i]);
            }
        } catch (ParseException e) {
            System.out.println("Invalid format");
        }
	}

	public int validateIntegerInput() {
        int option = 0; 
        if(reader.hasNextInt()){
            option = reader.nextInt(); 
            reader.nextLine();
        }
        else{
            reader.nextLine(); 
            option = -1; 
            System.out.println("Enter an integer value"); 
        }
        return option; 
    }
}

package taskmanager;

import java.util.ArrayList;
import java.util.Date;

public class TaskManager {
	
	private ArrayList<Task> tasks;
	private ArrayList<Student> students;
	private ArrayList<Category> categories;
	private int taskCounter;
	
	public TaskManager() {
		this.tasks = new ArrayList<Task>();
		this.students = new ArrayList<Student>();
		this.categories = new ArrayList<Category>();
		this.taskCounter = 1;
	}
	
	public void addCategory(Category category) {
		categories.add(category);
	}
	
	public ArrayList<Category> getAllCategories() {
		return categories;
	}
	
	public Category getCategoryByID(int categoryID) {
		for(Category cat : categories) {
			if(cat.getCategoryID() == categoryID) {
				return cat;
			}
		}
		return null;
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public ArrayList<Student> getAllStudents() {
		return students;
	}
	
	public Student getStudentByID(int studentID) {
		for(Student student : students) {
			if(student.getStudentID() == studentID) {
				return student;
			}
		}
		return null;
	}
	
	public Task createTask(String title, String description, Date dueDate) {
		Task newTask = new Task(taskCounter++, title, description, dueDate);
		tasks.add(newTask);
		return newTask;
	}
	
	public void deleteTask(int taskID) {
		for(int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i).getTaskID() == taskID) {
				tasks.remove(i);
				break;
			}
		}
	}
	
	public void editTask(int taskID, String newTitle, Date newDueDate) {
		Task task = getTaskByID(taskID);
		if(task != null) {
			task.setTitle(newTitle);
			task.setDueDate(newDueDate);
		}
	}
	
	public void displayAllTasks() {
		if(tasks.isEmpty()) {
			System.out.println("No tasks available.");
			return;
		}
		for(Task task : tasks) {
			System.out.println(task.getTaskID() + ". " + task.getTitle() + 
				" - " + (task.getStatus() ? "COMPLETED" : "PENDING"));
		}
	}
	
	public void completeTask(int taskID) {
		Task task = getTaskByID(taskID);
		if(task != null) {
			task.markComplete();
		}
	}
	
	public Task getTaskByID(int taskID) {
		for(Task task : tasks) {
			if(task.getTaskID() == taskID) {
				return task;
			}
		}
		return null;
	}
	
	public ArrayList<Task> getAllTasks() {
		return tasks;
	}
	
	public ArrayList<Task> getTasksByStudent(int studentID) {
		Student student = getStudentByID(studentID);
		if(student != null) {
			return student.getTasks();
		}
		return new ArrayList<Task>();
	}
	
}

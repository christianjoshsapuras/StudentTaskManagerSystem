package taskmanager;

import java.util.ArrayList;

public class Student {
	
	private int studentID;
	private String name;
	private ArrayList<Task> tasks;
	
	
	public Student(int studentID, String name) {
		this.studentID = studentID;
		this.name = name;
		this.tasks = new ArrayList<Task>();
	}
	
	
	public int getStudentID() {
		return studentID;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Task> getTasks() {
		return tasks;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void addTask(Task task) {
		tasks.add(task);
	}
	
	public void removeTask(int taskID) {
		for(int i = 0; i < tasks.size(); i++) {
			if(tasks.get(i).getTaskID() == taskID) {
				tasks.remove(i);
				break;
			}
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
	
}

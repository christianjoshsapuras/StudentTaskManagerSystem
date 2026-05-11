package taskmanager;

import java.util.ArrayList;

public class TaskManager {

	private ArrayList<Task> tasks;
	private int taskCounter;

	public TaskManager() {
		tasks = new ArrayList<Task>();
		taskCounter = 1;
	}

	public Task createTask(String title, String description, String dueDate, String categoryName) {
		Category category = new Category(categoryName);
		Task task = new Task(taskCounter, title, description, dueDate, category);
		tasks.add(task);
		taskCounter++;
		return task;
	}

	public Task getTaskByID(int taskID) {
		for(Task task : tasks) {
			if(task.getTaskID() == taskID) {
				return task;
			}
		}
		return null;
	}

	public void editTask(int taskID, String title, String description, String dueDate, String categoryName) {
		Task task = getTaskByID(taskID);

		if(task != null) {
			task.setTitle(title);
			task.setDescription(description);
			task.setDueDate(dueDate);
			task.setCategory(new Category(categoryName));
		}
	}

	public void deleteTask(int taskID) {
		Task task = getTaskByID(taskID);

		if(task != null) {
			tasks.remove(task);
		}
	}

	public void completeTask(int taskID) {
		Task task = getTaskByID(taskID);

		if(task != null) {
			task.markComplete();
		}
	}

	public void displayAllTasks() {
		if(tasks.isEmpty()) {
			System.out.println("No tasks available.");
		} else {
			for(Task task : tasks) {
				System.out.println(task.getTaskID() + ". " + task.getTitle() +
					" (" + task.getCategory().getName() + ")" +
					" - Due: " + task.getDueDate() +
					" - " + (task.getStatus() ? "COMPLETED" : "PENDING"));
			}
		}
	}
}

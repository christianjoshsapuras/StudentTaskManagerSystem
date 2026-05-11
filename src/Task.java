package taskmanager;

public class Task {
	
	private int taskID;
	private String title;
	private String description;
	private String dueDate;
	private boolean status;
	private Category category;
	
	public Task(int taskID, String title, String description, String dueDate, Category category) {
		this.taskID = taskID;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.category = category;
		this.status = false;
	}
	
	public int getTaskID() {
		return taskID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public void markComplete() {
		status = true;
	}
	
	public void markIncomplete() {
		status = false;
	}
}

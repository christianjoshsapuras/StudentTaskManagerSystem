package taskmanager;
import java.util.Date;

public class Task {
  
	private int taskID;
	private String title;
	private String description;
	private Date dueDate;
	private boolean status;

  
	public Task(int taskID, String title, String description, Date dueDate) {
		this.taskID = taskID;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.status = false;
  }

}

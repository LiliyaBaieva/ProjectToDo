import java.time.LocalDate;

public class Task {

  // Map <Status> (считывание статуса) - для того чтоб человек выбрал
  // readTask
  // добавить id
  private final LocalDate dateOfCreate;
  private String taskName;
  private String taskDescription;
  private boolean importance;
  private boolean urgent;
  private String status;


  public Task(LocalDate dateOfCreate, String taskName, String taskDescription, boolean importance, boolean importance1, boolean urgent, String status) {
    this.dateOfCreate = dateOfCreate;
    this.taskName = taskName;
    this.taskDescription = taskDescription;
    this.status = status;
    this.importance = false;
    this.urgent = false;
  }

  public Task(LocalDate dateOfCreate, String taskName, boolean importance, boolean importance1, boolean urgent, String status) {
    this.dateOfCreate = dateOfCreate;
    this.taskName = taskName;
    this.status = status;
    this.importance = false;
    this.urgent = false;
  }

  public LocalDate getDateOfCreate() {
    return dateOfCreate;
  }

  public String getTaskName() {
    return taskName;
  }

  public String getTaskDescription() {
    return taskDescription;
  }

  public boolean isImportance() {
    return importance;
  }

  public boolean isUrgent() {
    return urgent;
  }

  public String getStatus() {
    return status;
  }
  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
  }

  public void setImportance(boolean importance) {
    this.importance = importance;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}

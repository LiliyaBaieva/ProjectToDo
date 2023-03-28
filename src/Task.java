import java.time.LocalDate;

public class Task {

  // Map <Status> (считывание статуса) - для того чтоб человек выбрал
  // readTask
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
    this.importance = true;
    this.urgent = true;
  }

  public Task(LocalDate dateOfCreate, String taskName, boolean importance, boolean importance1, boolean urgent, String status) {
    this.dateOfCreate = dateOfCreate;
    this.taskName = taskName;
    this.status = status;
    this.importance = true;
    this.urgent = true;
  }
}

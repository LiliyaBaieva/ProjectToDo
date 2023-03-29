import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;

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


  public Task(LocalDateTime dateOfCreate, String taskName, String taskDescription,
              boolean importance, boolean urgent, String status) {
    this.dateOfCreate = LocalDate.from(dateOfCreate);
    this.taskName = taskName;
    this.taskDescription = taskDescription;
    this.status = status;
    this.importance = false;
    this.urgent = false;
  }

  public Task(LocalDate dateOfCreate, String taskName,
              boolean importance, boolean urgent, String status) {
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

  public boolean getImportance() {
    return importance;
  }

  public boolean getUrgent() {
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

  public Task TaskCreator() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    LocalDateTime dateOfCreate = LocalDateTime.now();

    System.out.print("Введите название задачи: ");
    String taskName = br.readLine();

    System.out.print("Введите описание задачи: ");
    String taskDescription = br.readLine();

    System.out.print("Введите: /n'1' если задача важная " +
        "/n'2' если задача не важная/n");
    int importanceInt = Integer.parseInt(br.readLine());
    boolean a = false;
    boolean importance = false;
    do {
      if (importanceInt == 1) {
        importance = true;
        a = true;
      } else {
        if (importanceInt == 2) {
          a = true;
        } else {
          System.out.println("Введите: /n'1' если задача важная " +
              "/n'2' если задача не важная/n");
        }
      }
    } while (!a);

    System.out.print("Введите: /n'1' если задача срочная " +
        "/n'2' если задача не срочная/n");
    int urgentInt = Integer.parseInt(br.readLine());
    boolean b = false;
    boolean urgent = false;
    do {
      if (urgentInt == 1) {
        urgent = true;
        b = true;
      } else {
        if (urgentInt == 2) {
          b = true;
        } else {
          System.out.println("Введите: /n'1' если задача срочная " +
              "/n'2' если задача не срочная/n");
        }
      }
    } while (!b);

    System.out.print("Введите: /n'1' если задача не начата (status 'to do')" +
        "/n'2' если задача выполняется (status 'in process')" +
        "/n'3' если задача завершена (status 'done')/n");
    int statusInt = Integer.parseInt(br.readLine());
    boolean c = false;
    String status = null;
    do {
      if (statusInt == 1) {
        status = "to do";
        c = true;
      } else {
        if (statusInt == 2) {
          status = "in process";
          c = true;
        } else {
          if (statusInt == 3) {
            status = "done";
            c = true;
          } else {
            System.out.print("Введите: /n'1' если задача не начата (status 'to do')" +
                "/n'2' если задача выполняется (status 'in process')" +
                "/n'3' если задача завершена (status 'done')/n");
          }
        }
      }
    } while (!c);

    return new Task(dateOfCreate, taskName, taskDescription, importance, urgent, status);
  }
}


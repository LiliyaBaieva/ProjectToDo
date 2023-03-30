import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;


public class Task {

  private final LocalDate dateOfCreate;
  private String taskName;
  private String taskDescription;
  private Boolean importance;
  private Boolean urgent;

  private String status;


  public Task(LocalDate dateOfCreate, String taskName, String taskDescription,
              Boolean importance, Boolean urgent, String status) {
    this.dateOfCreate = LocalDate.from(dateOfCreate);
    this.taskName = taskName;
    this.taskDescription = taskDescription;
    this.status = status;
    this.importance = false;
    this.urgent = false;

  }


  public Task(LocalDate dateOfCreate, String taskName,
              Boolean importance, Boolean urgent, String status) {
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

  public Boolean getImportance() {
    return importance;
  }

    public Boolean getUrgent() {
    return urgent;
  }
public String getUrgentString() {
  String urgentString;
  if (urgent = true) {
      urgentString = "срочная";
  } urgentString = "не срочная";
    return urgentString;
}

  public String getImportanceString() {
    String importanceString;
    if (importance = true) {
      importanceString = "срочная";
    }
    importanceString = "не срочная";
    return importanceString;
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

  public void setImportance(Boolean importance) {
    this.importance = importance;
  }

  public void setUrgent(Boolean urgent) {
    this.urgent = urgent;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public static Task taskCreator() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    LocalDate dateOfCreate = LocalDate.now();

    System.out.print("Введите название задачи: ");
    String taskName = br.readLine();

    System.out.print("Введите описание задачи: ");
    String taskDescription = br.readLine();

    System.out.print("""
        Введите:\s
        '1' если задача важная\s
        '2' если задача не важная
        """);
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
          System.out.println("""
              Введите:\s
              '1' если задача важная\s
              '2' если задача не важная
              """);
        }
      }
    } while (!a);

    System.out.print("""
        Введите:\s
        '1' если задача срочная\s
        '2' если задача не срочная
        """);
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
          System.out.println("""
              Введите:\s
              '1' если задача срочная\s
              '2' если задача не срочная
              """);
        }
      }
    } while (!b);

    System.out.print("""
        Введите:\s
        '1' если задача не начата (status 'to do')
        '2' если задача выполняется (status 'in process')
        '3' если задача завершена (status 'done')
        """);
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
            System.out.print("""
                Введите:\s
                '1' если задача не начата (status 'to do')
                '2' если задача выполняется (status 'in process')
                '3' если задача завершена (status 'done')
                """);
          }
        }
      }
    } while (!c);

    return new Task(dateOfCreate, taskName, taskDescription, importance, urgent, status);
  }


  @Override
  public String toString() {
    return "Task{" + "dateOfCreate= " + getDateOfCreate() +
        "taskName= " + getTaskName() +
        "taskDescription= " + getTaskDescription() +
        "importanceString= " + getImportanceString() +
        "urgentString= " + getUrgentString() +
        "status= " + getStatus() +
        "}" + "\n";
  }
}


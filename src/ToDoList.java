import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ToDoList {

  final public static String SEP = "; ";
  public static void  addTaskInToDoFile() throws IOException {
    File toDoFile = new File("res/toDoFile.txt");

    FileWriter fileWriter = new FileWriter("res/toDoFile.txt");
    if(!toDoFile.exists()){
      toDoFile.createNewFile();
    }
    Task task = Task.taskCreator();
    String total = String.format(task.getDateOfCreate() + SEP + task.getTaskName() + SEP + task.getTaskDescription() +SEP + task.getImportance() +
        SEP + task.getUrgent() + SEP + task.getStatus());
    fileWriter.write(String.valueOf(total));
    fileWriter.close();
  }


  // вывод на экран сортировка по умолчанию: дата, время
  public static void  printToDoList() throws IOException {

    Parser.parser().sort(new TaskDateNameComparator());
    for(Task task : Parser.parser()){
      System.out.println(task);
    }
  }

// вывод только to do
  public static void printWithStatusToDo() throws IOException{
    for(Task task : Parser.parser()){
      if(task.getStatus().equals("to do")){
        System.out.println(task);
      }
    }
  }

// вывод только in process
  public static void printWithStatusInProcess() throws IOException{
    for(Task task : Parser.parser()){
      if(task.getStatus().equals("in process")){
        System.out.println(task);
      }
    }
  }

// вывод только done
  public static void printWithStatusDone() throws IOException{
    for(Task task : Parser.parser()){
      if(task.getStatus().equals("done")){
        System.out.println(task);
      }
    }
  }


//  public static void print
}

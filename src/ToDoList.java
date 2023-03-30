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


//  public static void print
}

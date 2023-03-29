import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Parcing {

  public static void main(String[] args) throws IOException {
    Parcing.parcing();
  }
  final public static String SEP = "; ";

  public static List<Task> parcing() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("res/toDoFile.txt"));

    List<Task> listToDo = new ArrayList<>();

    for (String line = br.readLine(); line != null; line = br.readLine()) {
      int lastSep = line.indexOf(SEP);

//      String line1 = line.substring(0, lastSep);
//      System.out.println("line1  " + line1);
//      Long line2 = Long.parseLong(line1);
//      System.out.println("line2  " + line2);
//      LocalDate dateOfCreate = LocalDate.ofEpochDay(line2);
//      System.out.println("dateOfCreate  " + dateOfCreate);

//      LocalDate dateOfCreate = LocalDate.ofEpochDay(Long.parseLong(line.substring(0, lastSep)));
      LocalDate dateOfCreate = LocalDate.ofEpochDay(2018-11-11);
      line = line.substring(lastSep + 2);
      lastSep = line.indexOf(SEP);

      String taskName = line.substring(0, lastSep);
      line = line.substring(lastSep + 2);
      lastSep = line.indexOf(SEP);

      String taskDescription = line.substring(0, lastSep);
      line = line.substring(lastSep + 2);
      lastSep = line.indexOf(SEP);

      Boolean importance = Boolean.valueOf(line.substring(0, lastSep));
      line = line.substring(lastSep + 2);
      lastSep = line.indexOf(SEP);

      Boolean urgent = Boolean.valueOf(line.substring(0, lastSep));
      String status = line.substring(lastSep + 2);

      Task readedTask =  new Task(dateOfCreate, taskName, taskDescription, importance,
          urgent, status);
      listToDo.add(readedTask);
    }
    System.out.println(listToDo);

    br.close();

    return listToDo;
  }
}

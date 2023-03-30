import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Parser {

//  public static void main(String[] args) throws IOException {
//    Parser.parser();
//  }

  final public static String SEP = "; ";

  public static List<Task> parser() throws IOException {

      File toDoFile = new File("res/toDoFile.txt");
      if (!toDoFile.exists()) {
        System.out.println("Файл не найден. Создайте задачи и потом прочитайте.");
        Menu.menuStart();
      }

      BufferedReader br = new BufferedReader(new FileReader("res/toDoFile.txt"));
      List<Task> listToDo = new ArrayList<>();

      for (String line = br.readLine(); line != null; line = br.readLine()) {
        int lastSep = line.indexOf(SEP);

        LocalDate dateOfCreate = LocalDate.parse(line.substring(0, lastSep));
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

        Task readedTask = new Task(dateOfCreate, taskName, taskDescription, importance,
            urgent, status);
        listToDo.add(readedTask);

//      System.out.println(readedTask);
      }
//    System.out.println(listToDo);

      br.close();

      return listToDo;
    }
  }

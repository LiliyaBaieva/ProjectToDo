import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DelTask {

  final public static String SEP = "; ";

  public static void delTaskInToDoFile() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<Task> toDoList = new ArrayList<>(Parser.parser());

    for (int i = 0; i < toDoList.size(); ++i) {
      System.out.println(((i + 1) + ". " + toDoList.get(i)));
    }

    System.out.printf("Введите номер удаляемого задания от 1 до %d:  -  ", toDoList.size());
    int indexDelTask = Integer.parseInt(br.readLine());
    toDoList.remove(indexDelTask - 1);

    System.out.println("List after del Task");
    for (int i = 0; i < toDoList.size(); ++i) {
      System.out.println(((i + 1) + ". " + toDoList.get(i)));
    }

    //перезаписать в файл
    File toDoFile = new File("res/toDoFile.txt");

    FileWriter fileWriter = new FileWriter("res/toDoFile.txt");
    if(!toDoFile.exists()){
      toDoFile.createNewFile();
    }

    for (int i = 0; i < toDoList.size(); ++i) {
      fileWriter.write(String.valueOf(toDoList.get(i)));
    }

    fileWriter.close();

    //выбор следующего действия
    System.out.println("Нажмите 1 если продолжить удаление и 2 для выхода в меню");

    int vybor = Integer.parseInt(br.readLine());
    if (vybor == 1) {
      delTaskInToDoFile();
    }

    Menu.menuStart();
  }
}


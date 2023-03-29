import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
  /*
   * Class Menu - Меню
   -добавить запись
   -изменить запись
   -вывести задачи на экран
    1. все задачи
    2. To do (нужно сделать)
    3. In progress (делаю)
    4. Done (сделано)
   -удалить запись
   - Выйти

  * Класс Task _ НАДЯ
     // Map <Status> (считывание статуса) - для того чтоб человек выбрал
     // readTask

  * Comparator
    - TaskStatusComparator
    - TaskImportanceComparator
    - TaskUrgentComparator
    - TaskDateNameComparator

  * Прочитать и записать в файл

  * TaskTest  ,  ComparatorTest
  */
  public static void main(String[] args) throws IOException {
    // чтение файла
    Menu.menuStart();

  }

  public static void  printToDoList(){
//    BufferedReader fileReader = new BufferedReader(new FileReader(toDoFile));
//    List<Task> toDoList = new ArrayList<>();
  }

  public static void  addTaskInToDoFile(List toDoList) throws IOException{
    File toDoFile = new File("res/toDoFile.txt");

    FileWriter fileWriter = new FileWriter("res/toDoFile.txt");
    if(!toDoFile.exists()){
      toDoFile.createNewFile();
    }
    Task task = Task.taskCreator();
    fileWriter.write(String.valueOf(task));
    fileWriter.close();
  }

}







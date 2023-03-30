import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
  final public static String SEP = "; ";

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
//    while (Menu.numMenu != 5){
//    }
    Menu.menuStart();


  }

//
  public static void  addTaskInToDoFile() throws IOException{
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

  public static void  printToDoList() throws IOException {


    for(Task task : Parser.parser()){
       System.out.println(task);
     }
  }

}







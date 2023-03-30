import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoList {

  final public static String SEP = "; ";
  public static void  addTaskInToDoFile() throws IOException {
    File toDoFile = new File("res/toDoFile.txt");

    FileWriter fileWriter = new FileWriter("res/toDoFile.txt", true);
    if(!toDoFile.exists()){
      toDoFile.createNewFile();
    }
    Task task = Task.taskCreator();
    String total = String.format(task.getDateOfCreate() + SEP + task.getTaskName() + SEP + task.getTaskDescription() +SEP + task.getImportance() +
        SEP + task.getUrgent() + SEP + task.getStatus() + "\n");
    fileWriter.write(String.valueOf(total));
    fileWriter.close();

    System.out.println("Нажмите 1 для добавление ещё одной записи и 2 для выхода в меню");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int vybor = Integer.parseInt(br.readLine());
    if (vybor == 1) {
      addTaskInToDoFile();
    }
    Menu.menuStart();
  }


  // вывод на экран сортировка по умолчанию: дата, время
  public static void  printToDoList() throws IOException {

    Parser.parser().sort(new TaskDateNameComparator());
    for(Task task : Parser.parser()){
      System.out.println(task);
    }
    Menu.menuStart();
  }

// вывод только to do
  public static void printWithStatusToDo() throws IOException{
    Parser.parser().sort(new TaskDateNameComparator());
    for(Task task : Parser.parser()){
      if(task.getStatus().equals("to do")){
        System.out.println(task);
      }
    }
    Menu.menuStart();
  }

// вывод только in process
  public static void printWithStatusInProcess() throws IOException{
    Parser.parser().sort(new TaskDateNameComparator());
    for(Task task : Parser.parser()){
      if(task.getStatus().equals("in process")){
        System.out.println(task);
      }
    }
    Menu.menuStart();
  }

// вывод только done
  public static void printWithStatusDone() throws IOException{
    Parser.parser().sort(new TaskDateNameComparator());
    for(Task task : Parser.parser()){
      if(task.getStatus().equals("done")){
        System.out.println(task);
      }
    }
    Menu.menuStart();
  }

  public static void printUrgentTask() throws IOException{
    Parser.parser().sort(new TaskDateNameComparator());
    for(Task task : Parser.parser()){
      if(task.getUrgent() == true){
        System.out.println(task);
      }
    }
    Menu.menuStart();
  };

// печать только важных
  public static void printImportanceTask() throws IOException {
    Parser.parser().sort(new TaskDateNameComparator());
    for(Task task : Parser.parser()){
      if(task.getImportance() == true){
        System.out.println(task);
      }
    }
    Menu.menuStart();
  };



//  public static void print

  public static void delTaskInToDoFile() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<Task> toDoList = new ArrayList<>(Parser.parser());
//    List<Task> toDoList = Parser.parser();

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
      Task task = toDoList.get(i);
      String total = String.format(task.getDateOfCreate() + SEP + task.getTaskName() + SEP + task.getTaskDescription() +SEP + task.getImportance() +
          SEP + task.getUrgent() + SEP + task.getStatus()) + "\n";
      fileWriter.write(String.valueOf(total));
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

  public static void taskChange() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<Task> toDoList = new ArrayList<>(Parser.parser());

    for (int i = 0; i < toDoList.size(); ++i) {
      System.out.println(((i + 1) + ". " + toDoList.get(i)));
    }

    System.out.printf("Введите номер редактируемого задания от 1 до %d:  -  ", toDoList.size());
    int indexChangeTask = Integer.parseInt(br.readLine());
    System.out.printf("Вы хотите изменить запись %d: - ", toDoList.get(indexChangeTask - 1));


    System.out.println("""
         Выберите, какую часть записи изменить:\s
         '1' название (taskName)\s
         '2' описание (taskDescription)\s
         '3' важность (importance)\s
         '4' срочность (urgent)\s
         '5' статус (status)\s
        """);
    int partChangeTask = 0;
    boolean change = false;
    try {
      partChangeTask = Integer.parseInt(br.readLine());
    } catch (NumberFormatException e) {
      System.err.println("Неправильный формат числа: " + e.getMessage());
    }
    do {
      if (partChangeTask == 1) {
        change = true;
        System.out.println("введите новое название задачи ");
        toDoList.get(indexChangeTask - 1).setTaskName(br.readLine());
      } else {
        if (partChangeTask == 2) {
          change = true;
          System.out.println("введите новое описание задачи ");
          toDoList.get(indexChangeTask - 1).setTaskDescription(br.readLine());
        } else {
          if (partChangeTask == 3) {
            change = true;
            System.out.print("""
                Введите:\s
                '1' если задача важная\s
                '2' если задача не важная
                """);
            int importanceInt = 0;
            boolean a = false;
            try {
              importanceInt = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
              System.err.println("Неправильный формат числа: " + e.getMessage());
            }
            do {
              if (importanceInt == 1) {
                toDoList.get(indexChangeTask - 1).setImportance(true);
                a = true;
              } else {
                if (importanceInt == 2) {
                  toDoList.get(indexChangeTask - 1).setImportance(false);
                  a = true;
                } else {
                  System.out.println("""
                      Введите:\s
                      '1' если задача важная\s
                      '2' если задача не важная
                      """);
                  importanceInt = Integer.parseInt(br.readLine());
                }
              }
            } while (!a);

          } else {
            if (partChangeTask == 4) {
              change = true;
              System.out.print("""
                  Введите:\s
                  '1' если задача срочная\s
                  '2' если задача не срочная
                  """);
              int urgentInt = 0;
              boolean b = false;
              try {
                urgentInt = Integer.parseInt(br.readLine());
              } catch (NumberFormatException e) {
                System.err.println("Неправильный формат числа: " + e.getMessage());
              }
              do {
                if (urgentInt == 1) {
                  toDoList.get(indexChangeTask - 1).setUrgent(true);
                  b = true;
                } else {
                  if (urgentInt == 2) {
                    toDoList.get(indexChangeTask - 1).setUrgent(false);
                    b = true;
                  } else {
                    System.out.println("""
                        Введите:\s
                        '1' если задача срочная\s
                        '2' если задача не срочная
                        """);
                    urgentInt = Integer.parseInt(br.readLine());
                  }
                }
              } while (!b);

            } else {
              if (partChangeTask == 5) {
                change = true;
                System.out.print("""
                    Введите:\s
                    '1' если задача не начата (status 'to do')
                    '2' если задача выполняется (status 'in process')
                    '3' если задача завершена (status 'done')
                    """);

                int statusInt = 0;
                boolean c = false;
                try {
                  statusInt = Integer.parseInt(br.readLine());
                } catch (NumberFormatException e) {
                  System.err.println("Неправильный формат числа: " + e.getMessage());
                }
                do {
                  if (statusInt == 1) {
                    toDoList.get(indexChangeTask - 1).setStatus("to do");
                    c = true;
                  } else {
                    if (statusInt == 2) {
                      toDoList.get(indexChangeTask - 1).setStatus("in process");
                      c = true;
                    } else {
                      if (statusInt == 3) {
                        toDoList.get(indexChangeTask - 1).setStatus("done");
                        c = true;
                      } else {
                        System.out.print("""
                            Введите:\s
                            '1' если задача не начата (status 'to do')
                            '2' если задача выполняется (status 'in process')
                            '3' если задача завершена (status 'done')
                            """);
                        statusInt = Integer.parseInt(br.readLine());
                      }
                    }
                  }
                } while (!c);
              } else {
                System.out.println("""
                     Выберите, какую часть записи изменить:\s
                     '1' название (taskName)\s
                     '2' описание (taskDescription)\s
                     '3' важность (importance)\s
                     '4' срочность (urgent)\s
                     '5' статус (status)\s
                    """);
                partChangeTask = Integer.parseInt(br.readLine());
                change = false;
              }
            }
          }
        }
      }
    } while (!change);


    System.out.println("List after change Task");
    for (int i = 0; i < toDoList.size(); ++i) {
      System.out.println(((i + 1) + ". " + toDoList.get(i)));
    }

    //перезаписать в файл
    File toDoFile = new File("res/toDoFile.txt");

    FileWriter fileWriter = new FileWriter("res/toDoFile.txt");
    if (!toDoFile.exists()) {
      toDoFile.createNewFile();
    }

    for (int i = 0; i < toDoList.size(); ++i) {
      fileWriter.write(String.valueOf(toDoList.get(i)));
    }

    fileWriter.close();

    //выбор следующего действия
    System.out.println("Нажмите 1 если продолжить изменение и 2 для выхода в меню");

    int vybor = Integer.parseInt(br.readLine());
    if (vybor == 1) {
      taskChange();
    }

    Menu.menuStart();
  }
}


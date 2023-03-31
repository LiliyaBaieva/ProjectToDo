/*import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChangeTask {
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
      } else if (partChangeTask == 2) {
          change = true;
          System.out.println("введите новое описание задачи ");
          toDoList.get(indexChangeTask - 1).setTaskDescription(br.readLine());
        } else if (partChangeTask == 3) {
            change = true;
            importanceChange( toDoList,indexChangeTask);*/
            /*System.out.print("""
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
              } else if (importanceInt == 2) {
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
            } while (!a);*/
/*
          } else if (partChangeTask == 4) {
              change = true;
        urgentChance(toDoList, indexChangeTask);*/
              /*System.out.print("""
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
                } else if (urgentInt == 2) {
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
              } while (!b);*/

   /*         } else if (partChangeTask == 5) {
                change = true;
                statusChange(toDoList, indexChangeTask);*/
                /*System.out.print("""
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
                  } else if (statusInt == 2) {
                      toDoList.get(indexChangeTask - 1).setStatus("in process");
                      c = true;
                    } else if (statusInt == 3) {
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
                } while (!c);*/
   /*           } else {
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
  public static void importanceChange(List<Task> toDoList,int indexChangeTask) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
      } else if (importanceInt == 2) {
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
    } while (!a);
  }
  public  static void urgentChance(List<Task> toDoList,int indexChangeTask) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
      } else if (urgentInt == 2) {
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
    } while (!b);

  }
  private static void statusChange(List<Task> toDoList, int indexChangeTask) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    statusChange(toDoList, indexChangeTask);
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
    } catch (NumberFormatException | IOException e) {
      System.err.println("Неправильный формат числа: " + e.getMessage());
    }
    do {
      if (statusInt == 1) {
        toDoList.get(indexChangeTask - 1).setStatus("to do");
        c = true;
      } else if (statusInt == 2) {
        toDoList.get(indexChangeTask - 1).setStatus("in process");
        c = true;
      } else if (statusInt == 3) {
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
    } while (!c);
  }
}
*/




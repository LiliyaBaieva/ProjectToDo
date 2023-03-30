import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {
  /* Class Menu - Меню
  //   -добавить запись
  //   -изменить запись
  //   -вывести задачи на экран
    //      1. все задачи
    //      2. To do (нужно сделать)
    //      3. In progress (делаю)
    //      4. Done (сделано)
  //   -удалить запись
  //   - Выйти */

  public static void menuStart() throws IOException {

    List<String> menuMain = menuList();
    int numMenu = readMenu(menuMain);

    if (numMenu == 1) {
      System.out.println("Добавление записи."); // готово
      ToDoList.addTaskInToDoFile();
    }

    if (numMenu == 2) {
      System.out.println("Здесь происходит изменение записи ");
      ToDoList.taskChange();
    }

    // вывод подменю критериев отбора
    if (numMenu == 3) {
      System.out.println("Выберите критерий отбора:");
      int numSmallMenu = readMenu(menuListSmall());

      if (numSmallMenu == 1) {
        System.out.println("Все Ваши дела:");              // готово
        ToDoList.printToDoList();
      }

      if (numSmallMenu == 2) {
        System.out.println("Записи To do (нужно сделать):");  // готово
        ToDoList.printWithStatusToDo();
      }

      if (numSmallMenu == 3) {
        System.out.println("Ззаписи In progress (делаю):");  // готово
        ToDoList.printWithStatusInProcess();
      }

      if (numSmallMenu == 4) {
        System.out.println("Записи Done (сделано):");       // готово
        ToDoList.printWithStatusDone();
      }

      if (numSmallMenu == 5) {
        System.out.println("Записи ВАЖНЫЕ:");  // готово
        ToDoList.printImportanceTask();
      }

      if (numSmallMenu == 6) {
        System.out.println("Записи СРОЧНЫЕ:");  // готово
        ToDoList.printUrgentTask();
      }

      if (numSmallMenu == 7) {
        System.out.println("Возвращаемся в главное меню.");  // готово
        menuStart();
      }
    }

    if (numMenu == 4) {
            System.out.println("Удаление записи.");           // готово
      ToDoList.delTaskInToDoFile();
    }

    if (numMenu == 5) {
      System.out.println("Выходим. До свидания! Приятно было с Вами иметь дело!");
    }
  }

  public static List<String> menuList() {
    System.out.println("\nMENU");

    List<String> menuMain = new ArrayList<>();
    menuMain.add("Добавить запись.");
    menuMain.add("Изменить запись.");
    menuMain.add("Вывести задачи на экран.");
    menuMain.add("Удалить запись.");
    menuMain.add("Выйти.");

    for (int i = 0; i < menuMain.size(); ++i) {
      System.out.println(((i + 1) + ". " + menuMain.get(i)));
    }
    return menuMain;
  }

  public static int readMenu(List<String> menuMain) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int menuNumber = 0;
    while (menuNumber < 1 || menuNumber > menuMain.size()) {
      System.out.printf("Выберите действие и введите номер от 1 до %d:  -  ", menuMain.size());
      try {
        menuNumber = Integer.parseInt(br.readLine());
      } catch (NumberFormatException e) {
        System.err.println("\nНеправильный формат числа: " + e.getMessage());
      }
    }
    return menuNumber;
  }

  public static List<String> menuListSmall() {
    List<String> menuSmall = new ArrayList<>();
    menuSmall.add("Все записи.");
    menuSmall.add("Выполняются.");
    menuSmall.add("Ожидают выполнения.");
    menuSmall.add("Сделаны.");
    menuSmall.add("Важные.");
    menuSmall.add("Срочные.");
    menuSmall.add("Вернуться в главное меню.");

    for (int i = 0; i < menuSmall.size(); ++i) {
      System.out.println(((i + 1) + ". " + menuSmall.get(i)));
    }
    return menuSmall;
  }
}

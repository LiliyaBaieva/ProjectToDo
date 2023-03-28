import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {
  //* Class Menu - Меню
  //   -добавить запись
  //   -изменить запись
  //   -вывести задачи на экран
//      1. все задачи
//      2. To do (нужно сделать)
//      3. In progress (делаю)
//      4. Done (сделано)
  //   -удалить запись
  //   - Выйти
  public static void main(String[] args) throws IOException {
    System.out.println("\nMENU");
    List<String> menuMain = menuList();
  }

  public static List<String> menuList() {
    List<String> menuMain = new ArrayList<>();
    menuMain.add("- добавить запись.");
    menuMain.add("- изменить запись.");
    menuMain.add("- вывести задачи на экран.");
    menuMain.add("- удалить запись.");
    menuMain.add("- выйти.");

    for (int i = 0; i < menuMain.size(); ++i) {
      System.out.println(((i + 1) + ". " + menuMain.get(i)));
    }
    return menuMain;
  }

  public static String readMenu(List<String> menuMain) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String menuNumber = "";
    int num = 0;
    while (num < 1 || num > menuMain.size()) {
      System.out.printf("Выберите действие и введите номер от 1 до %d", menuMain.size());
      menuNumber = br.readLine();
      try {
        num = Integer.parseInt(menuNumber);
      } catch (NumberFormatException e) {
        System.err.println("Неправильный формат числа: " + e.getMessage());
      }
    }
    return menuNumber;
  }





}

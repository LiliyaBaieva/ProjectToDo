import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
  //* Class Menu - Меню
  //   -добавить запись
  //   -изменить запись
  //   -вывести задачи на экран
  //    1. все задачи
  //    2. To do (нужно сделать)
  //    3. In progress (делаю)
  //    4. Done (сделано)
  //   -удалить запись
  //   - Выйти
  public static void main(String[] args) throws IOException {
    System.out.println("\n * MENU * ");
    List<String> guide = menuList();
  }

  public static List<String> menuList() {
    List<String> guide = new ArrayList<>();
    guide.add("- добавить запись");
    guide.add("- изменить запись");
    guide.add("- вывести задачи на экран");
    guide.add("- удалить запись");
    guide.add("- выйти");

    for (int i = 0; i < guide.size(); ++i) {
      System.out.println(("    " + (i + 1) + ". " + guide.get(i)));
    }
    return guide;
  }

}

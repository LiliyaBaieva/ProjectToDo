import java.util.Comparator;

public class TaskDateNameComparator implements Comparator<Task> {
  // Сортировка по дате и имени
  @Override
  public int compare(Task o1, Task o2) {
    if (!o1.getDateOfCreate().equals(o2.getDateOfCreate())) {
      return o1.getDateOfCreate().compareTo(o2.getDateOfCreate());
    }
    return o1.getTaskName().compareTo(o2.getTaskName());
  }

}

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Comparator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TaskDateNameComparatorTests {
  // сортировки проверить

  // сравниваем два задания с разными названиями, одинаковым временем
  @Test
  public void differentDateOfCreateComparison(){

    // arrange
    Comparator<Task> comparator = new TaskDateNameComparator();
    Task task1 = new Task(LocalDate.parse("2023-04-30"), "A", "description", true,
        false, "to do");
    Task task2 = new Task(LocalDate.parse("2023-03-30"), "A", "description", true,
        false, "to do");

    // act
    int result = comparator.compare(task1, task2);

    // assert
    assertTrue(result > 0);
  }

  // сравниваем два задания с разными названиями, одинаковым временем
  @Test
  public void differentNameComparison(){

    // arrange
    Comparator<Task> comparator = new TaskDateNameComparator();
    Task task1 = new Task(LocalDate.parse("2023-03-30"), "A", "description", true,
        false, "to do");
    Task task2 = new Task(LocalDate.parse("2023-03-30"), "B", "description", true,
        false, "to do");

    // act
    int result = comparator.compare(task1, task2);

    // assert
    assertTrue(result < 0);
    }


  // сравниваем два задания с разными названиями, разным временем
  @Test
  public void differentNameDateOfCreateComparison(){

    // arrange
    Comparator<Task> comparator = new TaskDateNameComparator();
    Task task1 = new Task(LocalDate.parse("2023-04-30"), "A", "description", true,
        false, "to do");
    Task task2 = new Task(LocalDate.parse("2023-03-30"), "B", "description", true,
        false, "to do");

    // act
    int result = comparator.compare(task1, task2);

    // assert
    assertTrue(result > 0);
  }



}

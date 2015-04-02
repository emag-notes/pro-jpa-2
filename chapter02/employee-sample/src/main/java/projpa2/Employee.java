package projpa2;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author tanabe
 */
@Entity
public class Employee {

  @Id
  private int id;
  private String name;
  private long salary;

  public Employee() {}

  public Employee(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getSalary() {
    return salary;
  }

  public void setSalary(long salary) {
    this.salary = salary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Employee employee = (Employee) o;

    if (id != employee.id) return false;
    if (salary != employee.salary) return false;
    return !(name != null ? !name.equals(employee.name) : employee.name != null);

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (int) (salary ^ (salary >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "Employee{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", salary=" + salary +
      '}';
  }

}

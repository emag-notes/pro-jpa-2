package projpa2;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author tanabe
 */
public class EmployeeServiceTest {

  @Test
  public void test() throws Exception {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
    EntityManager em = emf.createEntityManager();

    EmployeeService sut = new EmployeeService(em);

    log("--- create and persist an employee");
    em.getTransaction().begin();
    Employee registered = sut.createEmployee(158, "John Doe", 45_000);
    em.getTransaction().commit();
    log("Persisted: " + registered);
    log("----------------------------------\n");

    log("--- find a specific employee");
    Employee emp158 = sut.findEmployee(158);
    log("Found Employee: " + emp158);
    log("----------------------------\n");

    log("--- find all the employees");
    sut.findAllEmployees().forEach(System.out::println);
    log("--------------------------\n");

    log("--- update the employee");
    em.getTransaction().begin();
    Employee raised = sut.raiseEmployeeSalary(158, 1000);
    em.getTransaction().commit();
    log("Updated: " + raised);
    log("-----------------------\n");

    log("--- remove an employee");
    em.getTransaction().begin();
    sut.removeEmployee(158);
    em.getTransaction().commit();
    log("Removed Employee 158");
    log("----------------------\n");

    // close the EM and EMF when done
    em.close();
    emf.close();
  }

  private void log(String message) {
    System.out.println(message);
  }

}
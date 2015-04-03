package projpa2.ejb;

import javax.ejb.Stateless;

/**
 * @author tanabe
 */
@Stateless
public class HelloServiceBean implements HelloService {

  @Override
  public String sayHello(String name) {
    return "Hello, " + name;
  }

}

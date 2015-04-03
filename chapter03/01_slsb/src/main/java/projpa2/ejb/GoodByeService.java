package projpa2.ejb;

import javax.ejb.Stateless;

/**
 * @author tanabe
 */
@Stateless
public class GoodByeService { // no interface

  public String sayGoodBye(String name) {
    return "Good Bye, " + name + "...";
  }

}

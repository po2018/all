package sth.app.person;

import pt.tecnico.po.ui.Command;
import sth.SchoolManager;
import sth.Person;

//FIXME import other classes if needed

/**
 * 4.2.3. Show all persons.
 */
public class DoShowAllPersons extends Command<SchoolManager> {

  //FIXME add input fields if needed

  /**
   * @param receiver
   */
  public DoShowAllPersons(SchoolManager receiver) {
    super(Label.SHOW_ALL_PERSONS, receiver);
    //FIXME initialize input fields if needed
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {
    //FIXME implement command
	  int i=1;
	  for (Person p:_receiver.showAllPersons())
		  _display.addLine(p.toString());
	  _display.display();
	  //_display.popup(_receiver.showAllPersons().toString());
	  }

}

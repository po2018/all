package sth;

import sth.exceptions.BadEntryException;
import sth.exceptions.ImportFileException;
import sth.exceptions.NoSuchPersonIdException;

import java.io.File;
//FIXME import other classes if needed
import java.io.IOException;
import java.util.Map;
import java.util.Collection;

/**
 * The façade class.
 */
public class SchoolManager {

  //FIXME add object attributes if needed
	private School _school=new School();
	private boolean _isAdministrative,_isProfessor,_isStudent,_isRepresentative;
  //FIXME implement constructors if needed
  
  /**
   * @param datafile
   * @throws ImportFileException
   * @throws InvalidCourseSelectionException
   */
  public void importFile(String datafile) throws ImportFileException {
    try {
      _school.importFile(datafile);
    } catch (IOException | BadEntryException e) {
      throw new ImportFileException(e);
    }
  }

  /**
   * @param id
   * @throws NoSuchPersonIdException
   */
  public void login(int id) throws NoSuchPersonIdException {
    //FIXME implement method
  }

  /**
   * @return true when the currently logged in person is an administrative
   */
  public boolean hasAdministrative() {
    //FIXME implement predicate
	  return _isAdministrative;
  }

  /**
   * @return true when the currently logged in person is a professor
   */
  public boolean hasProfessor() {
    //FIXME implement predicate
	  return _isProfessor;
  }

  /**
   * @return true when the currently logged in person is a student
   */
  public boolean hasStudent() {
    //FIXME implement predicate
	  return _isStudent;
  }

  /**
   * @return true when the currently logged in person is a representative
   */
  public boolean hasRepresentative() {
    //FIXME implement predicate
	  return _isRepresentative;
  }
  
  public Collection<Person> showAllPersons(){
	  return _school.getPeople();
  }

  //FIXME implement other methods (in general, one for each command in sth-app)
  
}

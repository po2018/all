package sth.exceptions;

public class InvalidCourseSelectionException extends Exception{
	
	private static final long serialVersionUID=0;
	
	public InvalidCourseSelectionException(){}
	
	public InvalidCourseSelectionException(String specification){super(specification);}
	
	public InvalidCourseSelectionException(Exception Cause){super(Cause);}

}

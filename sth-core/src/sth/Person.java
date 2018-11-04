package sth;

public abstract class Person {
	protected int _id;
	protected String _phone;
	protected String _name;
	
	public Person(String id,String phone,String name){
		_id=Integer.parseInt(id);
		_phone=phone;
		_name=name;
	}
	public int getId(){return _id;}
	abstract public void setDegree(Degree degree);
	
	@Override
	public abstract String toString();

}

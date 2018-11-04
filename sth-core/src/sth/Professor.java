package sth;

public class Professor extends Person{
	
	public Professor(String id,String phone,String name){super(id,phone,name);}
	public void setDegree(Degree degree){}
	@Override
	public String toString(){
		return "DOCENTE|"+_id+"|"+_phone+"|"+_name;
	}

}

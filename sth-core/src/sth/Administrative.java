package sth;

public class Administrative extends Person{
	
	public Administrative(String id,String phone,String name){super(id,phone,name);}
	public void setDegree(Degree degree){}
	@Override
	public String toString(){
		return "FUNCIONÁRIO|"+_id+"|"+_phone+"|"+_name;
	}

}

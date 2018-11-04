package sth;

public class Student extends Person{
	
	private Degree _degree;
	public Student(String id,String phone,String name){super(id,phone,name);}
	public void setDegree(Degree degree){if(_degree==null)_degree=degree;}
	public boolean isRepresentative(){
		return _degree.getRepresentatives().containsKey(_id);
	}
	
	@Override
	public String toString(){
		if(isRepresentative())
			return "DELEGADO|"+_id+"|"+_phone+"|"+_name;
		return "ALUNO|"+_id+"|"+_phone+"|"+_name;
	}

}

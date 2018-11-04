package sth;


import java.util.Map;
import java.util.TreeMap;


public class Degree {
	private String _name="";
	private Map<String,Discipline> _disciplines=new TreeMap<String,Discipline>();
	private Map<Integer,Person> _representatives=new TreeMap<Integer,Person>();
	
	public Degree(){}
	public Degree(String name){_name=name;} 
	public String getName(){return _name;}
	public Map<Integer,Person> getRepresentatives(){return _representatives;}
	public void setDiscipline(Discipline d){_disciplines.put(d.getName(),d);}
	public void setRepresentative(Person p,boolean representative){
		if(representative){ _representatives.put(p.getId(),p);
		}
	}

}

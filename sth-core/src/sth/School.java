package sth;

//FIXME import other classes if needed
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;

import java.io.IOException;

import sth.exceptions.BadEntryException;
import sth.exceptions.InvalidCourseSelectionException;
import sth.exceptions.NoSuchPersonIdException;

/**
 * School implementation.
 */
public class School implements Serializable {

	/** Serial number for serialization. */
	private static final long serialVersionUID = 201810051538L;

	//FIXME define object fields (attributes and, possibly, associations)
	private Map<Integer,Person> _people=new TreeMap<Integer,Person>();
	private Map<String,Degree> _degrees=new TreeMap<String,Degree>();

	//FIXME implement constructors if needed

	/**
	 * @param filename
	 * @throws BadEntryException
	 * @throws IOException
	 */
	void importFile(String filename) throws IOException, BadEntryException {
		//FIXME implement text file reader
		BufferedReader in=new BufferedReader(new FileReader(filename));
		String line=in.readLine();
		line=in.readLine();
		Person p=new Student("1","1","");
		Degree d=new Degree();
		Discipline c=new Discipline();
		boolean representative=false;
		while(line!=null){
			try{
				String dados[]=line.split("\\|");
				if(line.charAt(0)!='#'){
					ArrayList<String> ctorargs=new ArrayList<String>(dados.length-1);
					Class<?> tipo=Class.forName("sth.Person");
					dados[0]=dados[0].replace("  ","");
					switch(dados[0]){
					case "FUNCIONÁRIO": 
						tipo=Class.forName("sth.Administrative");
						break;
					case "ALUNO":
						tipo=Class.forName("sth.Student");
						break;
					case "DOCENTE":
						tipo=Class.forName("sth.Professor");
						break;
					case "DELEGADO":
						tipo=Class.forName("sth.Student");
						representative=true;
						break;
					}
					for(int i=1;i<dados.length;i++) ctorargs.add(i-1,dados[i]);
					Constructor<?> ctor=tipo.getConstructors()[0];
					p=(Person)ctor.newInstance(ctorargs.toArray());
					_people.put(p.getId(),p);
				}else{
					dados[0]=dados[0].replace("# ","");
					Class<?> degree=Class.forName("sth.Degree");
					Class<?> discipline=Class.forName("sth.Discipline");
					Constructor<?> ctor1=degree.getConstructors()[1];
					Constructor<?> ctor2=discipline.getConstructors()[1];
					if(dados[0]!=d.getName()){
						d=(Degree)ctor1.newInstance(dados[0]);
						_degrees.put(d.getName(),d);
						d.setRepresentative(p,representative);
						representative=false;
						p.setDegree(d);
					}
					c=(Discipline)ctor2.newInstance(dados[1]);
					d.setDiscipline(c);
				}
			}catch(Exception a){
				System.out.println(a);
				System.out.println(a.getStackTrace()[0].getLineNumber());
			}
			
			line=in.readLine();
		}
		in.close();
	}
	

	//FIXME implement other methods
	
	public Collection<Person> getPeople(){
		return Collections.unmodifiableCollection(_people.values());
	}

}

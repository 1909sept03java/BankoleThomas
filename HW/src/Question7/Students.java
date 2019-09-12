package Question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




public class Students {

	public String Name;
	public String Dept;
	public int age;
	
	

	public Students(String name, String dept, int age) {
		super();
		Name = name;
		Dept = dept;
		this.age = age;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String department) {
		Dept = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Students [Name=" + Name + ", Dept=" + Dept + ", age=" + age + "]";
	}
	
	public static void main(String[] args) {

		List<Students> student = new ArrayList<>();

		student.add(new Students("Banx","Tech",28));
		student.add(new Students("Deyvon","Custodial",29));

		Collections.sort(student, new CompareByAge());
		Collections.sort(student, new CompareByName());
		Collections.sort(student, new CompareByDept());

		for(Students c :student) {
			System.out.println(c);

		}
	}

}

class CompareByAge implements Comparator<Students>{


	@Override
	public int compare(Students o1, Students o2) {
		return o1.getAge()-o2.getAge();
	}



}
class CompareByName implements Comparator<Students>{

	public int compare(Students o1, Students o2) {
		return o1.getName().compareTo(o2.getName());
	}

	


	}
class CompareByDept implements Comparator<Students>{

		public int compare(Students o1, Students o2) {
			return o1.getDept().compareTo(o2.getDept());
		}
}




package practice.com.clonning;
public class PupilVO1 implements Cloneable { 
	// Contained object
	private SubjectVO subj;
	private String name;

	public SubjectVO getSubj() {
		return subj;
	}

	public void setSubj(SubjectVO subj) {
		this.subj = subj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PupilVO1(String name, String sub) {
		this.name = name;
		this.subj = new SubjectVO(sub);
	}

	public Object clone() {
		PupilVO1 pupil = new PupilVO1(name, subj.getName());
		return pupil;
	}
	
}

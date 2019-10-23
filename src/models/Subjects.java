package models;

public class Subjects {
	
	//The array variables were made public for them to be accessible from anywhere in the project.
	private String subjectCode[] = { "BIT100", "BIT101", "BIT108", "BIT111", "BIT112", "BIT121", "BIT230", "BIT241" };

	private String subjectName[] = { "Effective Business Communication", "Foundations of IT",
			"Foundations of Business", "Programming Concepts", "Maths for IT", "Network Communication Concepts",
			"System Analysis and Design", "Professional IT Practice and Ethics" };

	private String semester[] = { "1", "1", "1", "1", "2", "2", "2", "2" };

	public String[] getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String[] subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String[] getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String[] subjectName) {
		this.subjectName = subjectName;
	}

	public String[] getSemester() {
		return semester;
	}

	public void setSemester(String[] semester) {
		this.semester = semester;
	}
	
	

}

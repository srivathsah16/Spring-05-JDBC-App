package in.srivath.models;

public class User {
	private int uid;
	private String uname;
	private int uage;

	public User() {
		System.out.println("User:: 0-param-constructor");
	}

	public User(int uid, String uname, int uage) {
		System.out.println("User created with id=" + uid + ",name =" + uname + ", age=" + uage);
		this.uid = uid;
		this.uname = uname;
		this.uage = uage;
	}

	public int getId() {
		return uid;
	}

	public String getName() {
		return uname;
	}

	public int getAge() {
		return uage;
	}

	public void setId(int id) {
		this.uid = id;
	}

	public void setName(String name) {
		this.uname = name;
	}

	public void setAge(int age) {
		this.uage = age;
	}

	@Override
	public String toString() {
		return "id=" + uid + ", name=" + uname + ", age=" + uage;
	}

}

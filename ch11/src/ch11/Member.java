package ch11;

import java.util.Date;

public class Member implements Comparable {
	
	String id;
	String pwd;
	String address;
	String email;
	Date indate;
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member){
			Member mem=(Member)obj;
			return this.id.equals(mem.id);
		}
		return false;
	}

	


	@Override
	public int hashCode() {
		return (this.id+"").hashCode();		
	}




	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", address=" + address + ", email=" + email + ", indate=" + indate
				+ "]";
	}




	@Override
	public int compareTo(Object o) {
		if(o instanceof Member){
			Member mem=(Member)o;
			return this.id.compareTo(mem.id);
		}
		return -1;
	}
	
	

}








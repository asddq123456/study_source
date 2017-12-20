package book_cms_project;

public abstract class DataSource {
	public int count;
	public Member[] memberList;
	
	abstract Member selectMemberById(String id);
	
	abstract boolean confirmMember(String id);
	
	abstract int countMember();
	
	abstract int insertMember(Member member);
	
	
}

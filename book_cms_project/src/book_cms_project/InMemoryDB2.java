package book_cms_project;

public class InMemoryDB2 extends DataSource{
	
	private static InMemoryDB2 instance=new InMemoryDB2();
	private InMemoryDB2(){}
	public static InMemoryDB2 getInstance(){
		return instance;
	}
	
	@Override
	Member selectMemberById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	boolean confirmMember(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	int countMember() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int insertMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}

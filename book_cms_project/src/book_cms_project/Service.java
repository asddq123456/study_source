package book_cms_project;

public class Service {
	private static Service instance=new Service();
	private Service(){};
	public static Service getInstance(){
		return instance;
	}
	
	private DataSource db;
	public void setDb(DataSource db){
		this.db=db;
	}
	
	// 로그인 처리 (-1:아이디 부재, 0:패스워드 불일치, 1:로그인 확인)
	int login(String id, String pwd){
		int result=-1;
		if(db.confirmMember(id)){
			Member member=db.selectMemberById(id);
			if(pwd.equals(member.getPwd())){//로그인 확인
				result=1;
			}else{//패스워드 불일치
				result=0;
			}
		}		
		return result;
	}
	
	// 가입처리 (-1:가입미처리, 1:가입처리)
	int join(Member member){
		int result=-1;
		if((db.countMember()<db.memberList.length-1)
			&&(!db.confirmMember(member.getId()))){
			result=db.insertMember(member);
		}
		return result;
	}
	
	
}










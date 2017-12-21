package book_cms_project;

import com.cms.exception.ComflictIDException;
import com.cms.exception.InvalidPasswordException;
import com.cms.exception.NotFoundLoginIDException;
import com.cms.exception.OutOfRangeException;

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
	void login(String id, String pwd)
		throws NotFoundLoginIDException,InvalidPasswordException{
		
		if(db.confirmMember(id)){
			Member member=db.selectMemberById(id);
			if(!pwd.equals(member.getPwd())){//패스워드 불일치
				throw new InvalidPasswordException();
			}
		}else{
			throw new NotFoundLoginIDException();
		}		
	}
	
	// 가입처리 (-1:가입미처리, 1:가입처리)
	void join(Member member) 
			throws ComflictIDException,OutOfRangeException{
		if(db.countMember()>db.memberList.length-1){
			throw new OutOfRangeException();
			
		}else if(db.confirmMember(member.getId())){
			throw new ComflictIDException();
			
		}else{
			db.insertMember(member);
		}
		
		/*if((db.countMember()<db.memberList.length-1)
			&&(!db.confirmMember(member.getId()))){
			db.insertMember(member);
		}*/		
	}
	
	
}










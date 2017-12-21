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
	
	// �α��� ó�� (-1:���̵� ����, 0:�н����� ����ġ, 1:�α��� Ȯ��)
	void login(String id, String pwd)
		throws NotFoundLoginIDException,InvalidPasswordException{
		
		if(db.confirmMember(id)){
			Member member=db.selectMemberById(id);
			if(!pwd.equals(member.getPwd())){//�н����� ����ġ
				throw new InvalidPasswordException();
			}
		}else{
			throw new NotFoundLoginIDException();
		}		
	}
	
	// ����ó�� (-1:���Թ�ó��, 1:����ó��)
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










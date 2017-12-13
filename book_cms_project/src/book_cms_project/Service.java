package book_cms_project;

public class Service {
	
	InMemoryDB db=new InMemoryDB();
	
	// �α��� ó�� (-1:���̵� ����, 0:�н����� ����ġ, 1:�α��� Ȯ��)
	int login(String id, String pwd){
		int result=-1;
		if(db.confirmMember(id)){
			Member member=db.selectMemberById(id);
			if(pwd.equals(member.pwd)){//�α��� Ȯ��
				result=1;
			}else{//�н����� ����ġ
				result=0;
			}
		}		
		return result;
	}
	
	// ����ó�� (-1:���Թ�ó��, 1:����ó��)
	int join(Member member){
		int result=-1;
		if((db.countMember()<db.memberList.length-1)
			&&(!db.confirmMember(member.id))){
			result=db.insertMember(member);
		}
		return result;
	}
	
	
}










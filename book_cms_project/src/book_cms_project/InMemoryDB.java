package book_cms_project;

public class InMemoryDB extends DataSource{
	
	private static InMemoryDB instance=new InMemoryDB();
	private InMemoryDB(){}
	public static InMemoryDB getInstance(){
		return instance;
	}	
	
	Member selectMemberById(String id){ 
		Member member = null;
		
		for(int index=0;index<memberList.length;index++){
			if(memberList[index]!=null && id.equals(memberList[index].getId())){
				member=memberList[index];
				break;
			}
		}				
		return member;
	}
	
	boolean confirmMember(String id){		
		
		boolean result=false;		
		for(int index=0;index<memberList.length;index++){
			
			if(memberList[index]!=null && id.equals(memberList[index].getId())){
				result=true;
				break;
			}
		}
		
		return result;
	}
	
	int countMember(){
		return count;
	}
	
	int insertMember(Member member){
		memberList[count]=member;
		count++;
		return 1;
	}
	
	
	
	
	
}

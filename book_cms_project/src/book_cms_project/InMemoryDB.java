package book_cms_project;

public class InMemoryDB {
	
	public static int count;
	public static Member[] memberList=new Member[100];
	
	
	Member selectMemberById(String id){ 
		Member member = null;
		
		for(int index=0;index<memberList.length;index++){
			if(memberList[index]!=null && id.equals(memberList[index].id)){
				member=memberList[index];
				break;
			}
		}				
		return member;
	}
	
	boolean confirmMember(String id){		
		
		boolean result=false;		
		for(int index=0;index<memberList.length;index++){
			
			if(memberList[index]!=null && id.equals(memberList[index].id)){
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

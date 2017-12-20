package book_cms_project;

public class Main {
	
	View view;
	Service service;
	DataSource db;
	
	{
		view=View.getInstance();
		service=Service.getInstance();
		db=InMemoryDB.getInstance();
		
		service.setDb(db);
		view.setService(service);
		
	}
	
	public static void main(String[] args) {
		Main main=new Main();
		boolean isExit = false;
		while (!isExit) {

			isExit = main.view.mainView();
		}

	}

}

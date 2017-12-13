package book_cms_project;

public class Main {

	public static void main(String[] args) {
		boolean isExit = false;
		while (!isExit) {
			View view = new View();

			isExit = view.mainView();
		}

	}

}

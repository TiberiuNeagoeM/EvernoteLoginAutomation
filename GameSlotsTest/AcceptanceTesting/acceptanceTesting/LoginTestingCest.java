package acceptanceTesting;

public class LoginTestingCest {

    public static void main(String[] args) throws InterruptedException {

	// First step of the test : Unsuccessful login using e-mail
	LoginTestingStep.UnauthotisedLogin(); // To be uncommented before push

	// Second step of the test : Successful login using e-mail
	LoginTestingStep.AuthotisedLogin();

	// Third step of the test : Create New Note and Log out
	LoginTestingStep.WriteANote();

	//Forth step of the test : Move to trash the existing note in order to have the last one created opened
	LoginTestingStep.MoveToTrash();
    }
}

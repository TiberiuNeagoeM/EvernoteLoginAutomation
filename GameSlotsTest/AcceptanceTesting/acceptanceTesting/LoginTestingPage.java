package acceptanceTesting;

public class LoginTestingPage {

    public static String URL = "https://evernote.com/";

    // Page Buttons
    public static String loginHeaderButton = "body > header > div.top > div > nav.utility-nav > ul > li:nth-child(2) > a";
    public static String continueButton = "#loginButton";
    public static String loginButton = "#loginButton";
    public static String accountDropdownButton = "//*[@id=\"qa-NAV_USER\"]/div/div/span";
    public static String logoutButton = "//a[@id='qa-ACCOUNT_DROPDOWN_LOGOUT']";
    public static String exitAnywayButton = "//*[@id=\"qa-LOGOUT_CONFIRM_DIALOG_SUBMIT\"]";
    public static String moreButton = "//*[@id='qa-NOTE_ACTIONS']";
    public static String moveToTrash = "//*[@id=\"qa-ACTION_DELETE\"]";

    // Page locators
    public static String loginErrorMessage = "#password-wrapper > div";
    public static String createNewNote = "#qa-HOME_NOTE_WIDGET_CREATE_NOTE";
    public static String titleField = "//body/en-note[@id='en-note']/div[1]/br[1]";
    public static String emptySpace = "#qa-NOTE_FULLSCREEN_BTN";
    public static String messageBody = "//en-note[@id='en-note']";
    public static String messageTitle = "//en-noteheader/div[1]/div[2]/textarea[1]";
    public static String enNote = "#en-note";
    public static String testVar = "//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/nav[1]/div[1]/ul[1]/ul[1]/div[1]/div[1]/div[1]";
    public static String emailAdreesField = "#username";
    public static String passwordField = "#password";
    public static String iFrameLocator = "qa-COMMON_EDITOR_IFRAME";
    public static String articleLocator = "(//div[@id='qa-HOME_NOTE_WIDGET_NOTE_LIST_2|0_0|0_3DJUU3|13'])[0]";

    // Credentials
    public static String email = "spacesiatat@yahoo.com";
    public static String wrongPass = "Test123";
    public static String titleText = "Hello!";
    public static String messageText = "My name is Tiberiu and I came to say Hi!";
    public static String Pass = "Pass1212";
}

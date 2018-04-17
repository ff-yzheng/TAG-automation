package repo;

public class Locator {

    // Login Page
    public static final String CHEVRON_LOGO_IMG = "//*[@id='headerForm:customerCommandLnk']";
    public static final String BP_LOGO_IMG = "//*[@id='headerForm:auCommandLnk']";
    public static final String USERNAME = "j_username"; // id
    public static final String PASSWORD = "j_password"; // id
    public static final String SIGNIN = "btn_login"; // id
    public static final String FORGOT_PASSWORD = "emailPassword"; //id
    public static final String CONTACT_US = "contactUs"; //id
    public static final String REQUEST_LOGON = "requestALogon"; //id

    // OnlineUserAction Page
    public static final String QUESTION = "//label[@for='askedQuestionResponse']";
    public static final String APPLYBUTTON = "//button[contains(text(),'Apply')]";
    public static final String CANCELBUTTON = "//a[contains(text(),'Cancel')]";
    public static final String ONLINEUSERACTIONTEXT = "//div[contains(text(),'Online User Action Required')]";
    public static final String ANSWER = "askedQuestionResponse"; // id

    // Home Page
    public static final String CLIENT_WELCOME_TEXT = "//*[@id='welcome_CTA']/h1";
    public static final String BP_WELCOME_TEXT = "//*[@id='welcome_CTA']/h1";
    public static final String HOME_MENU = "//*[@id='menu_form:levelOneHome']";
    public static final String ACCOUNTS_MENU = "levelOneAccount"; //id   "//*[@id='levelOneAccount']";  //XPATH
    public static final String CARDS_MENU = "levelOneCards";//id     "//*[@id='levelOneCards']";  //XPATH
    public static final String TRANSACTIONS_MENU = "levelOneTransactions";      // "//*[@id='levelOneTransactions']"; //XPATH
    public static final String REPORTS_MENU = "levelOneReports"; //"//*[@id='levelOneReports']"; //XPATH
    public static final String SUPPORT_MENU = "levelOneSupport"; //"//*[@id='levelOneSupport']"; //XPATH
    public static final String ADMIN_MENU = "levelOneAdmin"; //"//*[@id='levelOneAdmin']"; //XPATH
    public static final String HELP_REF = "//*[@id='accountProfile_online_user_guideLnk']";
    public static final String LOGOUT = "Logout"; // linktext
    public static final String STATUS_MENU = "levelTwoAccSel"; //"//*[@id='levelTwoAccSel']";
    public static final String ACCOUNT_MAINTENANCE_MENU = "levelTwoCustMaint"; //"//*[@id='levelTwoCustMaint']";  //XPATH
    public static final String CONTACTS_MENU = "//*[@id='menu_form:levelTwoContactsList']";
    public static final String DRIVERS_MENU = "levelTwoDriversList"; //"//*[@id='levelTwoDriversList']";  //XPATH
    public static final String VEHICLES_MENU = "levelTwoVehicles"; //"//*[@id='levelTwoVehicles']";  //XPATH
    public static final String COST_CENTERS_MENU = "levelTwoCcList"; // "//*[@id='levelTwoCcList']";  //XPATH
    public static final String QUICK_LINKS = "quicklinks"; //id
    public static final String CUSTOMER_NAME_COMBO = "//*[@id='lform:selectMember']"; //XPATH.
    public static final String CUSTOMER_NAME_LABEL = "//*[@id='accountProfile']/div[1]/label"; //XPATH
    public static final String ACCOUNT_STATUS = "//*[@id='table_selectAccountDetails']/tbody/tr[1]/td[2]/span";
    public static final String CREDIT_LIMIT = "//*[@id='table_selectAccountDetails']/tbody/tr[2]/td[2]/span";
    public static final String ACTUAL_BALANCE = "//*[@id='table_selectAccountDetails']/tbody/tr[3]/td[2]/span";
    public static final String AVAILABLE_BALANCE = "//*[@id='table_selectAccountDetails']/tbody/tr[5]/td[2]/h3/span";
    public static final String LAST_BILL_DATE = "//*[@id='table_selectAccountDetails']/tbody/tr[7]/td[2]";
    public static final String LAST_PAYMENT_RECIEVED = "//*[@id='table_selectAccountDetails']/tbody/tr[8]/td[2]";
    public static final String LAST_PAYMENT_AMOUNT = "//*[@id='table_selectAccountDetails']/tbody/tr[8]/td[3]/span";


    // Add Address Page
    public static final String ADD_ADDRESS_LINK = "Add Address"; // linktext
    public static final String ADDRESSINFORMATIONLABEL = "//h2[contains(text(),'Address Information')]";
    public static final String ADDR1 = "street1"; // id
    public static final String ADDR2 = "street2";// id
    public static final String CITY = "city";// id
    public static final String STATE = "state";// id
    public static final String ZIPCODE = "postalCode";// id
    public static final String PRIMARYADDRTYPE = "//label[contains(text(),'Primary')]/input[1]";
    public static final String BILLINGADDRTYPE = "//label[contains(text(),'Billing')]/input[1]";
    public static final String NEXTBUTTON = "//button[contains(text(),'Next')]";
    public static final String SUCCESSMESSAGE = "errorContentText"; // id

    // Add Contact Page
    public static final String ADD_CONTACT_LINK = "Add Contact"; // linktext
    public static final String CONTACTINFORMATIONLABEL = "//h2[contains(text(),'Contact Information')]";
    public static final String PHONE = "phoneNumber"; // id
    public static final String MIDDLENAME = "middleName"; // id
    public static final String EMAILADDRESS = "emailAddress"; // id
    public static final String FAXNUMBER = "faxNumber"; // id
    public static final String MOBILEPHONE = "cellularPhone"; // id
    public static final String PRIMARYADDRTYPECHK = "addressTypeList1"; //id

    // Add Cards Page
    public static final String ADD_CARDS_LINK = "Add Vehicle/Asset Card"; // linktext
    public static final String VEHICLEASSETINFOLABEL = "//h2[contains(text(),'Vehicle/Asset Information')]";
    public static final String ASSETID = "vehicle.vehicleNumber"; // id

    // Add Driver Page
    public static final String ADD_DRIVER_LINK = "Add Driver"; // linktext
    public static final String DRIVERINFOLABEL = "//h2[contains(text(),'Driver Information')]";
    public static final String LASTNAME = "lastName"; // id
    public static final String FIRSTNAME = "firstName"; // id
    public static final String DRIVER_PROMPT_ID = "driverPrompt"; // id
    public static final String ADDBUTTON = "//button[contains(text(),'Add')]";

    // View Account Details Page
    public static final String VIEW_ACCT_DETAILS_LINK = "View Account Details"; // linktext
    public static final String ACCTINFOLABEL = "//h2[contains(text(),'Account Detail')]";
    public static final String ACCTNAME = "//div[contains(text(),'Account Name')]/../following-sibling::div";
    public static final String ACCTNO = "//div[contains(text(),'Account Number')]/../following-sibling::div";

    // Card Confirmation Page
    //"//a[contains(text(),'****')]"
    //public static final String VIEW_ACCT_DETAILS_LINK = "View Account Details"; // linktext
    public static final String CARDNUMBER = ".//*[@id='body']/main/div[1]/div/table/tbody/tr/td[2]/a";
    //public static final String ACCTNAME = "//div[contains(text(),'Account Name')]/../following-sibling::div";
    //public static final String ACCTNO = "//div[contains(text(),'Account Number')]/../following-sibling::div";
}
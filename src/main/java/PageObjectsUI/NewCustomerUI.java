package PageObjectsUI;

public class NewCustomerUI {
    public static final String LABEL_DYNAMIC = "xpath=//td[text()='%s']/following-sibling::td/label";
    public static final String INPUT_DYNAMIC = "xpath=//td[text()='%s']/following-sibling::td/input";
    public static final String FIELD_NAME_DYNAMIC = "xpath=//td[text()='%s']";

    public static final String CUSTOMER_NAME = "css=input[name='name']";
    public static final String CUSTOMER_NAME_LABEL = "xpath=//input[@name='name']/parent::td/preceding-sibling::td";

    public static final String CUSTOMER_GENDER_LABEL = "xpath=//input[@name='rad1']/parent::td/preceding-sibling::td";

    public static final String DATE_OF_BIRTH = "css=input[id='dob']";
    public static final String DATE_OF_BIRTH_LABEL = "xpath=//input[@id='dob']/parent::td/preceding-sibling::td";

    public static final String CUSTOMER_ADDRESS = "css=textarea[name='addr']";
    public static final String CUSTOMER_ADDRESS_LABEL = "xpath=//textarea[@name='addr']/parent::td/preceding-sibling::td";

    public static final String CUSTOMER_CITY = "css=input[name='city']";
    public static final String CUSTOMER_CITY_LABEL = "xpath=//input[@name='city']/parent::td/preceding-sibling::td";

    public static final String CUSTOMER_STATE = "css=input[name='state']";
    public static final String CUSTOMER_STATE_LABEL = "xpath=//input[@name='state']/parent::td/preceding-sibling::td";

    public static final String CUSTOMER_PIN = "css=input[name='pinno']";
    public static final String CUSTOMER_PIN_LABEL = "xpath=//input[@name='pinno']/parent::td/preceding-sibling::td";

    public static final String CUSTOMER_MOBILE_NUMBER = "css=input[name='telephoneno']";
    public static final String CUSTOMER_MOBILE_NUMBER_LABEL = "xpath=//input[@name='telephoneno']/parent::td/preceding-sibling::td";

    public static final String CUSTOMER_EMAIL = "css=input[name='emailid']";
    public static final String CUSTOMER_EMAIL_LABEL = "xpath=//input[@name='emailid']/parent::td/preceding-sibling::td";

    public static final String CUSTOMER_PASSWORD = "css=input[name='password']";
    public static final String CUSTOMER_PASSWORD_LABEL = "xpath=//input[@name='password']/parent::td/preceding-sibling::td";

    public static final String SUBMIT_BUTTON = "css=input[name='sub']";

    public static final String EDIT_CUSTOMER_MENU = "xpath=//ul[@class='menusubnav']//a[text()='Edit Customer']";
}

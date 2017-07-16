
package com.auth.common;

/**
 * Class containing all the constants to be used in the project.
 *
 * @author vikbhati
 */
public class CommonConstants {
    
    public static final String SIP_URI_REGEX = "^(([0-9#\\-_\\.,:;\\+\\%\\?'\\(\\)~\\*]*)|(([!@#$%^&*()+=`~|\\{}\\[\\];:',./?\"<>A-Za-z0-9 _-])|(%[2-7][0-9A-F])){1,40}@([a-zA-Z0-9](-*[a-zA-Z0-9])*\\.?|[a-zA-Z0-9](-*[a-zA-z0-9])*(\\.[a-zA-Z0-9](-*[a-zA-Z0-9])*)*\\.[a-zA-Z](-*[a-zA-Z0-9])*\\.?|(([1-9]?[0-9]|1[0-9]{2,2}|2[0-4][0-9]|25[0-5])(\\.([1-9]?[0-9]|1[0-9]{2,2}|2[0-4][0-9]|25[0-5])){3})))$";
    public static final String GUUID_REGEX = "[0-9a-fA-F]{8}(-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12}";
    public static final String NUMBER_REGEX = "^[0-9]*$";
    public static final String E164_REGEX = "^\\+[1-9]\\d{1,14}$";
    public static final String ERROR_MESSAGE_RESOURCE_NOT_FOUND = "Resource not found";
    public static final String ERROR_MESSAGE_RESOURCE_OR_PARENT_NOT_FOUND = "Either this resource or parent not found";
    public static final String ERROR_MESSAGE_RESOURCE_ALREADY_EXIST = "Resource already exists";
    public static final String ERROR_MESSAGE_INTERNAL_SERVER_ERROR = "Internal server error";
    public static final String DATABASE_ENTITY_PACKAGE = "com.cisco.avril.customer";
    
    public static final String EVENT_FAILURE_MESSAGE_KEY = "FailureMessage";
    public static final String EVENT_AUDIT = "System.Audit";
    public static final String EVENT_DATABASE_STATUS = "DatabaseStatus";
    
    public static final String NULLIFY_FIELD = "NULL";
    public static final String CONSTANT_SLASH = "/";
    
    public static final String DEFAULT_LANGUAGE = "en-US";
    public static final String DEFAULT_TIMEZONE = "America/Los_Angeles";
    // OAuth Constants
    public static final int DEFAULT_TTL = 43199;
    public static final int DEFAULT_MAX_ENTRIES_INMEM = 1;
    public static final int FOUR = 4;
    public static final String ERROR_LOG = "ERROR_LOG, ";
    public static final String CIS_HOST = "cisHost";
    public static final String CIS_ADMIN_CLIENT_ID = "cisAdminClientId";
    public static final String CIS_ADMIN_CLIENT_SECRET = "cisAdminClientSecret";
    public static final String CIS_SERVICE_ACCOUNT_ID = "cisServiceAccountAuthUsername";
    public static final int OAUTH_POST_RESPONSE_CODE = 200;
    public static final String ADMIN_SCOPE = "Identity:SCIM ciscouc:admin";
    
    public static final String INSERT_QUERY = "INSERT";
    public static final String DELETE_QUERY = "DELETE";
    public static final String LANGUAGE = "language";
    public static final String TIMEZONE = "timezone";
    public static final String ESN = "ESN";
    public static final String E164 = "E164";
    public static final String EXTENSION = "EXTENSION";
    public static final String SIP_URI = "SIPURI";
    public static final String AUTH_URI = "/msgdirmgmt/api/notavailable/*";
    public static final String AUTH_ROLE = "authRole";
    public static final String AUTH_USER = "Identity:SCIM ciscouc:admin";
    
    /**
     * Creating Default private constructor of class,to avoid object creation,as all
     * members are static.
     */
    private CommonConstants()
    {
    
    }
    
}

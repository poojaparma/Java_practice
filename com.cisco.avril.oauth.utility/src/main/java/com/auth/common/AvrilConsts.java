

package com.auth.common;

import org.springframework.stereotype.Component;

/**
 * This is Constant class having all the constant using in dir management service.
 * 
 * @author rahulsri
 */
@Component
public class AvrilConsts {
    
    // Constants for Event
    public static final String EVENT_DATABASE_STATUS = "DatabaseStatus";
    public static final String EVENT_FAILURE_STATE = "FailureState";
    public static final String EVENT_AUDIT = "System.Audit";
    public static final String CSI_EVENT_STATUS = "CSIStatus";
    public static final String CSI_EVENT_FAILURE_STATE = "CSIFailureState";
    public static final String CSI_EVENT_FAILURE_STATUS_MESSAGE = "Failure from CSI External Service";
    public static final String EVENT_FAILURE_MESSAGE_KEY = "FailureMessage";
    public static final String ERROR_INTERVAL_SERVER_ERROR_MESSAGE_GENERIC = "Internal Server Error";
    public static final String CREATE_KEYSPACE = "CREATE KEYSPACE IF NOT EXISTS %s "
            + "WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : %s };";
    public static final int CLUSTER_SIZE_THREE = 3;
    public static final String GUUID_REGEX = "[0-9a-fA-F]{8}(-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12}";
    public static final String NULLVALUE = "null";
    public static final String HTTP_POST = "POST";
    public static final String HTTP_DELETE = "DELETE";
    public static final String HTTP_PUT = "PUT";
    public static final String HTTP_GET = "GET";
    public static final String CONSTANT_SLASH = "/";
    public static final String CONSTANT_COMMA = ", ";
    public static final String CONSTANT_DOLLAR = "$";
    public static final String CONSTANT_EMPTY = "";
    public static final String USR_AGENT = "user-agent";
    public static final String CUSTOMER = "customers";
    public static final String CONSUMER = "consumers";
    public static final String SITE = "siteId";
    public static final String API_VERSION = "v1";
    public static final String ERROR_LOG = "ERROR_LOG, ";
    public static final String REGEX_URL = ".*/v./(.*)";
    public static final String VALUE_UNKNOWN = "unknown";
    public static final int INDEX = 2;
    public static final String SERVICE_STATE_WARN_MESSAGE = "Session has too many in-flight queries";
    
    public static final int RESPONSE_CODE = 201;
    public static final String UT_POSITIVE = "UTPositive";
    public static final String UT_NEGATIVE = "UTNegative";
    
    public static final String CIS_HOST = "cisHost";
    public static final String CIS_ADMIN_CLIENT_ID = "cisAdminClientId";
    public static final String CIS_ADMIN_CLIENT_SECRET = "cisAdminClientSecret";
    public static final String CIS_SERVICE_ACCOUNT_ID = "cisServiceAccountAuthUsername";
    public static final String CIS_SERVICE_ACCOUNT_PWD = "cisServiceAccountAuthPassword";
    public static final int OAUTH_POST_RESPONSE_CODE = 200;
    public static final String ADMIN_SCOPE = "Identity:SCIM ciscouc:admin";
    public static final String TOTAL_UPSTREAM_PING_REQUEST = "Total_Ping_Request_On_Upstream_Services";
    public static final String UPSTREAM_PING_TIMING_METRIC = "Total_Response_Time_To_Monitor_Upstream_Service";
    
    /**
     * Creating Default private constructor of class,to avoid object creation,as all
     * members are static.
     */
    private AvrilConsts() {
    
    }
}

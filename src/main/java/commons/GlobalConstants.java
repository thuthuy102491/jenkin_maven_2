package commons;

import java.io.File;

public class GlobalConstants {
    private static GlobalConstants globalInstance;

    private GlobalConstants() {

    }

    public static synchronized GlobalConstants getGlobalConstants() {
        if (globalInstance == null) {
            globalInstance = new GlobalConstants();
        }
        return globalInstance;
    }


    public String getPortalDevURL() {
        return portalDevURL;
    }

    public String getAdminDevURL() {
        return adminDevURL;
    }

    public String getPortalTestingURL() {
        return portalTestingURL;
    }

    public String getAdminTestingURL() {
        return adminTestingURL;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public String getUploadFileFolder() {
        return uploadFileFolder;
    }

    public String getDownloadFileFolder() {
        return downloadFileFolder;
    }

    public String getBrowserLogFolder() {
        return browserLogFolder;
    }

    public String getReportingScreenshort() {
        return reportingScreenshort;
    }

    public String getDBDevURL() {
        return DBDevURL;
    }

    public String getDBDevUser() {
        return DBDevUser;
    }

    public String getDBDevPass() {
        return DBDevPass;
    }

    public long getShortTimeout() {
        return shortTimeout;
    }

    public long getLongTimeout() {
        return longTimeout;
    }

    public long getRetryTestFail() {
        return retryTestFail;
    }

    public static String getJavaVersion() {
        return javaVersion;
    }

    public String getDataPath() {
        return dataPath;
    }

    public String getEnvConfigPath() {
        return envConfigPath;
    }


    private final String portalDevURL = "";
    private final String adminDevURL = "";
    private final String portalTestingURL = "";
    private final String adminTestingURL = "";
    private final String projectPath = System.getProperty("user.dir");

    private final String uploadFileFolder = projectPath + File.separator + "uploadFiles";
    private final String downloadFileFolder = projectPath + File.separator + "downloadFiles";
    private final String browserLogFolder = projectPath + File.separator + "browserLogs";
    private final String reportingScreenshort = projectPath + File.separator + "ReportNGScreenShots"+ File.separator;

    private  final  String dataPath = projectPath + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator ;

    private  final  String envConfigPath = projectPath + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator ;

    private final String DBDevURL = "192.168.1.15:9860";
    private final String DBDevUser = "user";
    private final String DBDevPass = "pass";


    private final long shortTimeout = 5;
    private final long longTimeout = 30;
    private final long retryTestFail = 3;

    private static final String javaVersion = System.getProperty("java.version");

}

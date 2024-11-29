package Common.Classes;

import android.app.Notification;
import android.os.Environment;

public class GlobalVariables
{
    public static String ip = "https://npax-mcframe.com/AndIOL/";
    public static int density = 1; //Added to get pixel density
    public static String  port = "https://npax-mcframe.com/IOLNPAXFinancials/";
    public static String USER_NAME = "NPAX";
    public static String PASSWORD = "admin";
    public static Boolean ENABLE_BASIC = true;

    public static String BASE = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    public static String NPAX_ROOT = BASE+"/661dcd64597c3873241b25a8a927832f";
    public static String SCAN_LOGS = BASE+"/661dcd64597c3873241b25a8a927832f/IOL/nxpert/scans";
    public static String POSTING_LOGS = BASE+"/661dcd64597c3873241b25a8a927832f/IOL/nxpert/postings";
    public static String PENDING_LOGS  = BASE+"/661dcd64597c3873241b25a8a927832f/IOL/nxpert/pendings";

    public static String SCAN_LOG_FILE = "scanLogs.txt";
    public static String POST_LOG_FILE = "postLog.txt";

    public static String TOKEN = "fTpw5I6FpOs=";
    public static String ACCESS = "j370pRQMuOdilPgArIxqHuWz1M5fVc+IcbPOm96Xz86kOWCmMfIGeV3ntxEVCloz7/kchixNKvil4DmNLCbd97F3AdQrsN971yK/BcHEMghWDuGn5xuEZ5a+/ACCSiOryhLzYDeggXa+Mr/EPyMLNYFa3/mnN9ivLv8J+vRAQtLg4aqtYGZJO26CjooYBra8QzV65AvOGX67vvVTHR9gpVbjTnYk1fXrQ0MoBk48ueGzNGSZVRRrC1Wd0U28z66IgVrf+ac32K/XXc5tdWyQT5oKOkaUydS9AZyLG8ckwxpwtNxQL9EWaWZ3oCj+4yDrkn978lhB+o/2AxdqlsX1MbIGH91EnDN8cbPOm96Xz86kOWCmMfIGeV3ntxEVCloz4IvbX8o3Or4eUJCUT2Whobu+9VMdH2Cl+NKWiL2ttE3g4aqtYGZJO90Ess7peA1Ft/iA/Sv5iUKF6yqDsdldcfS4iwgxw4frmgo6RpTJ1L37QDpziPySKOyEn1jQOId8ZnegKP7jIOuSf3vyWEH6jyAxuKVaOESOv52yYmbZnztxs86b3pfPzqQ5YKYx8gZ5Xee3ERUKWjPMXGjQZehzMnhRLEXwth+ihesqg7HZXXH0uIsIMcOH65oKOkaUydS9DyfIvCnwebwVg51Nhx+64e+aHpnq+WoVW9B9MRomIoc=";

    public static String ROOT_DIR = "IOL";
    public static String TIME_OUT = "1";
    public static String LATENCY = "999.99";
    public static boolean SHOW_PROGRESS_DIALOG = false;

    public static String PENDING_COST_CENTER = "";
    public static String CACHED_COST_CENTER = "010101";
    public static String USER_COST_CENTER = "010101";
    public static String CACHED_USER_CODE;
    public static String CACHED_USER_PASSWORD;
    public static String LOGGED_USER_CODE;

    public static String LOGGED_USER_LNAME;
    public static String LOGGED_USER_FNAME;
    public static String LOGGED_USER_MI;


    public static String classs = "";
    public static String CACHED_VERSION;

    public static String RoomNumber = "";
    public static String RoomList = "";
    public static String selectedRoomNumber = "";
    public static String RoomStatusList = "";
    public static String RoomsForSanitation = "";
    public static String RoomsUnderSanitation = "";
    public static String RoomStatus = "";
    public static String CheckInType = "";
    public static String AddChargeType = "";

    public static String CodeList = "";
    public static String PackageList = "";
    public static String TransactionNumber = "";
    public static String Qty = "";
    public static String RoomCharge = "";
    public static String RoomChargeCode = "";
    public static String RoomChargeName = "";
    public static String RoomMonitoringSelection = "";
    public static String EndTime = "";
    public static String StopSynchService = "";
    public static String StopTimeService = "";
    public static boolean IsSynching = false;
    public static boolean IsManualSynching = false;
    public static String Reason = "";
    public static String CACHED_PRINT_NAME = "";
    public static String CACHED_PRINT_MCADDRESS = "";
    public static String id3 ="";
    public static int LOGGED_USER_ADMINFLAG;
    public static String classsActivity = "";
    public static String REPRINT = "";

    //    public static String mac_address="997c7bd1ac5ab068";
    public static String mac_address;
    public static boolean xrSubmit = false;
    public static String AMSHIFT = "09:00 am - 09:00 pm";
    public static String PMSHIFT = "09:00 pm - 09:00 am";

    public static  String CoffeeBase = "Coffee Base";
    public static  String NoncoffeeBase = "Non Coffee Base";
    public static  String Refreshments = "Refreshments";
    public static  String Pastries = "Pastries";
    public static  String categories = "";

    private static GlobalVariables instance;

    private String category;

    private GlobalVariables() { }


    public static synchronized GlobalVariables getInstance() {
        if (instance == null) {
            instance = new GlobalVariables();
        }
        return instance;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

package com.happysanz.m3admin.utils;

public class M3AdminConstants {

    //URL'S
    //BASE URL
//    private static final String BASE_URL = "https://happysanz.net/";
    private static final String BASE_URL = "https://iyerandrao.com/";

    //BUILD URL
//    public static final String BUILD_URL = BASE_URL + "M3TNSRLM/";
//    public static final String BUILD_URL = BASE_URL + "m3test/";
    public static final String BUILD_URL = BASE_URL + "application/";

    //GENERAL URL
    //Users URL
    public static final String USER_LOGIN_API = "apimain/login/";

    //Forgot password URL
    public static final String USER_FORGOT_PASSWORD = "apimain/forgot_password/";

    //Forgot password URL
    public static final String USER_CHANGE_PASSWORD = "apimain/change_password/";


    //    PIA
//    MOBILIZER LIST
    public static final String GET_MOBILIZER_LIST = "apimain/pia_mob_list";


    //    CENTER LIST
    public static final String GET_CENTER_LIST = "apipia/center_list";

    //    CREATE CENTER
    public static final String CREATE_CENTER = "apipia/create_center";


    //    TASK LIST
    public static final String TASK_LIST = "apipia/list_task";

    //    SCHEME LIST
    public static final String SCHEME_LIST = "apipia/list_scheme";


    //    TRADE LIST
    public static final String TRADE_LIST = "apipia/list_trade";

    //    TRADE LIST
    public static final String UPDATE_TRADE_LIST = "apipia/update_trade";


    public static final String PROJECT_PERIOD = "apipia/project_period";

    //    CENTER GALLERY LIST
    public static final String VIEW_GALLERY = "apipia/center_gallery";

    public static final String ADD_PHOTO = "apipia/add_center_photos/";
    public static final String DELETE_PHOTO = "apipia/center_gallery_delete/";

    public static final String ADD_LOGO = "apipia/update_center_banner/";

    public static final String ADD_VIDEO = "apipia/add_center_videos/";
    public static final String DELETE_VIDEO = "apipia/center_video_delete/";

    public static final String ASSETS_URL_LOGO = "assets/center/logo/";


    public static final String VIEW_VIDEO_GALLERY = "apipia/center_videos";

    //    TRADE LIST
    public static final String CREATE_TRADE = "apipia/create_trade";
    public static final String UPDATE_TRADE = "apipia/update_trade";


    //    PROSPECT LIST
    public static final String ALL_STUDENTS = "apipia/list_students";

    //    PROSPECT STATUS
    public static final String STUDENTS_LIST_STATUS = "apipia/list_students_status";

    //    PROSPECT DETAIL
    public static final String STUDENT_DETAIL = "apipia/view_student";


    //    USER LIST
    public static final String USER_LIST = "apipia/user_list";

    //    Staff LIST
    public static final String TNSRLM_STAFF_LIST = "apimain/user_list";

    //    TASK ADD
    public static final String TASK_ADD = "apipia/add_task";

    //    TASK UPDATE
    public static final String TASK_UPDATE = "apipia/update_task";

    //    PROJECT PERIOD
    public static final String PROJECT_TIME = "apipia/project_period";

    //    ADD CANDIDATE
    public static final String ADD_CANDIDATE = "apipia/add_student";

    //    UPDATE CANDIDATE
    public static final String UPDATE_CANDIDATE = "apipia/update_student";

    //    CREATE USER
    public static final String USER_PROFILE = "apipia/user_profile";

    //    CREATE USER
    public static final String UPDATE_PIA_USER_PROFILE = "apipia/user_profile_update";

    //    CREATE USER
    public static final String UPLOAD_USER_PIC = "apipia/user_profilepic/";

    //    CREATE USER
    public static final String CREATE_USER = "apipia/create_user";

    //    USER UPDATE
    public static final String UPDATE_USER = "apipia/update_user";

    //    CREATE STAFF TNSRLM
    public static final String CREATE_USER_TNSRLM = "apimain/create_user";

    //    STAFF TNSRLM
    public static final String GET_USER_TNSRLM = "apimain/user_details";

    //    USER DETAIL
    public static final String GET_USER = "apipia/user_details";

    //    STAFF TNSRLM UPDATE
    public static final String UPDATE_USER_TNSRLM = "apimain/update_user";

    //    LIVE TRACKING
    public static final String LIVE_TRACKING = "apipia/user_tracking_current";

    //    DISTANCE TRACKING
    public static final String DISTANCE_TRACKING = "apipia/user_tracking";

    //    MOBILISATION PLAN VIEW
    public static final String MOBILIZATION_PLAN_LIST = "apipia/mobilization_plan_list";
    public static final String MOBILIZATION_PLAN_FILE_ID = "apipia/mobilization_plan/";
    public static final String MOBILIZATION_PLAN_FILE_UPLOAD = "apipia/mobilization_plan_upload/";

    //    PROJECT PERIOD VIEW
    public static final String PROJECT_PERIOD_LIST = "apipia/project_period_list";


    //    Task add params
    public static final String PARAMS_TASK_TITLE = "task_title";
    public static final String PARAMS_TASK_ID = "task_title";
    public static final String PARAMS_TASK_DESCRIPTION = "task_description";
    public static final String PARAMS_TASK_DATE = "task_date";
    public static final String PARAMS_TASK_STATUS = "status";

    //    Task add params
    public static final String PARAMS_TRADE_TITLE = "trade_name";
    public static final String PARAMS_TRADE_ID = "trade_id";

    public static final String UPLOAD_CANDIDATE_PIC = "student_picupload/";

    //Mobilizer URL
    private static final String MOBILIZER_API = "http://happysanz.net/m3test/apimobilizer/";
    public static final String BLOOD_GROUP_LIST = MOBILIZER_API + "select_bloodgroup/";


    //    TNSRLM

    //    PIA Creation URL
    public static final String CREATE_PIA = "apimain/create_pia";

    //    PIA Creation URL
    public static final String PIA_LIST = "apimain/pia_list";


    //    Service Params
    public static String PARAM_MESSAGE = "msg";

    // User Login Preferences
    // User data
    public static final String KEY_USER_NAME = "user_name";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_STUDENT_ID = "student_id";
    public static final String KEY_USER_MASTER_ID = "user_master_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_USER_IMAGE = "user_pic";
    public static final String KEY_USER_TYPE = "user_type";
    public static final String KEY_USER_TYPE_NAME = "user_type_name";

    // PIA Profile
    public static final String KEY_PIA_PROFILE_ID = "pia_profile_id";
    public static final String KEY_PIA_ID = "pia_id";
    public static final String KEY_PIA_PRN_NUMBER = "pia_prn_number";
    public static final String KEY_PIA_NAME = "pia_name";
    public static final String KEY_PIA_ADDRESS = "pia_address";
    public static final String KEY_PIA_PHONE = "pia_phone";
    public static final String KEY_PIA_EMAIL = "pia_email";

    //    Shared FCM ID
    public static final String KEY_FCM_ID = "fcm_id";


    public static final String KEY_AADHAAR = "aadhaar_action";


    public static final String PARAMS_CENTER_ID = "center_id";
    public static final String PARAMS_CENTER_PHOTO = "center_photo";
    public static final String PARAMS_PHOTO_ID = "gallery_id";
    public static final String PARAMS_VIDEO_ID = "video_id";
    public static final String PARAMS_VIDEO_TITLE = "video_title";
    public static final String PARAMS_VIDEO_LINK = "video_link";


    public static final String PARAMS_START_DATE = "start_date";
    public static final String PARAMS_END_DATE = "end_date";


    // Alert Dialog Constants
    public static String ALERT_DIALOG_TITLE = "alertDialogTitle";
    public static String ALERT_DIALOG_MESSAGE = "alertDialogMessage";
    public static String ALERT_DIALOG_TAG = "alertDialogTag";
    public static String ALERT_DIALOG_POS_BUTTON = "alert_dialog_pos_button";
    public static String ALERT_DIALOG_NEG_BUTTON = "alert_dialog_neg_button";

    //    SignIn params
    public static final String PARAMS_USERNAME = "user_name";
    public static final String PARAMS_PASSWORD = "password";
    public static final String PARAMS_OLD_PASSWORD = "old_password";
    public static final String PARAMS_NEW_PASSWORD = "new_password";
    public static final String PARAMS_GCM_KEY = "device_id";
    public static final String PARAMS_MOBILE_TYPE = "mobile_type";

    //    Create Pia params
    public static final String PARAMS_USER_ID = "user_id";
    public static final String PARAMS_UNIQUE_NUMBER = "unique_number";
    public static final String PARAMS_NAME = "name";
    public static final String PARAMS_ROLE = "select_role";
    public static final String PARAMS_ADDRESS = "address";
    public static final String PARAMS_SEC_PHONE = "sec_phone";
    public static final String PARAMS_PHONE = "phone";
    public static final String PARAMS_EMAIL = "email";
    public static final String PARAMS_SEC_EMAIL = "sec_email";

    //    Create Pia params
    public static final String PARAMS_MOB_ID = "mob_id";

    //    Create Center params
    public static final String PARAMS_CENTER_NAME = "center_name";
    public static final String PARAMS_CENTER_ADDRESS = "center_address";
    public static final String PARAMS_CENTER_INFO = "center_info";


    //    Upload File
    public static final String PARAMS_DOC_NAME = "doc_name";
    public static final String PARAMS_DOC_TIME = "doc_month_year";

    //    Add candidate params
    public static final String PARAMS_HAVE_AADHAAR_CARD = "have_aadhaar_card";
    public static final String PARAMS_AADHAAR_CARD_NUMBER = "aadhaar_card_number";
    public static final String PARAMS_SEX = "sex";
    public static final String PARAMS_GENDER = "sex";
    public static final String PARAMS_DOB = "dob";
    public static final String PARAMS_AGE = "age";
    public static final String PARAMS_NATIONALITY = "nationality";
    public static final String PARAMS_RELIGION = "religion";
    public static final String PARAMS_COMMUNITY_CLASS = "community_class";
    public static final String PARAMS_COMMUNITY = "community";
    public static final String PARAMS_FATHER_NAME = "father_name";
    public static final String PARAMS_MOTHER_NAME = "mother_name";
    public static final String PARAMS_MOBILE = "mobile";
    public static final String PARAMS_SEC_MOBILE = "sec_mobile";
    public static final String PARAMS_STATE = "state";
    public static final String PARAMS_CITY = "city";
    public static final String PARAMS_MOTHER_TONGUE = "mother_tongue";
    public static final String PARAMS_DISABILITY = "disability";
    public static final String PARAMS_BLOOD_GROUP = "blood_group";
    public static final String PARAMS_ADMISSION_DATE = "admission_date";
    public static final String PARAMS_ADMISSION_LOCATION = "admission_location";
    public static final String PARAMS_ADMISSION_LATITUDE = "admission_latitude ";
    public static final String PARAMS_ADMISSION_LONGITUDE = "admission_longitude";
    public static final String PARAMS_PREFERRED_TRADE = "preferred_trade";
    public static final String PARAMS_PREFERRED_TIMING = "preferred_timing";
    public static final String PARAMS_LAST_INSTITUTE = "last_institute";
    public static final String PARAMS_LAST_STUDIED = "last_studied";
    public static final String PARAMS_QUALIFIED_PROMOTION = "qualified_promotion";
    public static final String PARAMS_QUALIFICATION = "qualification";
    public static final String PARAMS_TRANSFER_CERTIFICATE = "transfer_certificate";
    public static final String PARAMS_STATUS = "status";
    public static final String PARAMS_CREATED_BY = "created_by";
    public static final String PARAMS_CREATED_AT = "created_at";
    public static final String PARAMS_UPDATED_BY = "updated_by";
    public static final String PARAMS_UPDATED_AT = "updated_at";
    public static final String PARAMS_PIA_ID = "pia_id";


    // Tracking
    public static final String PARAMS_TRACK_DATE = "track_date";


}

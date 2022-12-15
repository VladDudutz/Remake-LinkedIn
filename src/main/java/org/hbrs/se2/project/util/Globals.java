package org.hbrs.se2.project.util;

public class Globals {
    public static final String CURRENT_USER = "current_User";

    public static class Pages {
        public static final String MAIN_VIEW = "main";
        public static final String LOGIN_VIEW = "";
        public static final String JOBS_VIEW = "jobs";
        public static final String STUDENT_PROFILE_VIEW = "student-profile";
        public static final String COMPANY_PROFILE_VIEW = "company-profile";
        public static final String MYADS_VIEW = "myads";
        public static final String REGISTER_COMPANY_VIEW = "register-company";
        public static final String REGISTER_STUDENT_VIEW = "register-student";
        public static final String NEW_ADD_VIEW = "new-job-ad";
        public static final String SEARCH_STUDENT_VIEW = "search-student-view";
        public static final String STUDENT_INBOX_VIEW = "student-inbox";
        public static final String COMPANY_INBOX_VIEW = "company-inbox";
    }

    public static class Roles {
        public static final String student = "student";
        public static final String company = "company";

    }

    public static class Errors {
        public static final String NOUSERFOUND = "nouser";
        public static final String SQLERROR = "sql";
        public static final String DATABASE = "database";
    }
}

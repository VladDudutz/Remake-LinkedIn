package org.hbrs.se2.project.util;

public class Globals {
    public static final String CURRENT_USER = "current_User";
    public static final long MAXIMUM_PAGE_LOADINGTIME = 2000;

    private Globals() {
        throw new IllegalStateException("Utility class; cannot be instantiated!");
    }

    public static class Pages {
        private Pages() {
            throw new IllegalStateException("Constant collection; cannot be instantiated!");
        }
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
        private Roles() {
            throw new IllegalStateException("Constant collection; cannot be instantiated!");
        }
        public static final String STUDENT = "student";
        public static final String COMPANY = "company";

    }

    public static class IllegalOSExcpetion extends Exception{
        public IllegalOSExcpetion(String warning){
            super(warning);
        }
    }
}

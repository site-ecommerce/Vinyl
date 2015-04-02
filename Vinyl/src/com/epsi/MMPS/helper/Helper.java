package com.epsi.MMPS.helper;

import javax.servlet.http.HttpSession;

import com.epsi.MMPS.beans.Customer;
import com.epsi.MMPS.dao.CustomerDao;

public class Helper {

	public static boolean isSet(String str) {
        return str != null && str.trim().length() > 0;
    }
	
}


package com.scm.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {

    public static void removeMsg() {
        try {
            // Retrieve the request attributes
            System.out.println("removing message from session");
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            
            // Check if attributes are not null to avoid NullPointerException
            if (attributes != null) {
                HttpSession session = attributes.getRequest().getSession();
                // Remove the "msg" attribute from the session
                session.removeAttribute("msg");
            } else {
                System.out.println("No request attributes found. Unable to retrieve session.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package cf.dinhthanhphu.utils;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

public class MessageUtil {
    static ResourceBundle resourcebundle = ResourceBundle.getBundle("message");

    public static void showMessage(HttpServletRequest req) {
        
        String message = req.getParameter("message");
        String alter = req.getParameter("alter");
        if (message != null && alter != null) {
            req.setAttribute("messageResponse", resourcebundle.getString(message));
            req.setAttribute("alter", alter);
        }

    }

}

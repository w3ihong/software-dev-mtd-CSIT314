package control;

import entity.SysAdmin;
import java.sql.ResultSet;

public class AdminSearchUserAccountController {
    public ResultSet SearchUserAccount(SysAdmin sa, String username) {
        SysAdmin sysAdmin = new SysAdmin(sa);
        return sysAdmin.SearchUser(username);
    }
}
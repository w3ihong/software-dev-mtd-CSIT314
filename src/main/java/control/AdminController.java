package control;

import entity.User;
import entity.SysAdmin;
import java.sql.ResultSet;

public class AdminController {

    public User AdminViewUserAccount(SysAdmin sa, User user) {
        sa = new SysAdmin(sa);
        return sa.RetrieveUserAccountData(user);
    }

    public ResultSet displayUsers(SysAdmin sa) {
        SysAdmin sysAdmin = new SysAdmin(sa);
        return sysAdmin.displayUsers();
    }

    public boolean suspendUser(SysAdmin sa, String username) {
        SysAdmin sysAdmin = new SysAdmin(sa);
        return sysAdmin.suspendUser(username);
    }
}

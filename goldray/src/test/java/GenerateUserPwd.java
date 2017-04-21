import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * Created by zwb on 2017/4/21.生成用户名密码
 */
public class GenerateUserPwd {

    private static final String ADMIN_USER_PREFIX = "custom.admin.user.";

    //设置用户名
    private String username = "jessedong";

    //设置密码
    private String pwd = "admin123";

    @Test
    public void test() {
        String md5Pwd = DigestUtils.md5Hex(username + pwd);
        md5Pwd = ADMIN_USER_PREFIX + username + "=" + md5Pwd;
        System.out.println("请把:" + md5Pwd + " 复制到application.properties中，重启项目，即可");
    }
}

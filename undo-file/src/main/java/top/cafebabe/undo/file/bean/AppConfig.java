package top.cafebabe.undo.file.bean;

/**
 * @author cafababe
 */
public class AppConfig {

    public static final int HTTP_TIMEOUT = 100;

    // api 配置
    public static final String USER_GET_LOGIN_USER_API = "http://127.0.0.1:8090/innerApp/getUserDetail/"; // 通过 Token 获取 loginUser 的接口地址

    // 密钥配置
    public static final String INNER_APP_PASSWORD = "NOCAFE"; // 访问 User 模块的口令

    // header 中令牌配置
    public static final String TOKEN_NAME_IN_HEADER = "token"; // token 在 header 中的 key
    public static final String INNER_APP_PASSWORD_NAME_IN_HEADER = "innerApp";// 其他组建口令在 header 中的 key

    // session 配置
    public static final int SESSION_TIMEOUT = 10 * 60; // session 中 loginUser 超时时间，单位：秒
    public static final String LOGIN_USER_KEY_IN_SESSION = "loginUser";
    public static final String USER_TOKEN_KEY_IN_SESSION = "Token";
    public static final String USER_TOKEN_REFRESH_TIME_KEY_IN_SESSION = "refreshTime";
    public static final String ADMIN_LOGIN_TOKEN_KEY_IN_SESSION = "admin";
}

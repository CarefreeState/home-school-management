package com.macaron.homeschool.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created With Intellij IDEA
 * Description:
 * User: 马拉圈
 * Date: 2024-11-06
 * Time: 0:41
 */
@Slf4j
public class PasswordUtil {

    private final static String PASSWORD_SEPARATOR = "$";

    public static String assemble(String salt, String password) {
        return salt + PASSWORD_SEPARATOR + EncryptUtil.encrypt(salt, password);
    }

    public static boolean confirm(String inputPassword, String dbPassword) {
        try {
            int separatorIndex = dbPassword.indexOf(PASSWORD_SEPARATOR);
            String salt = dbPassword.substring(0, separatorIndex);
            String encryptPassword = dbPassword.substring(separatorIndex + 1);
            boolean confirm = EncryptUtil.confirm(salt, inputPassword, encryptPassword);
            log.info("inputPassword {}, dbPassword {} (salt {}, encryptPassword {}) -> {}",
                    inputPassword, dbPassword, salt, encryptPassword, confirm);
            return confirm;
        } catch (Exception e) {
            log.info("inputPassword {}, dbPassword {} -> false", inputPassword, dbPassword);
            return Boolean.FALSE;
        }
    }
}

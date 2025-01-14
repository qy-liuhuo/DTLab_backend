package com.mobinets.digitaltwinlab.util;

import com.mobinets.digitaltwinlab.entity.User;
import org.springframework.stereotype.Component;

/**
 * 持有用户信息，用于代替session对象，主要应用于权限验证
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user) {
        users.set(user);
    }
    public User getUser() {
        return users.get();
    }
    public void clear() {
        users.remove();
    }
}

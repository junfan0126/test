package com.cs533.cache;


import com.cs533.Entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserLocalCache {

        private static Map<String, User> userMap;

        private UserLocalCache() {}

        public static void addUser(User user) {
            userMap.put(user.getUsername(), user);
        }

        public static void removeUser(String username) {
            userMap.remove(username);
        }

        public static int getOnlineUserCount() {
            return userMap.size();
        }

        public static void init() {
            userMap = new HashMap<>();
        }

        public static void destroy() {
            userMap = null;
        }

    }



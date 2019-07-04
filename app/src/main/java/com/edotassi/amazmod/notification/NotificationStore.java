package com.edotassi.amazmod.notification;

import com.huami.watch.notification.data.StatusBarNotificationData;
import com.huami.watch.transport.DataBundle;

import java.util.HashMap;
import java.util.Map;

import amazmod.com.transport.data.NotificationData;

public class NotificationStore {

    public static Map<String, DataBundle> standardNotifications;
    public static Map<String, DataBundle> removedNotifications;
    public static Map<String, NotificationData> customNotifications;
    public static Map<String, String> UUIDmap;

    NotificationStore() {
        standardNotifications = new HashMap<>();
        removedNotifications = new HashMap<>();
        customNotifications = new HashMap<>();
        UUIDmap = new HashMap<>();
    }

    public static DataBundle getStandardNotification(String uuid) {
        return standardNotifications.get(uuid);
    }

    public static int getStandardNotificationCount() {
        return standardNotifications.size();
    }

    public static void addStandardNotification(String uuid, DataBundle dataBundle) {
        standardNotifications.put(uuid, dataBundle);
        UUIDmap.put(uuid, ((StatusBarNotificationData) dataBundle.getParcelable("data")).key);
    }

    public static void removeStandardNotification(String uuid) {
        standardNotifications.remove(uuid);
        UUIDmap.remove(uuid);
    }

    public static DataBundle getRemovedNotification(String uuid) {
        return removedNotifications.get(uuid);
    }

    public static int getRemovedNotificationCount() {
        return removedNotifications.size();
    }

    public static void addRemovedNotification(String uuid, DataBundle dataBundle) {
        removedNotifications.put(uuid, dataBundle);
        UUIDmap.put(uuid, ((StatusBarNotificationData) dataBundle.getParcelable("data")).key);
    }

    public static void removeRemovedNotification(String uuid) {
        removedNotifications.remove(uuid);
        UUIDmap.remove(uuid);
    }

    public static NotificationData getCustomNotification(String uuid) {
        return customNotifications.get(uuid);
    }

    public static int getCustomNotificationCount() {
        return customNotifications.size();
    }

    public static void addCustomNotification(String uuid, NotificationData notificationData) {
        customNotifications.put(uuid, notificationData);
        UUIDmap.put(uuid, notificationData.getKey());
    }

    public static void removeCustomNotification(String uuid) {
        customNotifications.remove(uuid);
        UUIDmap.remove(uuid);
    }

}

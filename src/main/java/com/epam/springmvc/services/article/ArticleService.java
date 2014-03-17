package com.epam.springmvc;

import java.util.List;

import com.epam.ubsbud.ewm.valueobjects.EwmNotification;

public interface NotificationService {
    public List<EwmNotification> getNotifications();
}

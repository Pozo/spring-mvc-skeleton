package com.epam.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.ubsbud.ewm.core.NotificationService;
import com.epam.ubsbud.ewm.valueobjects.EwmNotification;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationProvider notificationProvider;
    
    @Override
    public List<EwmNotification> getNotifications() {
        return notificationProvider.getNotifications();
    }

}

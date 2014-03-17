package com.epam.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.epam.ubsbud.ewm.valueobjects.EwmNotification;

@Component
class RandomNotificationProvider implements NotificationProvider {
    //private static final Logger logger = Logger.getLogger(RandomNotificationProvider.class.getName());
    private static int index = 0;
    
    @Autowired
    private ApplicationContext context;
    
    @Override
    public List<EwmNotification> getNotifications() {
        List<EwmNotification> notifications = new ArrayList<>();
        
        EwmNotification ewmNotification = new EwmNotification();
        EwmNotification ewmNotification1 = new EwmNotification();
        EwmNotification ewmNotification2 = new EwmNotification();
        
        ewmNotification.setDateTime("45 min");
        ewmNotification.setBodyText("We have discovered an Asset Allocation Breach in your portfolio which require your attention. We have identified a trading opportunity which will correct this issue. ");
        ewmNotification.setHighlightText("Health Issue For UBS Advice Portfolio 1");
        ewmNotification.setThumbnail(String.format("%s%s","data:image/png;base64,", ImageHelper.encodeToString(context.getClassLoader().getResourceAsStream("MockNotificationImage.png"))));
        
        ewmNotification1.setDateTime("23.10.13");
        ewmNotification1.setBodyText("Dear Heikko, you have a fairly high Apple exposure in UBS Brokerage Portfolio 2. Take a look at this trading idea.");
        ewmNotification1.setHighlightText("Janik has a new trading idea for you. ");
        ewmNotification1.setThumbnail(String.format("%s%s","data:image/png;base64,", ImageHelper.encodeToString(context.getClassLoader().getResourceAsStream("MockNotificationImage.png"))));
        
        ewmNotification2.setDateTime("23.08.13");
        ewmNotification2.setBodyText("We have identified an opportunity within the high-tech sector which our research shows is likely to...");
        ewmNotification2.setHighlightText("New treading idea: UBS Brokerage Protfolio 3");
        ewmNotification2.setThumbnail(String.format("%s%s","data:image/png;base64,", ImageHelper.encodeToString(context.getClassLoader().getResourceAsStream("MockNotificationImage.png"))));
        
        EwmNotification[] notificationsArray = new EwmNotification[]{ewmNotification,ewmNotification1,ewmNotification2};
        
        notifications.add(notificationsArray[index]);
        
        if(index < notificationsArray.length-1){
            index++;   
        }
        
        return notifications;
    }
}
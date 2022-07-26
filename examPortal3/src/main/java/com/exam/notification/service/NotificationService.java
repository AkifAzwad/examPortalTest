//package com.exam.notification.service;
//
//import java.util.Date;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.exam.model.User;
//import com.exam.notification.model.Notification;
//import com.exam.notification.repo.NotificationRepository;
//
//@Service
//public class NotificationService {
//	@Autowired
//	private NotificationRepository notificationRepository;
//
//	private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
//
//	public NotificationService() {
//	}
//
//	public Map<String, Object> updateUserNotification(Notification notification, User user) {
//
////		notification = save(notification);
////		if (notification == null) {
////			return KYCUtilities._errorMultipleObject(MessageUtility.getErrorMessage("NotificationNotUpdated"),
////					HttpStatus.INTERNAL_SERVER_ERROR);
////		}
////
////		return KYCUtilities._successMultipleObject(ObjectMap.objectMap(notification),
////				MessageUtility.getSuccessMessage("NotificationUpdated"));
//		return null;
//	}
//
//	public Notification save(Notification notification) {
//		try {
//			return notificationRepository.save(notification);
//		} catch (Exception e) {
//			logger.error("Exception occur while save Notification ", e);
//			return null;
//		}
//	}
//
//	public Notification findByUser(User user) {
//		try {
//			return notificationRepository.findByUser(user);
//		} catch (Exception e) {
//			logger.error("Exception occur while fetch Notification by User ", e);
//			return null;
//		}
//	}
//
////	public List<Notification> findByUser(User user, Integer limit) {
////		try {
////			return notificationRepository.userNotification(user.getId(), new PageRequest(0, limit));
////		} catch (Exception e) {
////			logger.error("Exception occur while fetch Notification by User ", e);
////			return null;
////		}
////	}
//
//	public Notification createNotificationObject(String message, User user) {
//		return new Notification(message, new Date(), user);
//	}
//
//	public Notification findByUserAndNotificationId(User user, Integer notificationId) {
//		try {
//			return notificationRepository.findByUserAndNotificationId(user, notificationId);
//		} catch (Exception e) {
//			logger.error("Exception occur while fetch Notification by User and Notification Id ", e);
//			return null;
//		}
//	}
//}

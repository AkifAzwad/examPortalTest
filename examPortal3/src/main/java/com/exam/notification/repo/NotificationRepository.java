//package com.exam.notification.repo;
//
//import java.util.List;
//
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.exam.model.User;
//import com.exam.notification.model.Notification;
//
//public interface NotificationRepository extends JpaRepository<Notification, Integer> {
//	Notification findByUser(User user);
//
//	@Query("select n from Notification n where n.user.uid=:userId ORDER BY n.createdAt DESC")
//	List<Notification> userNotification(@Param("userId") Integer userId, Pageable pageSize);
//
//	Notification findByUserAndNotificationId(User user, Integer notificationId);
//}

//package com.exam.notification.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.exam.notification.service.NotificationService;
//
//@RestController
//public class NotificationController {
//	@Autowired
//	private NotificationService notificationService;
//
//	private static Logger logger = LoggerFactory.getLogger(NotificationController.class);
//
//	public NotificationController() {
//	}
//
////	@RequestMapping(value="/notifications/user",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
////	public ResponseEntity<Object> getNotificationsByUser(@RequestParam(required=false,defaultValue="") String limit){
////
////		logger.debug("inside getNotificationsByUser api for fetch user notification ");
////		Integer intLimit = KYCUtilities.parseIntoInteger(limit);
////		
////		if(intLimit == null){
////			return ResponseUtil.errorResponse(MessageUtility.getErrorMessage("IntLimit"),HttpStatus.BAD_REQUEST);
////		}
////		
////		User user = notificationService.getLoggedInUser();
////
////		List<Notification> notifications = notificationService.findByUser(user, intLimit);
////
////		Map<String,Object> response = new HashMap<String,Object>();
////		response.put("notifications", ObjectMap.objectMap(notifications));
////		response.put("user", ObjectMap.objectMap(user,"email"));
////		
////		return ResponseUtil.response(response, MessageUtility.getSuccessMessage("NotificationFethced"), HttpStatus.OK);
////	}
////
////	@RequestMapping(value="/notifications/user",method=RequestMethod.PATCH,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
////	public ResponseEntity<Object> updateUserNotification(@RequestHeader(@Valid @RequestBody Req_UpdateNotitfication reqUpdateNotitfication){
////
////		logger.debug("inside updateUserNotification api ");
////		Map<String,Object> response = notificationService.updateUserNotification(reqUpdateNotitfication,reqUpdateNotitfication.getUser());
////		
////		if((boolean)response.get("error") == true){
////			return ResponseUtil.errorResponse(response.get("message").toString(),(HttpStatus)response.get("status"));
////		}
////
////		return ResponseUtil.response(response.get("data"),response.get("message").toString(),HttpStatus.OK);	
////	}
//}

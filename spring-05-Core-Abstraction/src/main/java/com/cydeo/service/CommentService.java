package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.proxy.EmailCommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository,
                          //       @Qualifier("emailCommentNotificationProxy") CommentNotificationProxy commentNotificationProxy) {
                          //      @Qualifier("pushCommentNotificationProxy") CommentNotificationProxy commentNotificationProxy) {
                          //      @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
                          @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {

        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {

        //save in the DB
        //send email

        commentRepository.storeComment(comment);
        commentNotificationProxy.sentComment(comment);


    }

}

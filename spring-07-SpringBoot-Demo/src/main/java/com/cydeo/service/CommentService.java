package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private final AppConfigData appConfigData;
    private final DBConfigData dbconfigdata;

    public CommentService(CommentRepository commentRepository,
                          //       @Qualifier("emailCommentNotificationProxy") CommentNotificationProxy commentNotificationProxy) {
                          //      @Qualifier("pushCommentNotificationProxy") CommentNotificationProxy commentNotificationProxy) {
                          //      @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
                          @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData, DBConfigData dbconfigdata) {

        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbconfigdata = dbconfigdata;
    }

    public void publishComment(Comment comment) {

        //save in the DB
        //send email

        commentRepository.storeComment(comment);
        commentNotificationProxy.sentComment(comment);


    }

    public void printConfigData(){
        System.out.println( appConfigData.getUserName());
        System.out.println( appConfigData.getPassword());
        System.out.println( appConfigData.getUrl());


    }
    public void printDBConfigData(){
        System.out.println( dbconfigdata.getUserName());
        System.out.println( dbconfigdata.getPassword());
        System.out.println( dbconfigdata.getType());


    }

}

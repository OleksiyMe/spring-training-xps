package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")
public class EmailCommentNotificationProxy implements CommentNotificationProxy{

    @Override
    public void sentComment(Comment comment) {
        System.out.println("Sending email notification for comment : "+ comment.getText());
    }

}

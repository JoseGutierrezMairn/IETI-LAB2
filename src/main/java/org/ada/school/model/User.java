package org.ada.school.model;

import org.ada.school.dto.UserDto;
import org.ada.school.model.document.UserDocument;

import java.util.Date;
import java.util.UUID;

public class User

{

    String id;

    String name;

    String email;

    String lastName;

    Date createdAt;


    public User( UserDto userDto )
    {
        id = UUID.randomUUID().toString();
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
    }

    public User(UserDocument userDocument){
        id = userDocument.getId();
        name = userDocument.getName();
        lastName = userDocument.getLastName();
        email = userDocument.getEmail();
        createdAt = userDocument.getCreatedAt();
    }

    public User( UserDto userDto, String id )
    {
        this.id = id;
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date();
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public void update( UserDto userDto )
    {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
    }

    public void DocToUser(UserDocument userDocument)
    {
        this.lastName = userDocument.getLastName();
        this.email = userDocument.getEmail();
        this.lastName = userDocument.getLastName();
        this.createdAt = userDocument.getCreatedAt();
    }
}
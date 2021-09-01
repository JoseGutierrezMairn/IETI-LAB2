package org.ada.school.repository;

import org.ada.school.model.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;


public interface UserRepository extends MongoRepository<UserDocument, String> {

    public List<UserDocument> findByNameLikeOrLastNameLike(String n, String ln );

    public List<UserDocument> findByCreatedAtAfter( Date createdAt );

}
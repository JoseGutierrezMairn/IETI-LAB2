package org.ada.school.repository;

import org.ada.school.model.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<UserDocument, String> {


}
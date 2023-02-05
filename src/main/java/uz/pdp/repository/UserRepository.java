package uz.pdp.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import uz.pdp.domain.model.user.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static uz.pdp.util.FileUtils.objectMapper;
import static uz.pdp.util.FileUtils.userPath;

public interface UserRepository {
    File file = new File(userPath);
    default ArrayList<User> getUserList() {
        try {
            return objectMapper.readValue(file, new TypeReference<ArrayList<User>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    default void writeToFile(ArrayList<User> userList) {
        try {
            objectMapper.writeValue(file, userList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

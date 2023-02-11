package uz.pdp.domain.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import uz.pdp.domain.model.BaseModel;
@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class Manager extends BaseModel {
    final String name="Manager";
    final String lastName="Manager";
    final String email="Manager1234.gmail.com";
    final String password="12345qwerty";
    final UserRole role=UserRole.MANAGER;
}

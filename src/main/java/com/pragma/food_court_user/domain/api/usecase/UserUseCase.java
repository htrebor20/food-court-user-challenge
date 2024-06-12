package com.pragma.food_court_user.domain.api.usecase;

import com.pragma.food_court_user.domain.Constants;
import com.pragma.food_court_user.domain.api.IRoleServicePort;
import com.pragma.food_court_user.domain.api.IUserServicePort;
import com.pragma.food_court_user.domain.enums.RoleEnum;
import com.pragma.food_court_user.domain.exception.BadRequestValidationException;
import com.pragma.food_court_user.domain.model.Role;
import com.pragma.food_court_user.domain.model.User;
import com.pragma.food_court_user.domain.spi.IUserPersistencePort;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    private final IRoleServicePort roleServicePort;

    public UserUseCase(IUserPersistencePort userPersistencePort, IRoleServicePort roleServicePort) {
        this.userPersistencePort = userPersistencePort;
        this.roleServicePort = roleServicePort;
    }

    @Override
    public User saveUserOwner(User user) {
        validateAge(user);
        validateUser(user);
        return saveUser(user, RoleEnum.OWNER.getRoleName());
    }

    @Override
    public User saveUserEmployee(User user) {
        validateUser(user);
        return saveUser(user, RoleEnum.EMPLOYEE.getRoleName());
    }

    @Override
    public User saveUserCustomer(User user) {
        validateUser(user);
        return saveUser(user, RoleEnum.CUSTOMER.getRoleName());
    }

    @Override
    public User findById(Long id) {
        return userPersistencePort.findById(id);
    }

    private User saveUser(User user, String roleName) {
        Role role = roleServicePort.findByName(roleName);
        user.setRole(role);
        return userPersistencePort.saveUser(user);

    }

    private void validateUser(User user) {
        validateEmail(user.getEmail());
        validateDocument(user.getDocument());
        validatePhone(user.getCellphone());
    }

    private void validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(email).matches()) {
            throw new BadRequestValidationException(String.format(Constants.INVALID_FORMAT, email));
        }
    }

    private void validatePhone(Long phone) {
        String phoneStr = phone.toString();
        String regex = "[+]?[0-9]{10,12}";
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(phoneStr).matches()) {
            throw new BadRequestValidationException(String.format(Constants.INVALID_FORMAT, phoneStr));
        }
    }

    private void validateDocument(Long document) {
        String regex = "[0-9]+";
        String documentStr = document.toString();
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(documentStr).matches()) {
            throw new BadRequestValidationException(String.format(Constants.INVALID_FORMAT, document));
        }
    }

    private void validateAge(User user) {
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(user.getBirthdate(), currentDate).getYears();
        if (age < 18) {
            throw new BadRequestValidationException(Constants.AGE_VALIDATIONS_EXCEPTION_MESSAGE);
        }
    }
}

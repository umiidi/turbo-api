package az.ingress.turboapi.service;

import az.ingress.turboapi.models.request.UserRequest;
import az.ingress.turboapi.models.response.UserResponse;

public interface UserService {

    UserResponse add(UserRequest userRequest);

    UserResponse update(long id, UserRequest userRequest);

}

package az.ingress.turboapi.service.impl;

import az.ingress.turboapi.models.domain.User;
import az.ingress.turboapi.models.request.UserRequest;
import az.ingress.turboapi.models.response.UserResponse;
import az.ingress.turboapi.repository.UserRepository;
import az.ingress.turboapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponse add(UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse update(long id, UserRequest userRequest) {
        User user = modelMapper.map(userRequest, User.class);
        user.setId(id);
        userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }

}

package az.ingress.turboapi.controller;

import az.ingress.turboapi.models.base.BaseResponse;
import az.ingress.turboapi.models.request.UserRequest;
import az.ingress.turboapi.models.response.UserResponse;
import az.ingress.turboapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public BaseResponse<UserResponse> add(@RequestBody UserRequest userRequest) {
        return BaseResponse.success(userService.add(userRequest));
    }

    @PutMapping("/{id}")
    public BaseResponse<UserResponse> update(@PathVariable long id, @RequestBody UserRequest userRequest) {
        return BaseResponse.success(userService.update(id, userRequest));
    }

}

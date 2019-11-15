package canteen.manager.controller;

import canteen.manager.dto.LoginRequest;
import canteen.manager.dto.RegisterRequest;
import canteen.manager.model.User;
import canteen.manager.service.auth.AuthService;
import canteen.manager.service.auth.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @GetMapping("/read")
    public User read() {
        User user = new User();
        user.setUserName("abbes");
        user.setEmail("abbes.ben@gmail.com");
        user.setPassword("123456");
        return user;
    }


}

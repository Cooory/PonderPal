package com.cooory.ponderpal.user;

import com.cooory.ponderpal.user.domain.User;
import com.cooory.ponderpal.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

// Class for API
@RestController // @Controller + @ResponseBody
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/duplicateNewPassword")
    public Map<String, Boolean> duplicateNewPassword(@RequestParam("password") String password) {

        boolean isDuplicate = userService.isDuplicateNewPassword(password);

        Map<String, Boolean> resultMap = new HashMap<>();
        if (isDuplicate) {
            resultMap.put("isDuplicate", true);
        } else {
            resultMap.put("isDuplicate", false);
        }

        return resultMap;

    }

    @PostMapping("/signIn")
    public Map<String, String> signIn(
            @RequestParam("email") String email
            , @RequestParam("password") String password
            , HttpServletRequest request) {

        User user = userService.getUser(email, password);

        Map<String, String> resultMap = new HashMap<>();
        if (user != null) {

            // Success login
            HttpSession session = request.getSession();
            // Save login info to session
            // Save user info to session
            // If user info saved to session, recognize as a login status
            session.setAttribute("userId", user.getId());
            session.setAttribute("userFullName", user.getFullName());
            session.setAttribute("userName", user.getUserName());

            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;
    }

    @GetMapping("/duplicateId")
    public Map<String, Boolean> duplicateId(@RequestParam("email") String email) {

        boolean isDuplicate = userService.isDuplicateId(email);

        Map<String, Boolean> resultMap = new HashMap<>();
        if (isDuplicate) {
            resultMap.put("isDuplicate", true);
        } else {
            resultMap.put("isDuplicate", false);
        }

        return resultMap;

    }


    @PostMapping("/signUp")
    public Map<String, String> signUp(
            @RequestParam("email") String email
            , @RequestParam("password") String password
            , @RequestParam("fullName") String fullName
            , @RequestParam("userName") String userName
            , @RequestParam("contactNumber") String contactNumber
            , @RequestParam("gender") String gender
            , @RequestParam("birth") String birth
            , @RequestParam("introduction") String introduction) {


        User user = userService.addUser(email, password, fullName, userName, contactNumber, gender, birth, introduction);

        Map<String, String> resultMap = new HashMap<>();
        if (user != null) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;
    }
}

package com.test.controller;

import com.test.handler.QueryHandler;
import com.test.helper.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/managerUserPermissions")
@Controller
public class UsersPermissionController {
    @Autowired
    private QueryHandler queryHandler;

    @GetMapping
    public String getUserPermissions(ModelMap modelMap) {
        Table table = queryHandler.getUsers();
        modelMap.addAttribute("users", table.getRows());
        return "userPermissions";
    }
}

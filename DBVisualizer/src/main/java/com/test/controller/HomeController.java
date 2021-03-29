package com.test.controller;

import com.test.handler.QueryHandler;
import com.test.helper.Table;
import com.test.helper.TableHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/home")
@Controller
public class HomeController {
    @Autowired
    private QueryHandler queryHandler;
    @Autowired
    private TableHeaders tableHeaders;

    @GetMapping
    public String getHomePage(ModelMap model) {
        List<String> tableNames = new ArrayList<>(queryHandler.getAllTables());
        this.tableHeaders.setAllTables(tableNames);
        model.addAttribute("table", new Table(new ArrayList<>()));
        model.addAttribute("tables", tableNames);
        model.addAttribute("toShow", false);
        model.addAttribute("tableName", "");
        return "home";
    }


}

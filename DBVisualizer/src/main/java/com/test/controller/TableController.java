package com.test.controller;

import com.test.db.QueryBuilder;
import com.test.handler.QueryHandler;
import com.test.helper.Table;
import com.test.helper.TableHeaders;
import org.eclipse.jetty.server.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import java.io.IOException;

@RequestMapping("/table/*")
@Controller
public class TableController {
    @Autowired
    private TableHeaders tableHeaders;
    @Autowired
    private QueryHandler queryHandler;

    @GetMapping
    public String getTableView(ModelMap modelMap, Request request) throws IOException, ServletException {
        modelMap.addAttribute("tables", tableHeaders.getAllTables());
        String pathInfo = request.getServletPath();
        String tableName = pathInfo.substring(pathInfo.lastIndexOf('/') + 1);
        modelMap.addAttribute("toShow", true);
        boolean authorised = false;
        if (tableHeaders.getAccessibleTables().contains(tableName)) {
            authorised = true;
            modelMap.addAttribute("tableName", tableName);
        }
        modelMap.addAttribute("authorised", authorised);
        return "home";
    }

    @PostMapping()
    public String getTableData(QueryBuilder queryBuilder, ModelMap modelMap) {
        String query = queryBuilder.generateQuery();
        Table table = queryHandler.getTableInfo(query);
        modelMap.addAttribute("tables", tableHeaders.getAllTables());
        modelMap.addAttribute("table", table);
        return "home";
    }

}

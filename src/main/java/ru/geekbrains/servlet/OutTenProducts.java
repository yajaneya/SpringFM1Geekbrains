package ru.geekbrains.servlet;

import org.slf4j.LoggerFactory;
import ru.geekbrains.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OutTenProducts", urlPatterns = "/ten_products" )
public class OutTenProducts extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(OutTenProducts.class);
    private int count_requests;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        count_requests++;
        logger.info(count_requests + " Product Request");
        String [] name = {"Молоко", "Крендель", "Творог",
                           "Пицца", "Хлеб булочный", "Гречка 5кг", "Цитрус",
                            "Лосось 4кг", "Головач гриб", "Кальмар сушеный"};
        int [] cost = {50, 39, 158, 550, 25, 220, 124, 7350, 580, 1345};
        resp.setHeader("Content-Type", "text/html; charset=utf-8");
        for (int i = 0; i<name.length; i++)  {
            resp.getWriter().println("<h3>" + new Product(i+1, name[i], cost[i]) + "<h3>");
        }
        resp.getWriter().close();
    }
}

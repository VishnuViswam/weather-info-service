package com.service.weather.controller.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for the Swagger API doc.
 *
 * @author Vishnu
 * @version 1.0
 * @since 2021-12-28
 */
@Controller
public class SwaggerDocController {
    @RequestMapping("/apidoc")
    public String home() {
        // By default following is the access URL of Swagger API doc.
        // So we are redirecting the request as follows
        return "redirect:/swagger-ui/index.html";
    }
}

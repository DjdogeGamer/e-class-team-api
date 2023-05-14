package eclass.hackthon.mercedesbenz.io.eclassteam.controller;

import eclass.hackthon.mercedesbenz.io.eclassteam.service.DeeplinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ModelController {

    @Autowired
    private DeeplinkService deeplinkService;

    @GetMapping("/model/{model}/deeplink")
    public String getDeeplink(@PathVariable String model) {
        return deeplinkService.fetchDeeplink(model);
    }
}

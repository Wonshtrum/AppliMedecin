package server.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import server.json.SimpleResponse;
import server.json.TestJson;

@Controller
@ResponseBody
public class Controllers {
    @GetMapping("/test")
    public SimpleResponse view() {
        SimpleResponse res = new SimpleResponse();
        res.put("test", "yolo");
        return res;
    }

    @GetMapping("/test2")
    public SimpleResponse view2() {
        int[] b = {1,2,3};
        return new SimpleResponse(new TestJson(1, b, 5.5));
    }
}

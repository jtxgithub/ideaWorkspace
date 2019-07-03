package com.xwtec.ssmdemo.controller;

import com.xwtec.ssmdemo.config.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * hello控制器
 */
@RestController
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;
    @Value("${name}")
    private String name;
    @Value("${age}")
    private String age;

    @Autowired
    private Girl girl;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.print("================2.0分支");
        return "hello world";
    }

    /**
     * 中文乱码
     *
     * @return
     */
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1() {
        return cupSize + "=====" + name + "========" + age;
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2() {
        return girl.getName() + "==" + girl.getAge();
    }

    @RequestMapping(value = {"/hello3", "/hi"}, method = RequestMethod.GET)
    public String hello3() {
        return girl.getName() + "==" + girl.getAge();
    }


    @RequestMapping(value = {"/hi1/{id}"}, method = RequestMethod.GET)
    public String hi1(@PathVariable("id") Integer id) {
        return id.toString();
    }

    @RequestMapping(value = {"/hi2"}, method = RequestMethod.GET)
    public String hi2(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id) {
        return id.toString();
    }


    @GetMapping("/hi3")
    public String hi3(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id) {
        return id.toString();
    }


    public static void main(String[] args) {

        Integer b = new Integer(10);
        int c = b.intValue();



        int f=10000;


    }
}

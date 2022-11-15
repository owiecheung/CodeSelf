package com.vtxlab.demo.helloworld.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vtxlab.demo.helloworld.service.HelloworldService;

//Controller does not do the business logic 


@RestController //ResponseBody + Controller
@RequestMapping(value = "/api/v1")
public class HelloworldController {

  //Restful API
  @GetMapping(value = { "/helloworld/{str}/age/{age}", "/helloworld/age" })
  //  api/v1/helloworld
  public String helloworld(
      @PathVariable(value = "str" , required = false) String str,
      @PathVariable(value = "age" , required = false) Integer age) 
      throws Exception{
    if(str == null || age == null){
      return "xyz";
    }
    if ("abc".equals(str) && age > 30){
      return "GG GGG f" + str;
    }
    return "1233" +" "+ str + 1*5;
  }


@GetMapping(value = "/greeting")

    public String greeting(@RequestParam String gender,@RequestParam String age) {
      if ("M".equals(gender) && "2".equals(age)){
        return "Gender : " + gender +" and Age : " + age;
      }
    return "You are Bigger than 2 yeah~";
  }
  

  @GetMapping(value = "/sum")
  public Integer sum(@RequestParam Integer int1, @RequestParam Integer int2){
    if(int1 == null ){
      return int2;
    }else if(int2 == null){
      return int1;
    }
    return   int1 + int2;
  }

  @GetMapping(value = "/reverseString/{str}")
  public  String reverseString(
    @PathVariable(value = "str" , required = false)String s) throws NullPointerException {
    // if s = "ABC", return "CBA"
    // if s = "AC D", return "D CA"
    // if s = " A B ", return " B A "
    // if s = "", return ""
    // if s = null, return null
    // tips: s.length()
    // tips: if s = "ABCD", s.subString(1,3) = "BC"
    // tips: if s = "ABCD", s.substring(3, 4) = "D"
    if (s.equals(null)) {
      throw new NullPointerException("This String is null.");
    }
    if (s.length() <= 1) {
      return s;
    }
    return  s.substring(s.length() - 1, s.length()) + reverseString(s.substring(0, s.length() - 1));
  }


  @GetMapping(value = {"/coffeeOrtea/{x}", "/coffeeOrtea/"})

  public String coffeeOrtea(
    @PathVariable Optional<String> x){
   //   x.ifPresent(e -> {
    //    String a = e + "vvv";
    //  });

    String var = "Hi is me!";

    if("coffee".equals(x.get()) || "1".equals(x.get())){
      return var + " coffee!";
    }
    if("tea".equals(x.get()) || "2".equals(x.get())){
      return var +" tea!!!";
    }

      x.ifPresent(e -> {   //Consumer cann't return
      e = e +var;
       });

      if(x.isPresent()){
        return x.get();
       }
       return "this is null";
  }


  @GetMapping(value = "/name/{name}")
  public String getname(
    @PathVariable Map<String,String> name){

      for (Map.Entry<String, String> c : name.entrySet()) {    
        return ("key = " + c.getKey() + " and value = " + c.getValue());    
       }    

    return (String.valueOf(name.size()));
  }

  @GetMapping(value = "/name1/{name}/age/{age}")
  public String getname1(
    @PathVariable Map<String,String> map){
  
        return ("Name = " + map.get("name") + " , Age = " + map.get("age") + 
        "\nTotal Size : " +(String.valueOf(map.size())));    
  }


  @Autowired
  //this is runtime to connect
  //compiler wont new a object
  public HelloworldService helloworldService;

  @GetMapping(value = {"/helloworld/{name}","/helloworld/"})
  public String gethelloworld(
    @PathVariable(value = "name", required = false) String name) throws Exception{
   //   HelloworldService helloworldService = new HelloworldService(); already @Autowired above

   if(name.equals(null)){
    throw new NullPointerException("it is null");
   }

    return helloworldService.sayhello(name);
  }

  @GetMapping(value = {"helloworld/list/{name}/{name2}",
  "helloworld/list/{name}"})
  public List<String> gethelloworldByList(
    @PathVariable Map<String,String> map){

      List<String> strings = new ArrayList<>();
      map.forEach((a,b) -> {
        strings.add(helloworldService.sayhello(b));
      });
      return strings;
    }
  
    /* 
    @GetMapping(value = {"helloworld/map/{name}/{name2}",
    "helloworld/map/{name}"})
    public Map<String, List<String>> gethelloworldByMap(
      @PathVariable Map<String,List<String>> map){

        List<String> strings = new ArrayList<>();
    //    map.forEach((a,b) -> {
      //    strings.add(helloworldService.sayhello(b));
     //   });

    }
    */
}

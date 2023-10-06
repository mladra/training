package mladra.domain.hello_world.boundary;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldResource {

    @GetMapping
    public String helloWorld() {
        return "Hello world!";
    }

}

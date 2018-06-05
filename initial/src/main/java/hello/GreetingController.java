package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/greeting/{id}")
   public Greeting greeting(@PathVariable Integer id)
         throws NoSuchRequestHandlingMethodException {

      try {

         Greeting greeting = data.getGreeting(id);
         return greeting;

      } catch (IndexOutOfBoundsException e) {
         throw new NoSuchRequestHandlingMethodException("greeting",
               GreetingController.class);
      }

   }


}
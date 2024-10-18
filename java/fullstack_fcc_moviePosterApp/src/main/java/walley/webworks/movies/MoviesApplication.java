package walley.webworks.movies;

import org.springframework.boot.SpringApplication;                     // SpringApplication class contains .run() method. must call 'SpringApplication.run(ApplicationName.class, args)'
import org.springframework.boot.autoconfigure.SpringBootApplication;   //
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;         // tells compiler the class is a 'Rest API Controller'

/* from FreeCodeCamp's Java Spring / React / MongoDB tutorial
    https://www.youtube.com/watch?v=5PdEmeopJVQ&t=12s
    backend code: https://github.com/fhsinchy/movieist
    frontend code: https://github.com/GavinLonDigital/movie-gold-v1
    this application uses the MongoDB Atlas website as the database
    https://cloud.mongodb.com/
    also we use Postman for the API:
    https://www.postman.com/downloads/
    we also use the TMDB API:

    and Spring Initializr:
    https://start.spring.io/
*/


// annotation -- the annotation tells the Java compiler what the class does
@SpringBootApplication
// @RestController //
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

/* GetMapping tells the compiler that 'apiRoot()' is an endpoint
	@GetMapping("/")
	public String apiRoot() {
		return "Hola, Frenz!";
	}
*/

}

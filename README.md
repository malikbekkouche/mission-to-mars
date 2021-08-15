# Welcome to Mars!

Hi! Here is my attempt to colonize Mars.

I have decided to keep it nice and simple. Simple for me means clean code and unit testing.
I would have loved adding extra features but that was not possible without sacrificing the code quality due to the lack of time on my side.

The project is built with Spring boot and can be tested through a REST API or through the command line.

But before going into how we can run the project there are a few things to note.
# Assumptions

 **A robot can only know what previous robots know**
 From the requirement :

> lost robots leave a robot "scent" that prohibits future robots from
> dropping off the world at the same grid point

I have assumed that the scent is directed, meaning if a robot falls off at grid point (3,2) while moving north the next robot will only ignore instructions to move north from that point. It will not ignore moving forward in any other direction or rotating 90 degrees left or right.

## Execution
### Command Line
You can execute the service's .jar file or build and run the service thgourh an IDE (I have used IntelliJ). Once it has started follow the instructions shown in the console.

### REST API
The service can be tested through a REST API, via Postman for example, by sending the input in the request body as a JSON (if using Postman set the request body to raw and request type to JSON. check src/main/resources/static/ for more information).

The example input from the requirement file can be found under src/main/resources/static/example-input.json

The call should be done to the following end point : localhost:8080/sendMissionToMars




 

# Java-Authorization-JWT-api
 Java API that creates a valid JWT tokken
 
## Description

Create a JWT Tokken here in  ["HEROKU"](https://jwt-java-example.herokuapp.com/api/login)  


### How do receive a JWT tokken?

Send a post request:

    POST https://jwt-java-example.herokuapp.com/api/login
    Accept: application/json

With an Example JSON:

    {
        "username": "John Doe",
        "password": "123" 
    }

The Response is the json representation of the JWT Tokken with the client name.

## Stay in touch

- Author - [João Pedro Vilares](https://joao-vilares.web.app)


## License

  OpenSource

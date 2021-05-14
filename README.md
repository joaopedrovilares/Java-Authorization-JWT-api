# Java-Authorization-JWT-api
 Java API that creates a valid JWT tokken
 
## Description

Create a JWT Tokken here ["JWT"](http://jwt-java-example.herokuapp.com/)  


### How do receive a JWT tokken?

To reiceve a jwt Tokken do the following:

    POST http://jwt-java-example.herokuapp.com/
    Accept: application/json

The key/secret are obtained when creating the Resource Server in the admin GUI of the Authorization Server.

The Response is the json representation of the tokenInfo with the client name, the Principal information and the expiry time (if set for this client).

    {
        "username": "John Doe",
        "password": "123" 
    }



## Stay in touch

- Author - [João Pedro Vilares](https://joao-vilares.web.app)


## License

  OpenSource

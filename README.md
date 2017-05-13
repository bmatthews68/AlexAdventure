# Adventure

Play text based adventure games with Amazon Alexa.

## Bluemix

The intent handlers for the Adventure Skill are hosted by a Spring Boot application written
in Java running in a Docker container on IBM Bluemix.
 
### DNS Configuration

We added a CNAME alias to the coderdojowarehouse.com domain so that we can use a custom
domain for the Docker containers.

```
adventure.coderdojowarehouse.com. CNAME  secure.eu-gb.bluemix.net.
```

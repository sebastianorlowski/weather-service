<h2>Weather Service</h2>

The main task of the service is to send requests to an external API and receive weather messages at the indicated coordinates. 
The messages are stored in a database to create a history on the weather for use in creating future statistics. 
The service regularly sends messages via a message broker to other applications.

Service has two modules
- integrator
- messenger

<b>The integrator</b> configures the connection to the external source and receives messages, which it maps to the appropriate model and send further
to <b>messenger</b> and <b>auto-completer</b>

<b>The messenger</b> receives messages from the integrator and saves them in the database and exposes them for other services.
Contains messages about weather for appropriate destination and has the <b>auto-completer</b> 
to helps complete the destination model data if it has not been completed.

<h3>Technology stack</h3>

- Spring WebFlux
- MongoDB
- RabbitMQ
- AsyncAPI

Service use AsyncAPI approach to create appropriate contact model to send messages via RabbitMQ.
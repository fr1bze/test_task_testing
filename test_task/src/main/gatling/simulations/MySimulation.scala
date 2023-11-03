package com.example.demo.gatling.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class MySimulation extends Simulation {
  val httpConf = http.baseUrl("http://localhost:8080")
  GatlingLogger.logger.info("Setting log level to DEBUG")
  GatlingLogger.setLevel(LogLevel.Debug)

  val scn = scenario("Send Messages to Kafka")
    .exec(http("Send Message")
      .post("/api/send-message")
      .body(StringBody("""{"message": "test message"}"""))
      .header("Content-Type", "application/json")

        .check(status.is(200)))

//check fail test
  val scn = scenario("Send Messages to Kafka")
    .exec(http("Send Message")
      .post("/api/send-message")
      .body(StringBody("""{"message": "test message"}"""))
      .header("Content-Type", "application/json")
    //  .check(status.is(500)))  //check 500 internal status

  setUp(scn.inject(
    constantUsersPerSec(10) during (10 seconds)
  )).protocols(http.baseUrl(baseURL))
}
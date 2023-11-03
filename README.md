# test_task_testing
Данное приложение реализовано на SpringBoot с использованием таких инструментов, как Kafka, Docker, Java, Java SpringBoot, а также тестирование с использованием Gatling.
docker-compose.yml содержит основные образы, а именно: Zookeeper, kafka.
Для их подсоединения необходимо прописать из корневой папке src в терминале "docker-compose up -d"
Далее отправляется POST запрос вида "сurl -X POST -H "Content-Type: application/json" -d '{"message":"Hello, Kafka!"}' http://localhost:8080/api/send-message"
После чего с запущенным KafkaMessageConsumer можно увидеть ответ

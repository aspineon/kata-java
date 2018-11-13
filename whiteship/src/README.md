# Spring REST API study

## 1. Simple REST API: Greeting

```
Request
GET /greeting?name=greeter HTTP/1.1
```

```
Response
HTTP/1.1 200 OK

{"id":1, "content": "Hello, greeter!"}
```

* 기능: name 파라미터를 받아 환영하는 메시지를 응답한다.
* name 파라미터가 없을 경우 'World'를 기본값으로 응답한다.
* id를 정수형으로 리턴한다.
# Spring REST API study

## 0. Simple REST API: Greeting
이거슨 테스트
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

## 1. REST API: Events

### 기능구현 목표

* 이벤트 생성
* 이벤트 수정
* 이벤트 삭제
* 이벤트 조회
  * 다건
  * 단건

### 이벤트 생성

```plain
POST /api/events HTTP/1.1
이벤트를 생성하는 API 작성
  `id`는 서버에서 생성
```

### 이벤트 조회

#### 다건

```plain
GET /api/events HTTP/1.1
```

#### 단건

```plain
GET /api/events/{id} HTTP/1.1
```
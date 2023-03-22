# hello world

### 실행파일
- 
- `java -jar deploy/arothy1-search.jar`

### 구성
- backend
  - spring boot 3.0.4
  - h2 DB
  - JPA
- frontend
  - vue2
  - vuetify2.x


### api docs
- springdoc
    - `http://localhost:8080/swagger-ui/index.html`

### dependencies
- spring-cloud-openfeign
  - rest api 의 간편구현
- springdoc
  - swagger

### 특이사항
- vuetify 내장 pagination 이 정상작동하지 않아 prev, next 페이지 형식으로 구현

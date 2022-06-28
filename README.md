### Spring Boot에 Redis 연동 
***
* 해당 프로젝트에서는 단순히 스프링부트에서 Redis를 캐시 메모리로 어떻게 활용할지를 테스트하기 위함이므로 따로 swagger 연동 등을 하지 않음
* 테스트 및 결과 확인은 postman으로 진행
* get-list API 에서 호출시 db count 횟수가 더 이상 늘지 않음을 확인함
* @CacheEvict을 add 서비스 메서드에 달아 저장시마다 캐시 정보를 삭제(refresh) 되도록 함
* 추후 joda time의 serialization 추가 예정

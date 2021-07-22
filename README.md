> # API Reference

* users(닉네임 입력/수정 수정필요)

|기능|Method|URL|Request|Response|
|----------|-----|---------|-----------|-------------|
  |회원가입   |POST|api/users/signup|{<br/>"id":"123abc",<br/> "password":"abcd1234"<br/>}|succes { "code" : 200, "message" : "Success" }<br/>fail { "code" : 500, "message" : "Fail" }|
|로그인|POST|api/users/login|{<br/>"id":"123abc",<br/> "password":"abcd1234"<br/>}|succes { "code" : 200, "message" : "Success" }<br/>fail { "code" : 500, "message" : "Fail" }|
|로그아웃|DELETE|api/users/logout|{<br/>"id":"123abc"<br/>}|succes { "code" : 200, "message" : "Success" }<br/>fail { "code" : 500, "message" : "Fail" }|
|닉네임 입력/수정|UPDATE|api/users/login|{<br/>"id":"123abc"<br/>}|succes { "code" : 200, "message" : "Success" }<br/>fail { "code" : 500, "message" : "Fail" }|

<br/><br/>

* game-ox(수정왕많이필요)

|기능|Method|URL|Request|Response|
|----------|-----|---------|-----------|-------------|
  |ox문제 목록|GET|api/ox-game/questions/{user_nickname}||{<br/>"id":"13"<br/>"stage":"1",<br/> "question_num":"3"<br/> "question":"가야금은 줄이 12개이다."<br/>"answer":"true"<br/>}|
|오답노트 가져오기|GET|api/ox-game/wrong-questions||{<br/>"stage":"1",<br/> "question_num":"3"<br/> "question":"가야금은 줄이 12개이다."<br/>"answer":"true"<br/>}|
|오답노트에 문제 추가|POST|api/ox-game/wrong-questions|{<br/>"id":"25"<br/>"stage":"2",<br/> "question_num":"5"<br/> "question":"단소는 구멍이 5개이다."<br/>"answer":"true"<br/>}|succes { "code" : 200, "message" : "Success" }<br/>fail { "code" : 500, "message" : "Fail" }|
|오답노트에서 문제 제거|DELETE|api/ox-game/wrong-questions/{id}|{<br/>"id":"13"<br/>}|succes { "code" : 200, "message" : "Success" }<br/>fail { "code" : 500, "message" : "Fail" }|

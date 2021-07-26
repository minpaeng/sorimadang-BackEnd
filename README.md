> # API Reference

* users - 로그인 시 해당 유저의 오답 정보 가져옴

|기능|Method|URL|Request|Response|
|----------|-----|---------|-----------|-------------|
  |회원가입   |POST|api/users/signup|{<br/>"user_id":"123abc",<br/> "password":"abcd1234"<br/>}|succes { "code" : 200, "message" : "Success" }<br/>fail { "code" : 500, "message" : "Fail" }|
|로그인|POST|api/users/login|{<br/>"user_id":"123abc",<br/> "password":"abcd1234"<br/>}|succes<br/>{<br/>&emsp;"serial_id": 1,<br/>&emsp;"user_id": {<br/>&emsp;&emsp;"user_id": "123abc",<br/>&emsp;&emsp;"password": "abcd1234",<br/>&emsp;&emsp;"nickname": "도드리"<br/>&emsp;},<br/>&emsp;"gameOXQuiz": {<br/>&emsp;&emsp;"stageNum": 1,<br/>&emsp;&emsp;"quizNum": 1,<br/>&emsp;&emsp;"quiz": "가야금은 12줄이다."<br/>&emsp;&emsp;"answer": 1<br/>&emsp;}<br/>}<br><br/>fail { "code" : 500, "message" : "Fail" }|
|닉네임 입력/수정|PUT|api/users|{<br/>"user_id":"123abc",<br/> "nickname":"도드리"<br/>}|123abc|
|회원 정보 조회|GET|api/users||{<br/>"user_id":"123abc",<br/> "password":"abcd1234",<br/> "nickname":"도드리"<br/>}|


<br/><br/>

* game-ox - 오답노트 가져올때 게임 관련 column만 가져오도록 수정해야함 / 오답노트 문제 제거 아직 구현 x

|기능|Method|URL|Request|Response|
|----------|-----|---------|-----------|-------------|
  |ox문제 목록|GET|api/ox-game/questions||{<br/>"stageNum":1,<br/> "quizNum":1,<br/>"quiz":"가야금은 12줄이다.",<br/>"answer":1<br/>}|
|오답노트 가져오기|GET|api/ox-game/wrong-questions||{<br/>&emsp;"serial_id": 1,<br/>&emsp;"user_id": {<br/>&emsp;&emsp;"user_id": "123abc",<br/>&emsp;&emsp;"password": "abcd1234",<br/>&emsp;&emsp;"nickname": "도드리"<br/>&emsp;},<br/>&emsp;"gameOXQuiz": {<br/>&emsp;&emsp;"stageNum": 1,<br/>&emsp;&emsp;"quizNum": 1,<br/>&emsp;&emsp;"quiz": "가야금은 12줄이다."<br/>&emsp;&emsp;"answer": 1<br/>&emsp;}<br/>}|
|오답노트에 문제 추가|POST|api/ox-game/wrong-questions|{<br/>&emsp;"user_id": {<br/>&emsp;&emsp;"user_id":"123abc"<br/>&emsp;},<br/>&emsp;"quiz":{<br/>&emsp;&emsp;"stageNum":"1",<br/>&emsp;&emsp;"quizNum":"1"<br>&emsp;}<br/>}|{<br/>&emsp;"serial_id": 1,<br/>&emsp;"user_id": {<br/>&emsp;&emsp;"user_id": "123abc",<br/>&emsp;&emsp;"password": null,<br/>&emsp;&emsp;"nickname": null<br/>&emsp;},<br/>&emsp;"gameOXQuiz": {<br/>&emsp;&emsp;"stageNum": 1,<br/>&emsp;&emsp;"quizNum": 1,<br/>&emsp;&emsp;"quiz": null<br/>&emsp;&emsp;"answer": 0<br/>&emsp;}<br/>}|
|오답노트에서 문제 제거|DELETE|api/ox-game/wrong-questions/{id}|{<br/>"id":"13"<br/>}|succes { "code" : 200, "message" : "Success" }<br/>fail { "code" : 500, "message" : "Fail" }|

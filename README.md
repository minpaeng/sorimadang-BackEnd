> # API Reference

select query 사용(유저 오답 정보 가져올 때) / WrongQuiz(오답 정보) 테이블 외래키 사용

<br/>

* users

|기능|Method|URL|Request|Response|
|----------|-----|---------|-----------|-------------|
|회원탈퇴  |DELETE|/api/user|{<br/>"idToken":"토큰 입력"<br/>}|삭제된 email 주소<br/>|
|로그인|POST|/api/user|{<br/>"idToken":"토큰 입력"<br/>}|{<br/>"createdAt": "처음 로그인한 날짜 및 시간",<br/>"modifiedAt": "마지막 로그인한 날짜 및 시간",<br/>"email": "이메일 주소",<br/>"nickname": "닉네임"<br/>}|
|닉네임 입력/수정|PUT|api/user|{<br/>"idToken":"토큰 입력",<br/> "nickname":"닉네임 입력"<br/>}|입력한 닉네임|
|회원 정보 조회|GET|/api/users| |{<br/>"user_id":"123abc",<br/> "password":"abcd1234",<br/> "nickname":"도드리"<br/>}|


<br/><br/>

* game-ox

|기능|Method|URL|Request|Response|
|----------|-----|---------|-----------|-------------|
|오답노트 가져오기|POST|/api/ox-game/wrong-questions/search|{<br/>"idToken":"토큰 입력"<br/>}|{<br/>"wrongQuizs": [<br/>{<br/>"serialId": 14,<br/>"gameOXQuiz": {<br/>"stage_num": 2,<br/>"quiz_num": 5,<br/>"quiz": "가야금은 10줄이다.",<br/>"answer": 0<br/>}<br/>}<br/>]<br/>}|
|오답노트에 문제 추가|POST|/api/ox-game/wrong-questions/save|{<br/>"idToken":"토큰 입력",<br/>"stage_num":1,<br/>"quiz_num":3 <br/>}|{<br/>"serialId": 14,<br/>"gameOXQuiz": {<br/>"stage_num": 2,<br/>"quiz_num": 5,<br/>"quiz": "가야금은 10줄이다.",<br/>"answer": 0<br/>}<br/>}|
|오답노트에서 문제 제거|DELETE|/api/ox-game/wrong-questions/remove |{<br/>"idToken":"토큰 입력",<br/>"stage_num":1,<br/>"quiz_num":3 <br/>}|{<br/>"stage_num": 1,<br/>"quiz_num": 3,<br/>"quiz": "가야금은 3줄이다.",<br/>"answer": 0<br/>}|

<br/><br/>

* gugakgi

|기능|Method|URL|Request|Response|
|----------|-----|---------|-----------|-------------|
|전체 국악기 정보|GET|/api/gugakgis| |[<br/>{<br/>"id": 1,<br/>"akgiName": "당피리",<br/>"imageUrl": "https://s3.ap-northeast-2.amazonaws.com/sorimadang.shop/1/Dangpiri.png",<br/>"soundUrl": "https://s3.ap-northeast-2.amazonaws.com/sorimadang.shop/1/sound-source/Dangpiri.wav"<br/>}<br/>]|
|관악기, 타악기, 현악기 별로 정보 가져오기|GET|/api/gugakgi?type=관악기| |{<br/>"id": 1,<br/>"dataType": "관악기",<br/>"gugakgi": [<br/>{<br/>"id": 1,<br/>"akgiName": "당피리",<br/>"imageUrl": "https://s3.ap-northeast-2.amazonaws.com/sorimadang.shop/1/Dangpiri.png",<br/>"soundUrl": "https://s3.ap-northeast-2.amazonaws.com/sorimadang.shop/1/sound-source/Dangpiri.wav"<br/>}<br/>]<br/>}|
|오답노트에서 문제 제거|DELETE|/api/ox-game/wrong-questions/remove |{<br/>"idToken":"토큰 입력",<br/>"stage_num":1,<br/>"quiz_num":3 <br/>}|{<br/>"stage_num": 1,<br/>"quiz_num": 3,<br/>"quiz": "가야금은 3줄이다.",<br/>"answer": 0<br/>}|

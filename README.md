# java-oncall
비상 근무 생성 프로그램

### 주요 기능
- 날짜 
  - LocalDate localDate = LocalDate.of(2023, 5, 1);
  - localDate.getDayOfWeek() :  요일

### 플로우
1. 월, 시작 요일을 입력받는다.
2. 평일 사원을 입력받는다. + 유효검사(중복,이름 글자수,최대,최소 인원) - name equals
3. 주말 사원을 입력받는다. + 유효검사(중복,이름 글자수,최대,최소 인원)
4. 평일 + 주말 유효검사(동일한지) - list equals
5. 평일인지 주말인지 + 평일인 경우 공휴일인지
  -  평일 : 평일 인원을 추가
 - 주말 : 주말 인원을 추가
6. 일단 평일, 주말 리스트를 다 만들어 둔 후 겹치는 사원 자리 변경해주기

### 유효 검사
- 근무 월, 요알
  - 해당 월의 시작 요일여야한다.

- 사원
  - 중복되지 않는다.
  - 최소 5~35명의 인원이여야한다.
  - 사원의 이름은 최대 5글자여야야한다.
  - 평일, 휴일 참여 인원이 같아야한다?
  - 평일, 유일 참여 인원 수가 같아야한다.

### 예외 메시지
- [ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.

### 주의할 점
- 2월은 매년 28일만 있다.
<
- 비상 근무자는 평일 순번, 휴일 순번에 각각 1회 편성되어야 한다
- 2일 연속 근무할 수 없다. 
  - 만약 연속으로 근무하는 경우, 다음 근무자와 순서를 바꿔 편성한다.
    - 연속으로 근무하는 경우 -> 평일-주말 연결 부분이 겹치는 경우
    - 어차피 평일-주말끼리는 2일이 연속될 수가 없음

- 평일이면서 공휴일인 경우 요일 위에 (휴일)을 표기한다.
  - 5월 5일 금(휴일) 루루

- staff equal, comapre 정의

#### 예시
- 수아(평일) -> 수아(주말) -> 루루(주말)
  - 수아(평일) -> 루루(주말) -> 수아(주말)
- 수아(공휴일)-> 수아(평일) 일 경우
  - 수아(공휴일) -> 수아평일다음사람(평일) -> 수아(평일)
- 


# java-oncall

## 기능 구현 목록

### 기능 요구 사항

- [ ] 입력 텍스트를 월(숫자)로 변환한다.
- [ ] 입력 텍스트를 쉼표를 기준으로 분할한다.
- [ ] 비상근무자 닉네임은 5자를 넘어서는 안 된다.
- [ ] 근무자는 최소 5명 이상 35명 이하여야 한다.
- [ ] 법정 공휴일
    - 1월 1일 신정
    - 3월 1일 삼일절
    - 5월 5일 어린이날
    - 6월 6일 현충일
    - 8월 15일 광복절
    - 10월 3일 개천절
    - 10월 9일 한글날
    - 12월 25일 성탄절
- [ ] 기본적으로 순번에 따라 비상 근무일을 배정한다.
- [ ] 회사에서는 평일과 휴일(토요일, 일요일, 법정공휴일) 비상 근무 순번을 다르게 운영하고 있다.
- [ ] 비상 근무자는 평일 순번, 휴일 순번에 각각 1회 편성되어야 한다.
    - 비상 근무자는 평일 순번에 중복해서 들어있을 수 없다.
    - 비상 근무자는 휴일 순번에 중복해서 들어있을 수 없다.
    - 평일 순번에 있다면 휴일 순번에도 있어야 한다.

- [ ] 근무자 보호와 비상 근무 운영의 효율을 위해, 비상 근무자는 어떤 경우에도 연속 2일은 근무할 수 없다.
    - 오늘이 평일이고 다음 날이 휴일인데 근무자 같으면 다음 휴일 근무자와 순서를 바꾼다.
    - 오늘이 휴일이고 다음 날이 평일인데 근무자 같으면 다음 평일 근무자와 순서를 바꾼다.

### 입력

- [ ] 월(숫자)과 시작 요일(일-토) 정보를 쉼표로 구분하여 입력받는다.
- [ ] 연도는 고려하지 않고, 매년 2월은 28일까지만 있다.
- [ ] 평일 비상 근무 순서를 입력받는다.
    - 이름은 쉼표로 구분한다.
- [ ] 휴일 비상 근무 순서를 입력받는다.
    - 이름은 쉼표로 구분한다.
- [ ] 사용자의 잘못된 입력의 경우, 에러 메시지 출력 후 재입력밥는다.

### 출력

- [X] 비상 근무를 배정할 월과 시작 요일을 입력하세요>
- [X] 평일 비상 근무 순번대로 사원 닉네임을 입력하세요>
- [X] 휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>
- [ ] 비상 근무표 생성 결과
  [ ] 평일이면서 법정 공휴일일 때만 요일 뒤에 (휴일) 표기를 한다.
- [X] 에러 메시지는 [ERROR]로 시작해야 한다.
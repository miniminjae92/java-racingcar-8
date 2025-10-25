# 미션: 자동차 경주
- 초간단 자동차 경주 게임을 구현한다.

## 핵심기능 선별
 
- Car
  - [x] 5자 이하의 이름을 가진다.
  - [x] 전진 또는 정지 기능이 있다, move(무작위값)
  - [x] 위치를 가진다.
- Cars
  - [x] Car 객체를 생성한다.
  - [x] 무작위 값을 받아서 객체마다 전달한다.
  - [x] 중복된 이름에 대해서 검사한다.
- RacingGame
  - [x] 게임 한 라운드를 진행한다.
  - [x] 라운드가 모두 완료되면 우승자를 반환한다.
  - [x] n대의 자동차는 move()한다.
- RandomNumbers
  - [x] 0에서 9 사이에서 무작위 값을 주어진 사이즈만큼 생성한다
- GameController
  - [x] 주어진 횟수만큼 라운드를 진행한다.
  - [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- InputView
  - [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- OutputView
  - [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

## 도메인 객체 선별

- Car
  - move()
  - getName(), getPosition()
- Cars
  - moveAll()
  - getWinnerNames()
  - getSize(), getCars()
- RacingGame
  - runOnRound()
  - getWinners()
- RandomNumbers
  - generateRandomNumbers()
 
## 가정 & 정의

* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    * 자동차 이름은 영어, 숫자, 한글만 가능하다고 가정한다.
* 경주에 참가하는 자동차는 한 대 이상이어야한다고 가정한다.

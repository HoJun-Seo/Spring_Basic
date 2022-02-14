package hello.core.singleton;


public class SingletonService {

    // static 키워드를 통해 자기 자신의 객체를 생성한다.
    // 이렇게 해두면 해당 객체는 클래스 레벨로 올라가기 때문에 유일하게 하나만 존재할 수 있다.
    private static final SingletonService instance = new SingletonService();

    // public 으로 열어서 객체 인스턴스가 필요하면 이 static 메소드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance(){
        return instance;
    }

    // 생성자를 private 으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}

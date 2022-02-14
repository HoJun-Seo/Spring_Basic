package hello.core.singleton;

public class StatefulService {

//    private int price; // 상태를 유지하는 필드
    
    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기가 문제!
        return price; // 입력으로 들어온 price 필드를 리턴으로 넘겨준다.
    }

//    public int getPrice(){
//        return price;
//    }
}

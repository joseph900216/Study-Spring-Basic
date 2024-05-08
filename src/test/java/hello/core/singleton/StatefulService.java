package hello.core.singleton;

public class StatefulService {

//    스프링빈의 무상태 설계 -> 지역변수 등을 활용
//    공유 필드를 사용하게 되면 문제가 생긴다
//    private int price; //상태 유지 필드(=공유필드)

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice() {
//        return price;
//    }

}

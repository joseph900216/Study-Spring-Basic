package hello.core.singleton;

public class SingletonService {

    //static -> class lavel(class내 1개만 존재)
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService() {
        //new 생성 제한
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}

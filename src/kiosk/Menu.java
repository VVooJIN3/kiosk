package kiosk;

public class Menu {
    //필수 요구사항
    //메뉴 클래스는 이름, 설명 필드를 가지는 클래스로 만들어주세요.
    //1) 고유 데이터 영역
     private String name;
     private String description;

     public Menu(String name, String description){
         this.name = name;
         this.description = description;
     }
     public void Show(){
         System.out.printf("%-15s | %s\n", name, description);
     }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
package kiosk;

public class Product extends Menu {

    //    int number; 부모로부터 상속
    //필수요구사항
    //상품 클래스는 이름, 가격, 설명 필드를 가지는 클래스로 만들어주세요.
    //상품 클래스의 이름, 설명 필드는 메뉴 클래스를 상속받아 사용하는 구조로 개발해주세요.
    private double price;
    private String category;
    public Product(String name, String description, double price, String category) {
        super(name, description);
        this.price = price;
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public String getCategory(){
        return category;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void Show()
    {
        System.out.printf("%-20s | W %s |%s\n", getName(), price,getDescription());
    }

}
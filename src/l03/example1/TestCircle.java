package l03.example1;

public class TestCircle {
  /** Main method */
  public static void main(String[] args) {
    // Create a circle with radius 5.0
    Circle myCircle = new Circle(5.0);
    System.out.println("myCircle�İ뾶�� " +  myCircle.radius);
    System.out.println("myCircle������� " +  myCircle.getArea());

    System.out.println("-----------------------------------------------");
    
    // Create a circle with radius 1
    Circle yourCircle = new Circle();
    System.out.println("yourCircle�İ뾶�� " +  yourCircle.radius);
    System.out.println("yourCircle������� " +  yourCircle.getArea());

    System.out.println("-----------------------------------------------");
    
    // Modify circle radius
    yourCircle.radius = 100;
    System.out.println("yourCircle�İ뾶�� " +  yourCircle.radius);
    System.out.println("yourCircle������� " +  yourCircle.getArea());
  }
}

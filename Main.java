interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class ShapeFactory {
    private static ShapeFactory ins = null;
    private ShapeFactory(){}
    public static ShapeFactory getInstance()
    {
        if (ins == null)
            ins = new ShapeFactory();
        return ins;
    }


    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}


public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = ShapeFactory.getInstance();
        ShapeFactory ssh = ShapeFactory.getInstance();
        System.out.println(shapeFactory.hashCode());
        System.out.println(ssh.hashCode());
        //ShapeFactory shapeFactory = new ShapeFactory();
        //Shape shape1 = shapeFactory.getShape("CIRCLE");shape1.draw();
        Shape shape2 = shapeFactory.getShape("RECTANGLE");shape2.draw();
    }
}


package Task1;

public class Bed {
    private int width;
    private int length;
    private String material;
    private String color;
    private boolean isDouble; 

    public Bed(int width, int length, String material, String color, boolean isDouble) {
        setWidth(width);
        setLength(length);
        setMaterial(material);
        setColor(color);
        setDouble(isDouble);
    }

    public int getWidth() { return width; }
    
    public void setWidth(int width) {
        if (width < 70 || width > 240) {
            throw new IllegalArgumentException("Некорректная ширина кровати! Допустимо от 70 до 240 см.");
        }
        this.width = width;
    }

    public int getLength() { return length; }
    
    public void setLength(int length) {
        if (length < 120 || length > 250) {
            throw new IllegalArgumentException("Некорректная длина кровати! Допустимо от 120 до 250 см.");
        }
        this.length = length;
    }

    public String getMaterial() { return material; }
    
    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            throw new IllegalArgumentException("Поле 'Материал' не может быть пустым!");
        }
        this.material = material.trim();
    }

    public String getColor() { return color; }
    
    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Поле 'Цвет' не может быть пустым!");
        }
        this.color = color.trim();
    }

    public boolean isDouble() {
        return isDouble;
    }

    public void setDouble(boolean isDouble) {
        this.isDouble = isDouble;
    }

    @Override
    public String toString() {
        return "Кровать: материал=" + material + 
               ", ширина=" + width + " см" + 
               ", длина=" + length + " см" + 
               ", цвет=" + color + 
               ", тип=" + (isDouble ? "двуспальная" : "односпальная");
    }
}
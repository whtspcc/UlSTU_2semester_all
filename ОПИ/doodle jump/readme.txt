потенциальные задания:

1. поменять фон на черный (в качестве примера возьмем фон в самой игре)
TODO: 
в классе gamePanel находим метод paintComponent. Комментим строки, где устанавливается фон. Далее вставляем
/----------------------------------------------------/
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
/----------------------------------------------------/

2. поменять текст (например в оверлее при окончании игры)
TODO:
в классе gamePanel находим метод drawGameOverScreen и находим соответсвующий текст, меняем его.

3. сделать хитбоксы видимыми
TODO:
сначала заходим в класс entityDoodleJump. видим метод drawHitbox и метод paint. методом сложной дедукции вставляем
метод drawHitbox в метод paint.
с классом entityPlatform немного труднее, придется в методе paint записать строку:
/----------------------------------------------------/
       	g.drawRect( (int) x, (int) y, width, height);
/----------------------------------------------------/

4. убери звук какой нибудь (например, звук прыжка)
TODO:
заходим в класс entityDoodleJump и в методе jump комментим playSoundJump(). PROFIT!!!

5. сделай, чтобы дудлик прыгал выше на [...] ИЛИ сделай гравитацию как на луне
TODO:
заходим в класс entityDoodleJump и в методе jump меняем velocity = -15 на velocity -30 и тд...
ИЛИ
заходим в тот же класс и меняем gravity = 0.5 в конструкторе на gravity = 0.1.... 

6. сделай, чтобы платформы (например ломающиеся) появлялись реже
TODO:
заходим в класс gamePanel и ищем метод managePlatforms. ищем строку с размещение платформ (if (random.nextInt(100) < 80) {)
и меняем 80 на число меньше
ЕСЛИ ЗАХОЧЕТ УМЕНЬШИТЬ ЧИСЛО ОБЫЧНЫХ ПЛАТФОРМ ХЗ ПОКА НЕ ПРИДУМАЛ


Пример панели пустышки номер 1:
package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class xz extends JPanel {
    public xz() {
        setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // фон
        g.setColor(Color.WHITE);
        g.drawString("Панель-пустышка", 100, 150);
    }
}



пример панели пустышки номер 2(быстрее):
MenuPanel menuPanel = new MenuPanel(menuDoodle, 
            () -> {
            cardLayout.show(mainContainer, "GAME");
            gamePanel.requestFocusInWindow();
            timer.start(); 

            JFrame nothing = new JFrame("доп панель");
            JScrollPane scrollpane = new JScrollPane(logArea);
            nothing.setSize(300, 500);
            nothing.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            nothing.setLocation(100, 100);
            nothing.add(scrollpane);

            nothing.setVisible(true);
        }, 


ЕСЛИ ПОПРОСИТ ДОБАВИТЬ НОВУЮ ПАНЕЛЬ ГДЕ БУДЕТ СЧЕТЧИК ОТПРЫГНУТЫХ ПЛАТФОРМ:
1. СОЗДАЕМ В МЕНЮПАНЕЛЬ НОВУЮ ЖФРЕЙМ, ДОБАВЛЯЕМ ТАКЖЕ В МЕЙНФОРМ НОВОЕ ПОЛЕ JTEXTAREA
2. ВЫБИРАЕМ SETSIZE ДЛЯ НОВОГО ЖФРЕЙМА, СЕТЛОКЕЙШН И ДОБАВЛЯЕМ В НЕГО ПРЕДВАРИТЕЛЬНО ДОБАВЛЕННЫЙ
JSCROLLPANE ИЗ JTEXTAREA
3.ДЕЛАЕМ ДЛЯ ЖФРЕЙМА SETVISIBLE TRUE И ПЕРЕХОДИМ В ТАЙМЕР В ТОМ ЖЕ КЛАССЕ, ГДЕ ДЛЯ JTEXTAREA ПИШЕМ SETTEXT И ВСТАВЛЯЕМ ТУДА ТЕКСТ
"ПЕРЕПРЫГНУТО ПЛАТФОРМ: " + GamePanel.platformCounter;
4. ПЕРЕХОИДМ В КЛАСС ЕНТИТИДУДЛГАЙ ГДЕ В МЕТОДЕ ЧЕК КОЛЛИЖН ПОСЛЕ JUMP В САМОМ КОНЦЕ ПЕРЕД RETURN ПИШЕМ
drawing.GamePanel.platformCounter++;
5. САМО ПОЛЕ platformCounter в GamePanel У НАС УЖЕ ЕСТЬ.
import javax.swing.JOptionPane;

abstract class WaterTank {
    protected int capacity;
    protected int currentLevel = 0;

    public WaterTank(int capacity) {
        this.capacity = capacity;
    }

    public abstract void fillTank(int liters);
    public abstract void useWater(int liters);
    public abstract void checkStatus();
}

class HomeTank extends WaterTank {
    public HomeTank() {
        super(200);
    }

    @Override
    public void fillTank(int liters) {
        currentLevel = Math.min(currentLevel + liters, capacity);
        JOptionPane.showMessageDialog(null,
                liters + " liters added. Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public void useWater(int liters) {
        currentLevel = Math.max(currentLevel - liters, 0);
        JOptionPane.showMessageDialog(null,
                liters + " liters used. Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public void checkStatus() {
        if (currentLevel == 0)
            JOptionPane.showMessageDialog(null, "Tank is Empty!");
        else if (currentLevel == capacity)
            JOptionPane.showMessageDialog(null, "Tank is Full!");
        else
            JOptionPane.showMessageDialog(null, "Tank is In Use.");
    }
}

class BuildingTank extends WaterTank {
    public BuildingTank() {
        super(1000);
    }

    @Override
    public void fillTank(int liters) {
        currentLevel = Math.min(currentLevel + liters, capacity);
        JOptionPane.showMessageDialog(null,
                liters + " liters added. Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public void useWater(int liters) {
        currentLevel = Math.max(currentLevel - liters, 0);
        JOptionPane.showMessageDialog(null,
                liters + " liters used. Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public void checkStatus() {
        if (currentLevel == 0)
            JOptionPane.showMessageDialog(null, "Tank is Empty!");
        else if (currentLevel == capacity)
            JOptionPane.showMessageDialog(null, "Tank is Full!");
        else
            JOptionPane.showMessageDialog(null, "Tank has " + currentLevel + " liters.");
    }
}

public class WaterTankProgram {
    public static void main(String[] args) {
        String choice = JOptionPane.showInputDialog("Choose tank: (1) HomeTank (2) BuildingTank");
        WaterTank tank = choice.equals("1") ? new HomeTank() : new BuildingTank();

        while (true) {
            String action = JOptionPane.showInputDialog(
                    "Choose action:\n(1) Fill Tank\n(2) Use Water\n(3) Check Status");
            if (action.equals("1")) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to fill:"));
                tank.fillTank(liters);
            } else if (action.equals("2")) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to use:"));
                tank.useWater(liters);
            } else {
                tank.checkStatus();
            }

            if (tank.currentLevel == 0) {
                JOptionPane.showMessageDialog(null, "Tank is Empty! Program ended.");
                break;
            } else if (tank.currentLevel == tank.capacity) {
                JOptionPane.showMessageDialog(null, "Tank is Full! Program ended.");
                break;
            }
        }
    }
}
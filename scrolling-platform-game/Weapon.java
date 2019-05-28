import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Basic ground object.
 * 
 * @author Joe
 * @version May 8, 2019
 */
public class Weapon extends Other
{
    /**
     * Constructor
     * 
     * Called once when object is created.
     */
    Weapon(int scrollableWorldX, int scrollableWorldY)
    {
        super(scrollableWorldX, scrollableWorldY);
        setImage("SMB2-EnemiesObjects.png");
    }

    /**
     * Act - do whatever the Fence wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        enemyFire();
    }  

    private void enemyFire()
    {
        if (Greenfoot.getRandomNumber(80) < 1)
        {
            getWorld().addObject(new EnemyFire(), getX(), getY());                  
        }
    } 
}

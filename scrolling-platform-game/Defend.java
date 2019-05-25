import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Defend here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Defend extends Actor
{
    private boolean hasBeenRemoved;

    /**
     * Constructor
     * 
     * Runs once when object created
     */
    Defend ()
    {
        hasBeenRemoved = false;
       
    }

    
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {       
        

        setLocation(getX()  + speed, getY());
        checkBoundaries();
        if (hasBeenRemoved == false)
        {
            checkCollision();       
        }
    }

    // Remove bullets if they are off screen
    public void checkBoundaries()
    { 
        if (getX() == 20) 
        {
            hasBeenRemoved = true;
            getWorld().removeObject(this);
        }
    }

    // Set the speed of the bullet 
    private int speed = 8;

    // Remove asteroid if touched and add points 
    public void checkCollision()
    {
        if (isTouching(MetalPlate.class)) 
        {
            removeTouching(MetalPlate.class);             
            World world = (SideScrollingWorld) getWorld();         
            world.removeObject(this);
        }
    }

}

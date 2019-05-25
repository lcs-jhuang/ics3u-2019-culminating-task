import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Template for a side-scrolling platform game.
 * 
 * @author R. Gordon
 * @version May 8, 2019
 */
public class SideScrollingWorld extends World
{
    /**
     * Instance variables
     * 
     * These are available for use in any method below.
     */    
    // Tile size in pixels for world elements (blocks, clouds, etc)
    // TO STUDENTS: Modify if your game's tiles have different dimensions
    private static final int TILE_SIZE = 32;
    private static final int HALF_TILE_SIZE = TILE_SIZE / 2;

    // World size constants
    // TO STUDENTS: Modify only if you're sure
    //              Should be a resolution that's a multiple of TILE_SIZE
    private static final int VISIBLE_WIDTH = 640;
    private static final int VISIBLE_HEIGHT = 480;

    // Additional useful constants based on world size
    public static final int HALF_VISIBLE_WIDTH = VISIBLE_WIDTH / 2;
    private static final int HALF_VISIBLE_HEIGHT = VISIBLE_HEIGHT / 2;

    // Defining the boundaries of the scrollable world
    // TO STUDENTS: Modify SCROLLABLE_WIDTH if you wish to have a longer level
    public static final int SCROLLABLE_WIDTH = VISIBLE_WIDTH * 3;
    private static final int SCROLLABLE_HEIGHT = VISIBLE_HEIGHT;

    // Hero
    Hero theHero;

    // Track whether game is on
    private boolean isGameOver;

    // for health level
    public int healthLevel = 10;

    /**
     * Constructor for objects of class SideScrollingWorld.
     */
    public SideScrollingWorld()
    {    
        // Create a new world with 640x480 cells with a cell size of 1x1 pixels.
        // Final argument of 'false' means that actors in the world are not restricted to the world boundary.
        // See: https://www.greenfoot.org/files/javadoc/greenfoot/World.html#World-int-int-int-boolean-
        super(VISIBLE_WIDTH, VISIBLE_HEIGHT, 1, false);

        // Set up the starting scene
        setup();

        // Game on
        isGameOver = false;
    }

    /**
     * Set up the entire world.
     */
    private void setup()
    {       
        addGround();
        addHills();
        addWeapons();
        addPlane();
        addHero();
        showScore();
    }

    // show health level
    public void showScore()
    {
        showText("Health Level: " + healthLevel, VISIBLE_WIDTH / 5, VISIBLE_HEIGHT / 6);
    }

    // Change health Level
    public void changeScoreBy(int thisMuch)
    {
        healthLevel += thisMuch;
        showScore();
    }

    /**
     * Add plane that would attack.
     */
    private void addPlane()
    {
        int x = 15 * TILE_SIZE + HALF_TILE_SIZE;
        int y = 4 * TILE_SIZE + HALF_TILE_SIZE;
        Cloud Plane = new Cloud(x, y);
        addObject(Plane, x, y);
    }

    /**
     * Add blocks to create the ground to walk on.
     */
    private void addGround()
    {
        // add gound below
        for (int i = 0; i <= 60; i += 1)
        {
            // location
            int x = i * TILE_SIZE;
            int y = 13 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            GroundBelow Below = new GroundBelow(x, y);
            addObject(Below, x, y);
        }
        for (int i = 0; i <= 60; i += 1)
        {
            // location
            int x = i * TILE_SIZE;
            int y = 14 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            GroundBelow Below = new GroundBelow(x, y);
            addObject(Below, x, y);
        }

        // add ground
        for (int i = 0; i <= 60; i += 1)
        {
            // location
            int x = i * TILE_SIZE;
            int y = 12 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            Ground someGround = new Ground(x, y);
            addObject(someGround, x, y);
        }
    }

    /**
     * Add weapons that would attack the hero.
     */
    private void addWeapons()
    {
        for (int i = 0; i <= 0; i += 1)
        {
            int x = 11 * TILE_SIZE + HALF_TILE_SIZE;
            int y = 9 * TILE_SIZE + HALF_TILE_SIZE;
            Weapon Weapon = new Weapon(x, y);
            addObject(Weapon, x, y);
        }
        for (int i = 0; i <= 0; i += 1)
        {
            int x = 18 * TILE_SIZE + HALF_TILE_SIZE;
            int y = 8 * TILE_SIZE + HALF_TILE_SIZE;
            Weapon Weapon = new Weapon(x, y);
            addObject(Weapon, x, y);
        }
        for (int i = 0; i <= 0; i += 1)
        {
            int x = 33 * TILE_SIZE + HALF_TILE_SIZE;
            int y = 8 * TILE_SIZE + HALF_TILE_SIZE;
            Weapon Weapon = new Weapon(x, y);
            addObject(Weapon, x, y);
        }
        for (int i = 0; i <= 0; i += 1)
        {
            int x = 40 * TILE_SIZE + HALF_TILE_SIZE;
            int y = 8 * TILE_SIZE + HALF_TILE_SIZE;
            Weapon Weapon = new Weapon(x, y);
            addObject(Weapon, x, y);
        }
    }

    /**
     * Add hills that can be destroied
     */
    private void addHills()
    {

        // second
        for (int i = 0; i <= 2; i += 1)
        {
            //location
            int x = 10 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 11 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }
        for (int i = 0; i <= 1; i += 1)
        {
            //location
            int x = 11 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 10 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }

        // third
        for (int i = 0; i <= 2; i += 1)
        {
            //location
            int x = 18 * TILE_SIZE +  i * TILE_SIZE;
            int y = 11 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }
        for (int i = 0; i <= 2; i += 1)
        {
            //location
            int x = 18 * TILE_SIZE +  i * TILE_SIZE;
            int y = 10 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }
        for (int i = 0; i <= 1; i += 1)
        {
            //location
            int x = 18 * TILE_SIZE +  i * TILE_SIZE;
            int y = 9 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }

        // fourth
        for (int i = 0; i <= 4; i += 1)
        {
            //location
            int x = 30 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 11 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }
        for (int i = 0; i <= 2; i += 1)
        {
            //location
            int x = 32 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 10 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }
        for (int i = 0; i <= 3; i += 1)
        {
            //location
            int x = 32 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 9 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }

        // fifth
        for (int i = 0; i <= 2; i += 1)
        {
            //location
            int x = 40 * TILE_SIZE +  i * TILE_SIZE;
            int y = 11 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }
        for (int i = 0; i <= 2; i += 1)
        {
            //location
            int x = 40 * TILE_SIZE +  i * TILE_SIZE;
            int y = 10 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }
        for (int i = 0; i <= 1; i += 1)
        {
            //location
            int x = 40 * TILE_SIZE +  i * TILE_SIZE;
            int y = 9 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }

        // sixth
        for (int i = 0; i <= 3; i += 1)
        {
            //location
            int x = 45 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 11 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }
        for (int i = 0; i <= 1; i += 1)
        {
            //location
            int x = 46 * TILE_SIZE + HALF_TILE_SIZE + i * TILE_SIZE;
            int y = 10 * TILE_SIZE + HALF_TILE_SIZE;

            // create and add to world
            MetalPlate Hill = new MetalPlate(x, y);
            addObject(Hill, x, y);
        }
    }

    /**
     * Add the hero to the world.
     */
    private void addHero()
    {
        // Initial horizontal position
        int initialX = TILE_SIZE * 3;

        // Instantiate the hero object
        theHero = new Hero(initialX);

        // Add hero in bottom left corner of screen
        addObject(theHero, initialX, 2 * TILE_SIZE);
    }

    /**
     * Return an object reference to the hero.
     */
    public Hero getHero()
    {
        return theHero;
    }

    /**
     * Set game over
     */
    public void setGameOver()
    {
        isGameOver = true;
    }
}


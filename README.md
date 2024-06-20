# BoxKeeper
(2024S1)Java Term Project

## ProjectMember
### 22100597 Lee Hyang Woo

## Project Description

### MainFrame (`BoxKeeperApp.java`)

The `MainFrame` class manages the main window of the game. It initializes and displays the starting screen using the `Start()` method, handling user interactions. When the user clicks "Start Game" in the `StartMenu`, it transitions to the main game screen through a `StartMenuListener`.

---

### StartMenu (`StartMenu.java`)

The `StartMenu` constructs the initial screen of the game. It includes elements such as the game title and a "Start Game" button. Clicking the "Start Game" button triggers a `StartMenuListener`, initiating the switch to the main game screen.

---

### MainPanel (`MainPanel.java`)

The `MainPanel` class builds the main game screen. Using `JLayeredPane`, it layers backgrounds, player, and monsters to compose the game view. It manages user input via `KeyInputManager` and handles `Player` and `Monster` objects to control characters and enemies.

---

### Player (`Player.java`)

The `Player` class represents the player character. It responds to user input for movement and updates graphics accordingly. It manages the player's state and position, updating graphics to reflect movements based on input.

---

### Background (`Back.java`, `Front.java`)

The `Back` and `Front` classes define the game backgrounds. Each extends `JPanel` to draw background images and implements scrolling based on player input to create visual effects.

---

### Monster (`Monster.java`)

The `Monster` class represents enemy characters in the game. It manages interactions with the player, attacking or moving based on proximity. Each monster handles its own movement and attack animations, updating graphics to display actions on screen.

---

### InteractionManager (`InteractionManager.java`)

The `InteractionManager` class manages interactions between key game objects. It controls interactions between the player and monsters, adjusting monster movement and attacks based on specific conditions.

---

This codebase sets up a basic structure for a 2D platformer game engine, where user inputs drive game state and graphics updates. Each class operates independently, utilizing `KeyInputManager` for user input processing to update the game screen.


## UML Diagram
<img src='https://github.com/unhappy1030/BoxKeeper/blob/dev/Images/readme/UML_Diagram.png'>


## Component Diagram
<img src='https://github.com/unhappy1030/BoxKeeper/blob/dev/Images/readme/Component_Diagram.png'>


### BoxKeeper Game User Guide

**1. Starting the Game:**
   - Launch the game by running the BoxKeeper application (`BoxKeeperApp`).
   - The main window titled "BoxKeeper" will appear.

**2. Main Menu:**
   - Upon starting, you'll see the Start Menu screen.
   - It displays the game title "Box Keeper" and a dynamic animation.
   - Click the "Start Game" button to begin playing.

**3. Gameplay:**
   - **Controls:**
     - Use the left and right arrow keys to move the player character.
     - The character responds to key presses by walking left or right.
   
   - **Objective:**
     - Navigate the player character through the game environment.
     - Avoid or defeat monsters encountered along the way.
     - Reach the end of the level to progress further.

**4. Game Screen:**
   - The main game screen (`MainPanel`) displays the game environment.
   - It includes backgrounds, player character, and moving monsters.
   - Monsters may attack when in close proximity to the player.

**5. Interaction and Feedback:**
   - **Player Actions:**
     - Interact with the game environment using arrow keys.
     - The player character's movements are visually represented on screen.
   
   - **Enemy Interactions:**
     - Monsters move and attack based on predefined game logic.
     - Avoid monster attacks by navigating strategically.

**6. Ending the Game:**
   - Play until you complete the level objectives or lose all lives.
   - Navigate through challenges to advance to higher levels.

**7. Closing the Game:**
   - Close the game window to exit.
   - Progress is automatically saved for the next session.

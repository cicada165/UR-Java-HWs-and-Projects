Project 4 
 
Collaboration:  
Member1  Name: Yue Liu  NetID yliu165  TR 940-1055  TA Mustafa Ali 
Member2  Name: Daiwei Zhang  NetID dzhang28  TR 940-1055  TA Rahaf Alqarni  
 
IMPORTANT: First Press Enter Then Drag or Click Mouse to enter the game.  If click Mouse before press enter, game may not be displayed due to unknown reason and I can’t fix it. 
 
Game Instruction:  In this game, please Drag Mouse on any location on the screen to control the paddle to intercept the ball before falling through the bottom. 
 
If ball falls through the bottom. You lose one life and another ball is launched (without creating a new GameCanvas) 
 
You have three lives. And there are three levels. Enter Level2 gains you 5 points and enter Level3 gains you 10 points. As you enter next level, the countdown is longer, paddle is smaller, and the ball is faster. Good Luck. 
 
The paddle, the top and sides of the windows and two random obstacles can all bounce the balls. But only ball bounces off the paddle you controlled can gain you one point! (Possible bug: ball may be trapped in the obstacle for a very short time. This doesn’t affect your scores, and this is a cool feature of this game!) 
 
There is a moving object in this game. Every 0.01s the ball in this object can give you 1 point. But it also speeds up your ball by 1.05 every 0.01s! 
 
About Different Classes 
 
GameTest.java includes the main method. It runs you through the whole game by switching between different canvas. For each Level, it creates a new GameCanvas. 
 
GameCanvas.java animates the movement of ball, objects and information. It contains Timer and MouseHandler. 
 
Ball.java includes variables and methods of ball’s movement 
 
(Extra Credit) SpeedUpObj.java creates non-stationary object (Extra Credit) Obstacles.java creates stationary object 
 
WelcomeCanvas.java displays welcome message. It includes keylistener. GoodbyeCanvas.java displays final message of the game 
 
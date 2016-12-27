/*
 * This game is a kind of Tetris Game.
 * To collapse the balls to get scores, it should be needed
 * to link three the same color rectangular adjacently along
 * the way of horizontal direction. I used the skill of game 
 * tutorial to make this game and refered to the w3schools.
 * There are still some bugs in my this coding.
 *  
 * name: Sung Woo Lee(leeduris@gmail.com)
 * create date: Jan 29 2016
 * update date: Feb 03 2016
 */

// create variable of rectangular game piece
var myGamePiece;

// width and height of game piece
var squareSize = 54;

// check total game pieces used in playing game 
var turn = 1;

// create variable to store game piece's color
var rgbSum;

// create array to assign color randomly to a game piece
var ballColor = ["blue", "red", "yellow", "green", "orange"];

// make a game piece to play then assign the x-y coordinate to drop down at the top of the starting point   
function startGame() 
{	
	var random = Math.random();
	myGamePiece = new component( parseInt( random*8 ) * 54, 40, squareSize, squareSize, ballColor[parseInt( random*5 )] );
	myGameArea.start();
}

// set the game area then make rules to play game
var myGameArea = 
{
	// select the object of canvas
	canvas : document.querySelector( "canvas" ),	
	
	// initiate the starting environment 
	start : function() 
	{	
		// make the object of context
        if(turn == 1)
		{
			this.canvas.width = 432;
			this.canvas.height = 580;  
			this.context = this.canvas.getContext( "2d" );
			this.context.rect(0,0,this.canvas.width,this.canvas.height);
			this.context.stroke();
			var insert = document.querySelector('#insert');
			insert.insertBefore(this.canvas, insert.childNodes[0]); 
			//document.body.insertBefore(this.canvas, document.querySelectorAll('h1').childNodes[0]);  // (this.canvas, document.body.childNodes[0])
		}
		
		// reinvoke to update the position of game piece 
		this.interval = setInterval( updateGameArea, 50 );      
        
		// make the event handler with keyboard to move the game piece
        window.addEventListener('keydown', function (e) {
            myGameArea.key = e.keyCode;
        })
        window.addEventListener('keyup', function (e) {
            myGameArea.key = false;
        })
    },
    
	// cancel the reinvoke in the given condition
	stop : function() 
	{   
        clearInterval( this.interval );
    },
	
	// stop the playing game or restart playing game 
    clear : function() 
	{
		var gameAgain = confirm("Game Over! Then, Try Again?");
		if(gameAgain)
		{
			this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
			startGame();
		}
    }
}

// make or clear the game pieces according to the given condition then set the movement of game piece  
function component(x, y, width, height, color)
{
    // crerate variables of the coordinates of game piece 
	this.x = x;
    this.y = y;    
    this.width = width;
    this.height = height;
    this.speedX = 0;
    this.speedY = 0;    
    this.gravitySpeed = 0;
    this.gravity = 0.1;
	
	// set the rules of movements of game piece 
	this.update = function() 
	{
		// draw the start line to play game
        ctx = myGameArea.context;
		ctx.moveTo(0,139);
		ctx.lineTo(432,139);
		ctx.stroke();
		ctx.fillStyle = color;
		
		// clear the trace of prevoius game piece when the right arrow key down
		if(myGameArea.key == 37)
		{   
		    // ckeck the existing game piece to the left direction to move then clear the trace of game piece at the position of staying just before  
			if(isDifferentColorLeftBall())
				ctx.clearRect(this.x, 43, this.width, this.y );
			
			// claear the trace of game piece which had been in the right hand just before
			else
				ctx.clearRect(this.x + squareSize, this.y-10 , this.width, this.height+10);
		}
		
		
		else if(myGameArea.key == 39)
		{
			// ckeck the existing game piece to the right direction to move then clear the trace of game piece at the position of staying just before 
			if(isDifferentColorRightBall())
				ctx.clearRect(this.x, 43, this.width, this.y );
		    
			// claear the trace of game piece which had been in the left hand just before
			else
				ctx.clearRect(this.x - squareSize, this.y-10 , this.width, this.height+10);
		}
		
		// clear the tarce of previous game piece unless no keyborad event
		else
			ctx.clearRect(this.x, 43, this.width, this.y );
		
		// ckeck the left barrier of game area then don't allow to move that way
		if( this.x <= 0 && this.x <= ( myGameArea.canvas.width - squareSize ) )
			this.x = 0;

		// ckeck the right barrier of game area then don't allow to move that way
		if( this.x >= ( myGameArea.canvas.width - squareSize ) )
			this.x = myGameArea.canvas.width - squareSize;		
	
		// make game piece 
		ctx.fillRect( this.x, this.y, this.width, this.height );
		
		// store the color information of the spot underneath moving game piece 
		var bellowBallColor = ctx.getImageData(this.x+5 , this.y+squareSize+5, 1, 1);
		rgbSum= bellowBallColor.data[0] + bellowBallColor.data[1] + bellowBallColor.data[2];
	}
    
	// let the game piece move drop down
	this.newPos = function() 
	{   
		// accelerate to the direction of downward 
		this.gravitySpeed += this.gravity;
		
        this.x += this.speedX
		this.y += this.speedY + this.gravitySpeed;		
        this.hitBottom();
	}
    
	// check arrival of game piece at the bottom then verify if it has 3 adjacent game pieces and overstacked to the start line to determin stop the game. 
	this.hitBottom = function() 
	{
		// create variable of height to the bottom
        var rockbottom = myGameArea.canvas.height - squareSize; 		
        
		// ckeck if the game piece hit the bottom
		if (this.y >= rockbottom || rgbSum != 0 )  
		{   
			// set accerlate zerp  
			this.gravitySpeed = 0;
			
			// verify if it has 3 adjacent game pieces
			if(turn != 1)
				checkCollapse();
			
			// procede again unless no 3 adjacent game pieces
			myGameArea.stop();
			turn++;
			startGame();
			return true;
		}				
  
		// verify game piece overstacked to the start line to determin stop the game. 
		if( checkGameEnd() )
		{
			myGameArea.stop();
			myGameArea.clear();						
		}
		
		return false;
	}
}

// reinvoke to let game piece move 
function updateGameArea() 
{		
	// respond to the keyboard event 
    if (myGameArea.key && myGameArea.key == 37 && !isDifferentColorLeftBall()) {myGamePiece.x += -squareSize; }
	if (myGameArea.key && myGameArea.key == 39 && !isDifferentColorRightBall()) {myGamePiece.x += squareSize; }

	myGamePiece.newPos();
	myGamePiece.update();	
}

// return true if the left adjacent game piece exists 
function isDifferentColorLeftBall()
{
	ctx = myGameArea.context;
	var leftBallColor = ctx.getImageData(myGamePiece.x - squareSize, myGamePiece.y+squareSize, squareSize, squareSize);
	var leftColor = leftBallColor.data[0] + leftBallColor.data[1] + leftBallColor.data[2];
	if( leftColor != 0 )
		return true;
	else 
		return false;
}

// return true if the right adjacent game piece exists 
function isDifferentColorRightBall()
{
	ctx = myGameArea.context;
	var rightBallColor = ctx.getImageData(myGamePiece.x + squareSize, myGamePiece.y+squareSize, squareSize, squareSize);
	var rightColor = rightBallColor.data[0] + rightBallColor.data[1] + rightBallColor.data[2];
	if( rightColor != 0 )
		return true;
	else 
		return false;
}

// function of checking if game piece overstacked to the start line to determin stop the game.
function checkGameEnd() 
{
	var stackCount = 0;
	
	// loop for setting row direction to check 
	outLoof:
	for(var w = squareSize/2; w < squareSize*8+squareSize/2; w += squareSize)
	{
		// loop for setting the position of the top end from bottom end until finding the same color adjacent game pieces
		inLoof:
		for(var h = 160 - squareSize/2 + squareSize*8; h >= 160 - squareSize/2; h -= squareSize)
		{
			ctx = myGameArea.context;
			var existedBallColor = ctx.getImageData(w, h, 1, 1);
			var stackColor = existedBallColor.data[0]+existedBallColor.data[1]+existedBallColor.data[2];
			if( stackColor != 0 )				
				stackCount++;		
		}

		// ckeck if overstacked 	
		if(stackCount == 9)	
		{	
			return true;
			break outLoof;			
		}
		
		// reset to ckeck another new rows
		else 
			stackCount = 0;
	}
	
	return false;
}

// function to find the 3 adjacent the same color game pieces in the way of row.
function checkCollapse()
{
	var count = 1;	
	var start=0;
	var end=0;
	var BallColor =  myGameArea.context.getImageData(myGamePiece.x+10, myGamePiece.y+10, 1, 1);
	for( var s=1; s>=-1; s-=2)
	{
		for( var i = s*squareSize; Math.abs(i) <= squareSize*2; i+=s*squareSize) 
		{   
			if( myGamePiece.x+i >= 0 && myGamePiece.x+i <= myGameArea.canvas.width - squareSize )
			{   
				var colorExist = myGameArea.context.getImageData( myGamePiece.x + 10 + i, myGamePiece.y + 10, 1 , 1);
				if( isSameColor(BallColor, colorExist) )
				{					
					count += 1;
				}
	
				else break;
			}
			
			if( s == 1 )
				end = (count-1);
				
		}	
	
		// copy and paste the upper whole game pieces in the direction of having the same rows if finding 3 adjacent game pieces 
		if(count >= 3)
		{	
			start = (3 - end - 1);
			var width = squareSize * 3;
			var imgData = myGameArea.context.getImageData( myGamePiece.x-start*squareSize, 140, width, myGamePiece.y-140);
			myGameArea.context.clearRect(myGamePiece.x-start*squareSize, myGamePiece.y-10, width, squareSize+1 );
			myGameArea.context.putImageData(imgData, myGamePiece.x-start*squareSize, 140+squareSize+1);
		}
	}
}

// check whether the game pieces are the same color 
function isSameColor(imgDataP, imgDataQ) 
{
	if( imgDataP.data[0] == imgDataQ.data[0] &&
		imgDataP.data[1] == imgDataQ.data[1] &&
		imgDataP.data[2] == imgDataQ.data[2] )
				
		return true;
}




